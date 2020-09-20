package data_structures.deque.interfaces;

public interface DequeInterface<E> {
    void addFirst(E value);
    void addLast(E value);

    E removeFirst();
    E removeLast();

    E first();
    E last();

    int size();
    boolean isEmpty();

    void print();
}
