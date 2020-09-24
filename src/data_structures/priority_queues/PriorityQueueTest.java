package data_structures.priority_queues;

import data_structures.priority_queues.entries.PQEntry;
import data_structures.priority_queues.implementations.MaxHeap;
import data_structures.priority_queues.implementations.MinHeap;
import data_structures.priority_queues.implementations.PriorityQueue;

import java.util.Scanner;

public class PriorityQueueTest {
    public static void main(String[] args) {
        PriorityQueue<Integer, String> heap = new PriorityQueue<>();
        String command = "s";
        Scanner scanner = new Scanner(System.in);
        while (!command.equals("q")) {
            command = scanner.next();

            if("add".equals(command)) {
                int key = scanner.nextInt();
                String value = scanner.next();
                heap.add(key, value);
            }
//            if("first".equals(command)) {
//                PQEntry p = (PQEntry) heap.maxElement();
//                System.out.println("(" + p.getKey() + ","+ p.getValue() +")");
//            }

//            if("remove".equals(command)) {
//                PQEntry p = (PQEntry) heap.removeMax();
//                System.out.println("(" + p.getKey() + ","+ p.getValue() +")");
//            }

            if("maxHeap".equals(command) || "minHeap".equals(command)) {
                heap.heapify(command);
                heap.print();
            }

            if("sort".equals(command)) {
                String mode = scanner.next();
                heap.heapSort(mode);
                heap.print();
            }




            if ("print".equals(command)) {
                heap.print();
            }
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


/*
add 1 1
add 5 5
add 9 9
add 6 6
add 2 2
add 3 3
 */