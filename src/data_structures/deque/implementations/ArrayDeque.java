package data_structures.deque.implementations;

import data_structures.deque.interfaces.DequeInterface;

public class ArrayDeque<E> implements DequeInterface<E> {
    E[] data;
    int capacity = 5;
    int size = 0;
    int position = 0;

    public ArrayDeque() {
        this.data = (E[]) new Object[this.capacity];
        this.size = 0;
        this.position = 0;
    }
    @Override
    public void addFirst(E value) {
        if(this.size == this.capacity) {
            System.out.println("Queue is full");
            return;
        }
        this.position = (this.position - 1 + capacity)%capacity;
        this.data[this.position] = value;
        this.size += 1;
    }

    @Override
    public void addLast(E value) {
        if(this.size == this.capacity) {
            System.out.println("Queue is full");
            return;
        }
        int p = (this.position+this.size)%this.capacity;
        this.data[p] = value;
        this.size += 1;
    }

    @Override
    public E removeFirst() {
        if(this.isEmpty()) {
            return null;
        }
        E value = this.data[position];
        this.data[position] = null;
        this.size -= 1;
        this.position = (this.position -1 + this.capacity)%this.capacity;
        return value;
    }

    @Override
    public E removeLast() {
        if(this.isEmpty()) {
            return null;
        }
        int p = (this.position + this.size - 1) %this.capacity;
        E value = this.data[p];
        this.data[p] = null;
        this.size -= 1;
        return value;
    }

    @Override
    public E first() {
        if(!this.isEmpty()) {
            return this.data[position];
        }
        return null;
    }

    @Override
    public E last() {
        if(!this.isEmpty()) {
            return this.data[(position+size-1)%capacity];
        }
        return null;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public void print() {
        int p = this.position;
        int count = 0;
        System.out.println("Size: "+this.size());
        while (count < this.size()) {
            System.out.print(this.data[p] + " ");
            p = (p + 1)%this.capacity;
            count += 1;
        }
        System.out.println();
    }
}
