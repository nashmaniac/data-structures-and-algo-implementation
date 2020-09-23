package data_structures.priority_queues;

import data_structures.priority_queues.entries.PQEntry;
import data_structures.priority_queues.implementations.MaxHeap;
import data_structures.priority_queues.implementations.MinHeap;

import java.util.Scanner;

public class PriorityQueueTest {
    public static void main(String[] args) {
        MaxHeap<Integer, String> heap = new MaxHeap<>();
        String command = "s";
        Scanner scanner = new Scanner(System.in);
        while (!command.equals("q")) {
            command = scanner.next();

            if("add".equals(command)) {
                int key = scanner.nextInt();
                String value = scanner.next();
                heap.insert(key, value);
            }
            if("first".equals(command)) {
                PQEntry p = (PQEntry) heap.maxElement();
                System.out.println("(" + p.getKey() + ","+ p.getValue() +")");
            }

            if("remove".equals(command)) {
                PQEntry p = (PQEntry) heap.removeMax();
                System.out.println("(" + p.getKey() + ","+ p.getValue() +")");
            }




            heap.print();
        }
    }
}

/*
add 1 shetu
add 5 aksa
add -2 upama
add 2 asif
add 3 fahim
first
remove
 */