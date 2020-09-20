package data_structures.queues.interfaces;

public interface QueueInterface<E> {

    void enqueue(E value);
    E dequeue();

    E first();
    int size();
    boolean isEmpty();
    void print();
}
