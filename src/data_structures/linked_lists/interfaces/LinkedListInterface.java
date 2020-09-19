package data_structures.linked_lists.interfaces;

public interface LinkedListInterface<E> {
    int size();
    boolean empty();
    E value_at(int index);
    void push_front(E value);
    E pop_front();
    void push_back(E value);
    E pop_back();
    E front();
    E back();
    void insert(int index, E value);
    void erase(int index);
    E value_from_n_end(int index);
    void reverse();
    void remove_value(E value);
    void print();
}
