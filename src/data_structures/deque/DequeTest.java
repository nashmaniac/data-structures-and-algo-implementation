package data_structures.deque;

import data_structures.deque.implementations.ArrayDeque;
import data_structures.deque.implementations.LinkedDeque;

import java.util.Scanner;

public class DequeTest {
    public static void main(String[] args) {
//        ArrayDeque<Integer> q = new ArrayDeque<>();
        LinkedDeque<Integer> q = new LinkedDeque<>();
        String command = "s";
        Scanner scanner = new Scanner(System.in);
        while (!command.equals("q")) {
            command = scanner.next();
            if("addFirst".equals(command)) {
                Integer value = scanner.nextInt();
                q.addFirst(value);
            }
            if("addLast".equals(command)) {
                Integer value = scanner.nextInt();
                q.addLast(value);
            }

            if("removeFirst".equals(command)) {
                System.out.println(q.removeFirst());
            }
            if("removeLast".equals(command)) {
                System.out.println(q.removeLast());
            }

            if("first".equals(command)) {
                System.out.println(q.first());
            }
            if("last".equals(command)) {
                System.out.println(q.last());
            }

            if("size".equals(command)) {
                System.out.println(q.size());
            }
            if("empty".equals(command)) {
                System.out.println(q.isEmpty());
            }

            q.print();

        }
    }
}
