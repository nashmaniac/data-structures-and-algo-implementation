package data_structures.queues.implementations;

import data_structures.queues.interfaces.QueueInterface;

public class ArrayQueue<E> implements QueueInterface<E> {

    E[] dataArray;
    int position = 0;
    int size = 0;
    int capacity = 5;

    public ArrayQueue() {
        this.dataArray = (E[]) new Object[this.capacity];
        this.size = 0;
        this.position = 0;
    }

    @Override
    public void enqueue(E value) {
        if (this.size == this.capacity) {
            System.out.println("Queue is full");
            return;
        }
        int position_to_start = (this.position + this.size()) % this.capacity;
        this.dataArray[position_to_start] = value;
        this.size += 1;
    }

    @Override
    public E dequeue() {
        if(this.isEmpty()) {
            return null;
        }
        E value = this.dataArray[position];
        this.dataArray[this.position] = null;
        this.size -= 1;
        this.position = (this.position + 1) % this.capacity;
        return value;

    }

    @Override
    public E first() {
        if(this.isEmpty()) {
            return null;
        }
        return this.dataArray[this.position];
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
            System.out.print(this.dataArray[p] + " ");
            p = (p + 1)%this.capacity;
            count += 1;
        }
        System.out.println();
    }
}
