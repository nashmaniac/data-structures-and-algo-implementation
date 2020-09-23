package data_structures.priority_queues.implementations;

import data_structures.priority_queues.entries.PQEntry;
import data_structures.priority_queues.interfaces.Entry;
import data_structures.priority_queues.interfaces.PriorityQueueInterfaceMax;

import java.util.ArrayList;
import java.util.Comparator;

public class MaxHeap<K, V> implements PriorityQueueInterfaceMax<K, V>, Comparator<Entry<K, V>> {

    ArrayList<Entry<K, V>> heap = new ArrayList<>();

    @Override
    public int size() {
        return heap.size();
    }

    @Override
    public boolean isEmpty() {
        return heap.size() == 0;
    }

    @Override
    public int compare(Entry<K, V> o1, Entry<K, V> o2) {
        int key1 = (int) o1.getKey();
        int key2 = (int) o2.getKey();
        return key1<key2 ? -1 : key1 == key2 ? 0 : 1;
    }

    private int Parent(int i) {
        return i/2;
    }

    public void swap(int i, int j) {
        Entry<K, V> p = this.heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, p);
    }

    private void upHeap(int index) {
        while (index > 0) {
            int p = Parent(index);
            if(compare(heap.get(index), heap.get(p)) <= 0) break;
            // swap
            this.swap(p, index);
            index = p;
        }
    }

    private int Left(int i) {
        return 2*i+1;
    }

    private int Right(int i) {
        return 2*i+2;
    }

    private boolean hasLeft(int i) {
        return this.Left(i) < this.size();
    }

    private boolean hasRight(int i) {
        return this.Right(i) < this.size();
    }

    private void downHeap(int index) {
        while (this.hasLeft(index)) {
            int maxIndex = this.Left(index);
            if (this.hasRight(index)) {
                if(compare(heap.get(this.Right(index)), heap.get(this.Left(index))) > 0) {
                    maxIndex = this.Right(index);
                }
            }

            this.swap(index, maxIndex);
            index = maxIndex;
        }
    }

    @Override
    public Entry<K, V> insert(K key, V value) {
        Entry<K, V> p = new PQEntry<>(key, value);
        heap.add(p);
        this.upHeap(this.size()-1);
        return p;
    }

    @Override
    public Entry<K, V> maxElement() {
        if(this.isEmpty()) return null;
        return heap.get(0);
    }

    @Override
    public Entry<K, V> removeMax() {
        if(this.isEmpty()) return null;
        Entry<K, V> p = heap.get(0);
        heap.set(0, heap.get(this.size()-1));
        heap.remove(this.size()-1);
        this.downHeap(0);
        return p;
    }

    @Override
    public void print() {
        System.out.println("Size: "+this.size());
        for(Entry<K, V> item: heap) {
            System.out.print("("+ item.getKey() +", "+ item.getValue()+")");
        }
        System.out.println();
    }
}
