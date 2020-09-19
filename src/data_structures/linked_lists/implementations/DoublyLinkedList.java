package data_structures.linked_lists.implementations;

import data_structures.linked_lists.interfaces.LinkedListInterface;
import data_structures.linked_lists.nodes.DoubleLinkNode;

public class DoublyLinkedList<E> implements LinkedListInterface<E> {
    DoubleLinkNode<E> head;
    DoubleLinkNode<E> tail;
    int size;
    public DoublyLinkedList() {
        this(null, null, 0);
    }
    public DoublyLinkedList(DoubleLinkNode<E> head, DoubleLinkNode<E> tail, int size) {
        this.head = head;
        this.tail = tail;
        this.size = size;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean empty() {
        return this.head == null;
    }

    @Override
    public E value_at(int index) {
        DoubleLinkNode<E> current = this.head;
        while (index > 0) {
            current = current.getNext();
            index -= 1;
        }
        return current != null ? current.getValue() : null;
    }

    @Override
    public void push_front(E value) {
        DoubleLinkNode<E> node = new DoubleLinkNode<>(value);
        if(this.size == 0) {
            this.head = node;
            this.tail = node;
            this.size += 1;
            return;
        }

        node.setNext(this.head);
        this.head.setPrev(node);
        this.head = node;
        this.size += 1;
    }

    @Override
    public E pop_front() {
        if (this.head == null) {
            return null;
        }
        if(this.size == 1) {
            DoubleLinkNode<E> node = this.head;
            this.head = null;
            this.tail = null;
            this.size -= 1;
            return node.getValue();
        }
        DoubleLinkNode<E> node = this.head;
        this.head.getNext().setPrev(null);
        this.head = this.head.getNext();
        this.size -= 1;
        return node.getValue();
    }

    @Override
    public void push_back(E value) {
        DoubleLinkNode<E> node = new DoubleLinkNode<>(value);
        if (this.size == 0) {
            this.head = node;
            this.tail = node;
            this.size += 1;
            return;
        }

        this.tail.setNext(node);
        node.setPrev(this.tail);
        this.tail = node;
        this.size += 1;
    }

    @Override
    public E pop_back() {
        if (this.tail == null) {
            return null;
        }
        if (this.size == 1) {
            DoubleLinkNode<E> node = this.tail;
            this.head = this.tail = null;
            this.size -= 1;
            return node.getValue();
        }
        DoubleLinkNode<E> node = this.tail;
        this.tail.getPrev().setNext(null);
        this.tail = this.tail.getPrev();
        this.size -= 1;
        return node.getValue();
    }

    @Override
    public E front() {
        return this.head == null ? null : this.head.getValue();
    }

    @Override
    public E back() {
        return this.tail == null ? null : this.head.getValue();
    }

    @Override
    public void insert(int index, E value) {
        if(index == 0) {
            this.push_front(value);
            return;
        }
        if (index >= this.size) {
            this.push_back(value);
            return;
        }
        DoubleLinkNode<E> node = new DoubleLinkNode<>(value);
        DoubleLinkNode<E> current = this.head;
        for(int i=0;i<index-1;i++) {
            current = current.getNext();
        }

        node.setNext(current.getNext());
        node.setPrev(current);
        current.getNext().setPrev(node);
        current.setNext(node);
    }

    @Override
    public void erase(int index) {
        if(index == 0) {
            this.pop_front();
            return;
        }

        if (index >= this.size) {
            this.pop_back();
            return;
        }

        DoubleLinkNode<E> current = this.head;
        for(int i=0;i<index -1 ;i++) {
            current = current.getNext();
        }
        if (current.getNext().getNext() != null) {
            current.getNext().getNext().setPrev(current);
        }
        current.setNext(current.getNext().getNext());
        this.size -= 1;
    }

    @Override
    public E value_from_n_end(int index) {
        DoubleLinkNode<E> current = this.tail;
        for(int i=0;i<index-1;i++) {
            current = current.getPrev();
        }
        return current.getValue();
    }

    @Override
    public void reverse() {
        DoubleLinkNode<E> current = this.head;
        this.tail = current;
        DoubleLinkNode<E> prev = null;

        while (current != null) {
            DoubleLinkNode<E> next = current.getNext();
            current.setNext(prev);
            if(prev != null) {
                prev.setPrev(current);
            }
            prev = current;
            current = next;
        }
        this.head = prev;
    }

    @Override
    public void remove_value(E value) {
        if(this.empty()) return;
        if(this.size == 1 && this.head.getValue().equals(value)) {
            this.head = this.tail = null;
            this.size -= 1;
        }
        DoubleLinkNode<E> current = this.head;
        while (current!=null && !current.getValue().equals(value)) {
            current = current.getNext();
        }
        if(current.getPrev() != null) {
            current.getPrev().setNext(current.getNext());
        }
        if(current.getNext() != null) {
            current.getNext().setPrev(current.getPrev());
        }
        this.size -= 1;

    }

    @Override
    public void print() {
        DoubleLinkNode<E> current = this.head;
        System.out.println("Size: " + this.size());
        while (current != null) {
            System.out.print(current.getValue());
            if(current.getNext()!=null) {
                System.out.print(" -> ");
            }
            current = current.getNext();
        }
        System.out.println();
    }
}
