package data_structures.queues;

import data_structures.queues.implementations.ArrayQueue;
import data_structures.queues.implementations.CircularQueue;
import data_structures.queues.implementations.LinkedQueue;

import java.util.Scanner;

public class QueueTest {
    public static void main(String[] args) {
//        ArrayQueue<Integer> q = new ArrayQueue<>();
//        LinkedQueue<Integer> q = new LinkedQueue<>();
        CircularQueue<Integer> q = new CircularQueue<>();
        String command = "s";
        Scanner scanner = new Scanner(System.in);
        while (!command.equals("q")) {
            command = scanner.next();
            if("enqueue".equals(command)) {
                Integer value = scanner.nextInt();
                q.enqueue(value);
            }
            if("dequeue".equals(command)) {
                System.out.println(q.dequeue());
            }
            if("first".equals(command)) {
                System.out.println(q.first());
            }
            if("size".equals(command)) {
                System.out.println(q.size());
            }
            if("empty".equals(command)) {
                System.out.println(q.isEmpty());
            }
            if("rotate".equals(command)) {
                q.rotate();
            }


            q.print();

        }
    }
}

/*
enqueue 5
enqueue 3
size
dequeue
empty
dequeue
empty
enqueue 7
enqueue 9
first
enqueue 4
enqueue 5
*/