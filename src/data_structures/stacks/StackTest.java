package data_structures.stacks;

import data_structures.stacks.implementations.ArrayStack;
import data_structures.stacks.implementations.LinkedStack;

import java.util.Scanner;

public class StackTest {

    public static void main(String[] args) {

        LinkedStack<Integer> s = new LinkedStack<>();
        String command = "s";
        Scanner scanner = new Scanner(System.in);
        while (!command.equals("q")) {
            command = scanner.next();
            if("push".equals(command)) {
                Integer value = scanner.nextInt();
                s.push(value);
            }
            if("pop".equals(command)) {
                System.out.println(s.pop());
            }
            if("top".equals(command)) {
                System.out.println(s.top());
            }
            if("size".equals(command)) {
                System.out.println(s.size());
            }
            if("empty".equals(command)) {
                System.out.println(s.isEmpty());
            }

            s.print();
        }
    }
}
