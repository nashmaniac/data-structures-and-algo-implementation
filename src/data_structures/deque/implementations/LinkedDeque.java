package data_structures.deque.implementations;

import data_structures.deque.interfaces.DequeInterface;
import data_structures.linked_lists.implementations.DoublyLinkedList;

public class LinkedDeque<E> implements DequeInterface<E> {

    DoublyLinkedList<E> l = new DoublyLinkedList<>();

    @Override
    public void addFirst(E value) {
        l.push_front(value);
    }

    @Override
    public void addLast(E value) {
        l.push_back(value);
    }

    @Override
    public E removeFirst() {
        return l.pop_front();
    }

    @Override
    public E removeLast() {
        return l.pop_back();
    }

    @Override
    public E first() {
        return l.front();
    }

    @Override
    public E last() {
        return l.back();
    }

    @Override
    public int size() {
        return l.size();
    }

    @Override
    public boolean isEmpty() {
        return l.empty();
    }

    @Override
    public void print() {
        l.print();
    }
}
