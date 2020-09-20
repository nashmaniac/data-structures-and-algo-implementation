package data_structures.stacks.implementations;

import data_structures.linked_lists.implementations.SinglyLinkListWithoutTailPointer;
import data_structures.stacks.interfaces.StackInterface;

public class LinkedStack<E> implements StackInterface<E> {

    SinglyLinkListWithoutTailPointer<E> l = new SinglyLinkListWithoutTailPointer<>();

    @Override
    public void push(E value) {
        l.push_front(value);
    }

    @Override
    public E pop() {
        return l.pop_front();
    }

    @Override
    public int size() {
        return l.size();
    }

    @Override
    public E top() {
        return l.front();
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
