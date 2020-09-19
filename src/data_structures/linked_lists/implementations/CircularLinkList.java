package data_structures.linked_lists.implementations;

import data_structures.linked_lists.interfaces.LinkedListInterface;
import data_structures.linked_lists.nodes.SingleLinkNode;

public class CircularLinkList<E> implements LinkedListInterface<E> {

    SingleLinkNode<E> tail;
    int size;
    public CircularLinkList() {
        this(null, 0);
    }
    public CircularLinkList(SingleLinkNode<E> tail, int size) {
        this.tail = tail;
        this.size = size;
        if(this.tail != null) {
            this.tail.setNext(this.tail);
        }

    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean empty() {
        return this.tail.getNext() == null;
    }

    @Override
    public E value_at(int index) {
        SingleLinkNode<E> current = this.tail.getNext();
        while (index > 0) {
            current = current.getNext();
            index -= 1;
        }
        return current != null ? current.getValue() : null;
    }

    @Override
    public void push_front(E value) {
        SingleLinkNode<E> node = new SingleLinkNode<E>(value);
        if(this.size == 0) {
            this.tail = node;
            this.tail.setNext(this.tail);
            this.size += 1;
            return;
        }
        node.setNext(this.tail.getNext());
        this.tail.setNext(node);
        this.size += 1;
    }

    @Override
    public E pop_front() {
        if(this.tail == null) {return null;}
        if(this.size == 1) {
            SingleLinkNode<E> node = this.tail;
            this.tail = null;
            this.size -= 1;
            return node.getValue();
        }
        SingleLinkNode<E> node = this.tail.getNext();
        this.tail.setNext(node.getNext());
        this.size -= 1;
        return node.getValue();
    }

    @Override
    public void push_back(E value) {
        SingleLinkNode<E> node = new SingleLinkNode<E>(value);
        if(this.size == 0) {
            this.tail = node;
            this.tail.setNext(this.tail);
            this.size += 1;
            return;
        }
        node.setNext(this.tail.getNext());
        this.tail.setNext(node);
        this.tail = node;
        this.size += 1;
    }

    @Override
    public E pop_back() {
        if(this.tail == null) {return null;}
        if(this.size == 1) {
            SingleLinkNode<E> node = this.tail;
            this.tail = null;
            this.size -= 1;
        }
        SingleLinkNode<E> current = this.tail.getNext();
        while (current.getNext() != this.tail) {
            current = current.getNext();
        }
        SingleLinkNode<E> node = current.getNext();
        current.setNext(this.tail.getNext());
        this.tail = current;
        this.size -= 1;
        return node.getValue();
    }

    @Override
    public E front() {
        return this.tail.getNext() == null ? null : this.tail.getNext().getValue();
    }

    @Override
    public E back() {
        return this.tail == null ? null : this.tail.getValue();
    }

    @Override
    public void insert(int index, E value) {
        if(index == 0) {
            this.push_front(value);
            return;
        }
        if(index >= this.size) {
            this.push_back(value);
        }
        SingleLinkNode<E> n = new SingleLinkNode<>(value);
        SingleLinkNode<E> node = this.tail.getNext();
        for(int i=0;i<index - 1;i++) {
            node = node.getNext();
        }
        n.setNext(node.getNext());
        node.setNext(n);
        this.size += 1;
    }

    @Override
    public void erase(int index) {
        if(index == 0){
            this.pop_front();
            return;
        }
        if(index > this.size) {
            this.pop_back();
            return;
        }
        SingleLinkNode<E> node = this.tail.getNext();
        for(int i=0;i<index - 1;i++) {
            node = node.getNext();
        }
        if(node.getNext() != null) {
            node.setNext(node.getNext().getNext());
            this.size -= 1;
        }




    }

    @Override
    public E value_from_n_end(int index) {
        SingleLinkNode<E> current = this.tail.getNext();
        SingleLinkNode<E> prev = this.tail.getNext();
        for(int i=0;i<index - 1;i++) {
            current = current.getNext();
        }
        while (current.getNext() != this.tail.getNext()) {
            current = current.getNext();
            prev = prev.getNext();
        }
        return prev.getValue();
    }

    @Override
    public void reverse() {
        // nothing to for circle. You can't rotate a circle.
        return;

    }

    @Override
    public void remove_value(E value) {
        if(this.size <= 1) {
            this.tail = null;
            if(this.size > 0) {
                this.size -= 1;
            }
            return;
        }
        SingleLinkNode<E> current = this.tail.getNext();
        while (!current.getNext().getValue().equals(value)) {
            current = current.getNext();
        }
        current.setNext(current.getNext().getNext());
        this.size -= 1;
    }

    @Override
    public void print() {
        SingleLinkNode<E> current = this.tail.getNext();
        System.out.println("Size: " + this.size());
        System.out.print(current.getValue());
        while (current != this.tail) {
            if(current.getNext()!=null) {
                System.out.print(" -> ");
            }
            current = current.getNext();
            System.out.print(current.getValue());
        }
        System.out.println();

    }
}
