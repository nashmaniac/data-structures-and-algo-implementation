package data_structures.queues.implementations;

import data_structures.linked_lists.implementations.SinglyLinkListWithTailPointer;
import data_structures.queues.interfaces.QueueInterface;

public class LinkedQueue<E> implements QueueInterface<E> {

    SinglyLinkListWithTailPointer<E> l = new SinglyLinkListWithTailPointer<>();

    @Override
    public void enqueue(E value) {
        l.push_back(value);
    }

    @Override
    public E dequeue() {
        return l.pop_front();
    }

    @Override
    public E first() {
        return l.front();
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
