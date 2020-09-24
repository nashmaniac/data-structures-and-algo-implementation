package data_structures.priority_queues.implementations;

import data_structures.priority_queues.entries.PQEntry;
import data_structures.priority_queues.interfaces.Entry;

import java.util.ArrayList;
import java.util.Comparator;

public class PriorityQueue<K, V> implements Comparator<Entry<K, V>> {
    ArrayList<Entry<K, V>> heap = new ArrayList<>();
    int size = 0;

    public void add(K key, V value) {
        Entry<K, V> v = new PQEntry<>(key, value);
        heap.add(v);
        this.size += 1;
    }


    public int Parent(int i){
        return i/2;
    }

    public int Left(int i) {
        return 2*i+1;
    }

    public int Right(int i) {
        return 2*i+2;
    }

    public boolean hasLeft(int size, int i) {
        return this.Left(i) < size;
    }

    public boolean hasRight(int size, int i) {
        return this.Right(i) < size;
    }

    @Override
    public int compare(Entry<K, V> o1, Entry<K, V> o2) {
        int key1 = (int) o1.getKey();
        int key2 = (int) o2.getKey();
        return key1<key2 ? -1 : key1 == key2 ? 0: 1;
    }

    public void swap(int i, int j) {
        Entry<K, V> p = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, p);
    }

    public void downHeap(int size, int index, String mode) {
        while (this.hasLeft(size, index)) {
            int p = this.Left(index);
            int maxIndex = p;

            if(this.hasRight(size , index)) {
                if (mode.equals("maxHeap")) {
                    if(compare(heap.get(this.Right(index)), heap.get(p)) > 0) {
                        p = this.Right(index);
                        maxIndex = this.Right(index);
                    }
                }
                if (mode.equals("minHeap")) {
                    if(compare(heap.get(this.Right(index)), heap.get(p)) < 0) {
                        p = this.Right(index);
                        maxIndex = this.Right(index);
                    }
                }


            }

            if (mode.equals("maxHeap")) {
                if(compare(heap.get(index), heap.get(maxIndex)) >= 0) break;
            }
            if (mode.equals("minHeap")) {
                if(compare(heap.get(index), heap.get(maxIndex)) <= 0) break;
            }

            swap(index, maxIndex);
            index = maxIndex;
        }

    }

    public void heapify(String mode) {
        int startIndex = (this.size()-1)/2;

        for(int i=startIndex;i>=0;i--) {
            this.downHeap(this.size(), i, mode);
        }

    }

    public int size() {
        return this.size;
    }

    public void print() {
        System.out.println("Size: "+this.size());
        for(Entry<K, V> a: this.heap){
            System.out.print("("+ a.getKey() +","+ a.getValue() +")");
        }
        System.out.println();
    }

    public void heapSort(String mode) {
        String heapMode = null;
        if (mode.equals("asc")) {
            heapMode = "maxHeap";
        }
        if (mode.equals("desc")) {
            heapMode = "minHeap";
        }

        this.heapify(heapMode);


        for(int i=this.size()-1;i>=0;i--) {
            swap(0, i);
            this.downHeap(i, 0, heapMode);
        }

    }

}
