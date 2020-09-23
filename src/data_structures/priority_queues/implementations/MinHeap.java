package data_structures.priority_queues.implementations;

import data_structures.priority_queues.entries.PQEntry;
import data_structures.priority_queues.interfaces.Entry;
import data_structures.priority_queues.interfaces.PriorityQueueInterfaceMin;

import java.util.ArrayList;
import java.util.Comparator;

public class MinHeap<K, V> implements PriorityQueueInterfaceMin<K, V>, Comparator<Entry<K, V>> {

    ArrayList<Entry<K, V>> heap = new ArrayList<>();

    private int Parent(int i) {
        return i/2;
    }

    private int Left(int i) {
        return 2*i+1;
    }
    private int Right(int i) {
        return 2*i+2;
    }
    private boolean hasLeft(int i) {
        return Left(i) < this.size();
    }
    private boolean hasRight(int i) {
        return Right(i) < this.size();
    }


    @Override
    public int compare(Entry<K, V> o1, Entry<K, V> o2) {
        return ((int) o1.getKey() < (int) o2.getKey()) ? -1 : o1.getKey() == o2.getKey() ? 0 : 1;
    }

    private void upHeap(int index) {
        while (index > 0) {
            int p = this.Parent(index);
            if(compare(heap.get(index), heap.get(p)) >= 0) break;
            Entry<K, V> temp = heap.get(index);
            heap.set(index, heap.get(p));
            heap.set(p, temp);
            index = p;
            this.upHeap(index);
        }
    }

    private void downHeap(int index) {
        while (hasLeft(index)) {
            int p = Left(index);
            Entry<K, V> minElem = heap.get(p);
            int minIndex = p;
            if(hasRight(index)) {
                if(compare(heap.get(Right(index)), minElem) < 0) {
                    minIndex = Right(index);
                    minElem = heap.get(minIndex);
                }
            }
            // Swap
            heap.set(minIndex, heap.get(index));
            heap.set(index, minElem);
            index = minIndex;
        }
    }


    @Override
    public Entry<K, V> insert(K key, V value) {
        Entry<K, V> q = new PQEntry<>(key, value);
        heap.add(q);
        upHeap(this.size()-1);
        return q;
    }

    @Override
    public int size() {
        return heap.size();
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public Entry<K, V> min() {
        if(this.isEmpty()) return null;
        return heap.get(0);
    }

    @Override
    public Entry<K, V> removeMin() {
        if(this.isEmpty()) return null;
        // swap
        Entry<K, V> minElem = heap.get(0);
        heap.set(0, heap.get(this.size()-1));
        heap.remove(this.size()-1);
        this.downHeap(0);
        return minElem;
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
