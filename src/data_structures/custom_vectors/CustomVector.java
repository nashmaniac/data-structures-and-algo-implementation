package data_structures.custom_vectors;

import java.lang.reflect.Array;
import java.util.Scanner;


public class CustomVector {

    /*

    Custom vector implementation

    Vector is an automatically resizing array.

     */

    int vectorSize = 0;
    int vectorCapacity;
    int[] vectorArray = null;

    CustomVector(int capacity) {
        this.vectorCapacity = capacity;
        this.vectorArray = new int[this.vectorCapacity];
        this.initArray(this.vectorCapacity);
    }

    private void initArray(int count) {
        for(int i=0;i<count;i++) {
            this.vectorArray[i] = Integer.parseInt("0");
        }
    }

    private void resize(int new_capacity) {
        int oldCapacity = this.capacity();
        Class objectType = this.vectorArray.getClass().componentType();
        Object newArray = Array.newInstance(objectType, new_capacity);
        int preserved = Math.min(oldCapacity, new_capacity);
        if (preserved > 0) {
            System.arraycopy(this.vectorArray, 0, newArray, 0, preserved);
        }

        this.vectorArray = (int[]) newArray;
        this.vectorSize = this.size();
        this.vectorCapacity = new_capacity;

    }

    public int size() {
        return this.vectorSize;
    }

    public int capacity() {
        return this.vectorCapacity;
    }

    public boolean is_empty() {
        return vectorSize == 0;
    }

    public int at(int index) {
        return this.vectorArray[index];
    }

    public void push(int a) {
        if(this.vectorSize == this.vectorCapacity) {
            System.out.println("Vector is full");
            return;
        }
        this.vectorArray[this.vectorSize] = a;
        this.vectorSize += 1;
        if(this.vectorSize == this.capacity()) {
            this.resize(2*this.capacity());
        }
    }

    public void insert(int index, int itemValue) {
        // first shift rightward to make room
        if (index >= this.size()) {
            this.push(itemValue);
            return;
        }
        for(int i=this.size();i>index;i--) {
            this.vectorArray[i] = this.vectorArray[i-1];
        }
        this.vectorArray[index] = itemValue;
        if(this.size()<this.capacity()) {
            this.vectorSize += 1;
        }
        if(this.vectorSize == this.capacity()) {
            this.resize(2*this.capacity());
        }
    }

    public int pop() {
        int temp = this.vectorArray[this.vectorSize-1];
        this.vectorArray[this.vectorSize-1] = Integer.parseInt("0");
        this.vectorSize -= 1;
        if (this.vectorSize <= this.capacity()/4) {
            this.resize(this.capacity()/2);
        }
        return temp;
    }

    public void prepend(int itemValue) {
        this.insert(0, itemValue);
    }

    public int delete(int index) {
        int temp = this.vectorArray[index];
        for(int i=index+1;i<this.size();i++) {
            this.vectorArray[i-1] = this.vectorArray[i];
        }
        this.vectorArray[this.size()-1] = Integer.parseInt("0");
        this.vectorSize -= 1;
        return temp;
    }

    public void remove(int itemValue) {
        for(int i=0;i<this.size();i++) {
            if(this.vectorArray[i] == itemValue) {
                this.delete(i);
            }
        }
    }

    public int find(int itemValue) {
        for(int i=0;i<this.size();i++) {
            if(this.vectorArray[i]==itemValue) {
                return i;
            }
        }
        return -1;
    }

    public void print() {
        if(this.vectorSize == 0) {
            System.out.println("No Elements Found");
            return;
        }
        System.out.println("Size: " + this.size() + ", Capacity: " + this.capacity());
        for(int i=0;i<this.size();i++) {
            System.out.print(this.vectorArray[i]+ " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int capacity = scanner.nextInt();
        int queries = scanner.nextInt();
        CustomVector v = new CustomVector(capacity);

        for(int i=0;i<queries;i++) {
            String command = scanner.next();

            if("size".equals(command)) {
                System.out.println(v.size());
            }

            if("capacity".equals(command)) {
                System.out.println(v.capacity());
            }

            if("is_empty".equals(command)) {
                System.out.println(v.is_empty());
            }

            if("at".equals(command)) {
                int index = Integer.parseInt(scanner.next());
                System.out.println(v.at(index));
            }

            if("push".equals(command)) {
                int value = Integer.parseInt(scanner.next());
                v.push(value);
                
            }

            if("insert".equals(command)) {
                int index = Integer.parseInt(scanner.next());
                int value = Integer.parseInt(scanner.next());
                v.insert(index, value);
                
            }

            if("prepend".equals(command)) {
                int value = Integer.parseInt(scanner.next());
                v.prepend(value);
            }

            if("delete".equals(command)) {
                int value = Integer.parseInt(scanner.next());
                System.out.println(v.delete(value));
            }

            if("remove".equals(command)) {
                int value = Integer.parseInt(scanner.next());
                v.remove(value);
            }

            if("find".equals(command)) {
                int value = Integer.parseInt(scanner.next());
                System.out.println(v.find(value));
            }

            if("pop".equals(command)) {
                System.out.println(v.pop());
            }

            v.print();


        }

    }


}


/*

10 20
push 1
push 5
insert 6 8
insert 2 9
prepend 10
delete 1
prepend 9
remove 9
find 8

 */