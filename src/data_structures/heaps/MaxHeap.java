package data_structures.heaps;

import java.util.ArrayList;

public class MaxHeap {
    ArrayList<Integer> data = new ArrayList<>();

    int Left(int index) {
        return 2*index+1;
    }

    int Right(int index) {
        return 2*index+2;
    }

    int Parent(int index) {
        return index/2;
    }

    boolean hasRight(int index, int size) {
        return Right(index) < size;
    }

    boolean hasLeft(int index, int size) {
        return Left(index) < size;
    }

    boolean isEmpty() {
        return this.data.size() == 0;
    }

    void upHeap(int index) {
        while (index !=0) {
            int p = Parent(index);
            Integer parent = data.get(p);
            Integer current = data.get(index);
            if(parent.compareTo(current)<0) {
                data.set(index, parent);
                data.set(p, current);
            }

            index = p;
        }
    }

    void downHeap(int index, int size) {
        while (hasLeft(index, size)) {
            int l = Left(index);
            Integer max = data.get(l);
            if(hasRight(index, size)) {
                int r = Right(index);
                Integer right = data.get(r);

                if(max.compareTo(right) < 0) {
                    l = r;
                    max = right;
                }
            }

            Integer current = data.get(index);
            if(max.compareTo(current) > 0) {
                data.set(l, current);
                data.set(index, max);
            }
            index = l;
        }
    }

    void heapify() {
        int size = this.data.size();
        for(int i=size/2;i>=0;i--) {
            this.downHeap(i, size);
        }
    }

    int removeMax() {
        Integer a = data.get(0);
        data.set(0, data.get(data.size()-1));
        data.remove(data.size()-1);
        this.downHeap(0, data.size());
        return a;
    }

    void heapsort() {
        for(int i=data.size();i>1;i--) {
            int d = data.get(0);
            data.set(0, data.get(i-1));
            data.set(i-1, d);
            this.downHeap(0, i-1);
        }
    }


    public static void main(String[] args) {
        MaxHeap h = new MaxHeap();
        int[] a = {85, 23, 47, 69, 84, 25, 43, 6, 81, 30};

        for(int i=0;i<a.length;i++) {
            h.data.add(a[i]);
        }

        h.heapify();

//        while (!h.isEmpty()) {
//            Integer i = h.removeMax();
//            System.out.println(i);
//        }
        h.heapsort();
        for(Integer i: h.data) {
            System.out.println(i);
        }
    }

}
