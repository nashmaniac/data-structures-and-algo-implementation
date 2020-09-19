package data_structures.linked_lists;

import data_structures.linked_lists.implementations.SinglyLinkListWithoutTailPointer;

import java.util.Scanner;

public class LinkedListTest {
    public static void main(String[] args) {
        SinglyLinkListWithoutTailPointer<Integer> l = new SinglyLinkListWithoutTailPointer<>();
        String command = "s";
        Scanner scanner = new Scanner(System.in);
        while (!command.equals("q")) {
            command = scanner.next();
            if("size".equals(command)) {
                System.out.println(l.size());
            }
            if("empty".equals(command)) {
                System.out.println(l.empty());
            }
            if("pop_front".equals(command)) {
                System.out.println(l.pop_front());
            }
            if("pop_back".equals(command)) {
                System.out.println(l.pop_back());
            }
            if("front".equals(command)) {
                System.out.println(l.front());
            }
            if("back".equals(command)) {
                System.out.println(l.back());
            }
            if("reverse".equals(command)) {
                l.reverse();
            }

            if("value_at".equals(command)) {
                int index = scanner.nextInt();
                System.out.println(l.value_at(index));
            }
            if("from_end".equals(command)) {
                int index = scanner.nextInt();
                System.out.println(l.value_from_n_end(index));
            }
            if("remove_value".equals(command)) {
                Integer index = scanner.nextInt();
                l.remove_value(index);
            }

            if("erase".equals(command)) {
                int index = scanner.nextInt();
                l.erase(index);
            }

            if("insert".equals(command)) {
                int index = scanner.nextInt();
                Integer value = scanner.nextInt();
                l.insert(index, value);
            }


            if("push_front".equals(command)) {
                Integer value = scanner.nextInt();
                l.push_front(value);
            }
            if("push_back".equals(command)) {
                Integer value = scanner.nextInt();
                l.push_back(value);
            }



            l.print();
        }
    }
}

/*
push_front 1
push_front 2
push_front 3
push_front 4
push_front 5
push_back 6
pop_front
pop_back
reverse
from_end 1
from_end 2
from_end 4
remove_value 2
insert 0 5
insert 1 6
insert 5 9

 */