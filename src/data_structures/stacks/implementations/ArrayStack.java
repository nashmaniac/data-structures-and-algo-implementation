package data_structures.stacks.implementations;

import data_structures.stacks.interfaces.StackInterface;

public class ArrayStack<E> implements StackInterface<E> {

    E[] dataArray;
    int size;
    int capacity = 1000;
    int startPosition = -1;

    public ArrayStack() {
        int capacity = 1000;
        this.dataArray = (E[]) new Object[capacity];
        this.capacity = capacity;
        this.size = 0;
    }

    @Override
    public void push(E value) throws IllegalStateException {
        if(this.size == this.capacity) {
            throw new IllegalStateException("Stack is full");
        }
        this.dataArray[++startPosition] = value;
        this.size += 1;
    }

    @Override
    public E pop() {
        if(this.isEmpty()) {
            return null;
        }
        E value = this.dataArray[this.startPosition];
        this.dataArray[startPosition] = null;
        startPosition--;
        this.size -= 1;
        return value;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public E top() {
        if(this.isEmpty()) {
            return null;
        }
        return this.dataArray[startPosition];
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public void print() {
        System.out.println("Size: "+ this.size());
        for(int i=0;i<this.size;i++) {
            System.out.print(this.dataArray[i] + " ");
        }
        System.out.println();
    }
}
