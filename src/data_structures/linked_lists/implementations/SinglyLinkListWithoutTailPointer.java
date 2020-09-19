package data_structures.linked_lists.implementations;

import data_structures.linked_lists.interfaces.LinkedListInterface;
import data_structures.linked_lists.nodes.SingleLinkNode;

public class SinglyLinkListWithoutTailPointer<E> implements LinkedListInterface<E> {
    SingleLinkNode<E> head;
    int size = 0;

    public SinglyLinkListWithoutTailPointer() {
        this(null);
    }
    public SinglyLinkListWithoutTailPointer(SingleLinkNode<E> head) {
        this.head = head;
        if(head != null) {
            this.size += 1;
        }
    }


    @Override
    public int size() {
        // O(1)
        return this.size;
    }

    @Override
    public boolean empty() {
        // O(1)
        return this.head == null;
    }

    @Override
    public E value_at(int index) {
        SingleLinkNode<E> current = this.head;
        while (index > 0) {
            current = current.getNext();
            index -= 1;
        }
        return current != null ? current.getValue() : null;
    }

    @Override
    public void push_front(E value) {
        SingleLinkNode<E> node = new SingleLinkNode<>((E) value);
        if(this.size == 0) {
            this.head = node;
            this.size += 1;
            return;
        }

        node.setNext(this.head);
        this.head = node;
        this.size += 1;
    }

    @Override
    public E pop_front() {
        SingleLinkNode<E> current = this.head;
        this.head = this.head.getNext();
        this.size -= 1;
        return current != null ? current.getValue() : null;
    }

    @Override
    public void push_back(E value) {
        SingleLinkNode<E> current = this.head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        SingleLinkNode<E> node = new SingleLinkNode<E>((E) value);
        current.setNext(node);
        this.size += 1;
    }

    @Override
    public E pop_back() {
        if (this.head == null) {
            return null;
        }
        SingleLinkNode<E> current = this.head;
        if (this.size == 1) {
            this.head = null;
            this.size -= 1;
            return current.getValue();
        }
        while (current.getNext().getNext() != null) {
            current = current.getNext();
        }
        SingleLinkNode<E> nextNode = current.getNext();
        current.setNext(null);
        this.size -= 1;
        return nextNode != null ? nextNode.getValue() : null;
    }

    @Override
    public E front() {
        return this.head == null ? null : this.head.getValue();
    }

    @Override
    public E back() {
        SingleLinkNode<E> current = this.head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        return current != null ? current.getValue() : null;
    }

    @Override
    public void insert(int index, E value) {
        SingleLinkNode<E> node = new SingleLinkNode<>(value);
        if(index == 0) {
            node.setNext(this.head);
            this.head = node;
            this.size += 1;
            return;
        }
        SingleLinkNode<E> current = this.head;
        for(int i=0;i<index-1;i++) {
            current = current.getNext();
        }
        node.setNext(current.getNext());
        current.setNext(node);
        this.size += 1;

    }

    @Override
    public void erase(int index) {
        if (index == 0) {
            this.head = this.head.getNext();
            this.size -= 1;
            return;
        }
        SingleLinkNode<E> current = this.head;
        for(int i=0;i<index-1;i++) {
            current = current.getNext();
        }

        current.setNext(current.getNext().getNext());
        this.size -= 1;
        if (this.size == 1) {
            this.head = current;
        }
    }

    @Override
    public E value_from_n_end(int index) {
        SingleLinkNode<E> current = this.head;
        SingleLinkNode<E> prev = this.head;
        for(int i=0;i<index - 1;i++) {
            current = current.getNext();
        }
        while (current.getNext() != null) {
            current = current.getNext();
            prev = prev.getNext();
        }
        return prev.getValue();
    }

    @Override
    public void reverse() {
        SingleLinkNode<E> current = this.head;
        SingleLinkNode<E> prev = null;
        while (current != null) {
            SingleLinkNode<E> next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
        }
        this.head = prev;
    }

    @Override
    public void remove_value(E value) {
        if(this.head.getValue() == value) {
            this.head = null;
            this.size -= 1;
            return;
        }
        SingleLinkNode<E> current = this.head;
        while (!current.getNext().getValue().equals(value)) {
            current = current.getNext();
        }
        current.setNext(current.getNext().getNext());
        this.size -= 1;
    }

    @Override
    public void print() {
        SingleLinkNode<E> current = this.head;
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
