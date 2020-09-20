package data_structures.queues.implementations;

import data_structures.linked_lists.implementations.CircularLinkList;
import data_structures.queues.interfaces.CircularQueueInterface;

public class CircularQueue<E> implements CircularQueueInterface<E> {
    CircularLinkList<E> c = new CircularLinkList<>();
    @Override
    public void rotate() {
        c.rotate();;
    }

    @Override
    public void enqueue(E value) {
        c.push_back(value);
    }

    @Override
    public E dequeue() {
        return c.pop_front();
    }

    @Override
    public E first() {
        return c.front();
    }

    @Override
    public int size() {
        return c.size();
    }

    @Override
    public boolean isEmpty() {
        return c.empty();
    }

    @Override
    public void print() {
        c.print();
    }
}
