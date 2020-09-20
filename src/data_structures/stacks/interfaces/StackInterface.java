package data_structures.stacks.interfaces;

public interface StackInterface<E> {
    void push(E value);
    E pop();

    int size();
    E top();
    boolean isEmpty();
    void print();
}
