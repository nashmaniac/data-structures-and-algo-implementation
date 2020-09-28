package data_structures.hash_map_table;

import data_structures.hash_map_table.implementations.CustomHashTable;

import java.util.Scanner;

public class HashTableTest {
    public static void main(String[] args) {
        CustomHashTable<Integer, String> h = new CustomHashTable<>(10);
        String command = "s";
        Scanner scanner = new Scanner(System.in);
        while (!command.equals("q")) {
            command = scanner.next();
            if("put".equals(command)) {
                Integer i = scanner.nextInt();
                String key = scanner.next();
                h.add(i, key);
            }

            if("get".equals(command)) {
                Integer key = scanner.nextInt();
                System.out.println(h.get(key));
            }

            if("remove".equals(command)) {
                Integer key = scanner.nextInt();
                h.remove(key);
            }

            if("chain".equals(command)) {
                Integer key = scanner.nextInt();
                h.remove(key);
            }


            if("print".equals(command)) {
                h.print();
            }

        }
    }
}

/*
put 5 a
put 7 b
put 2 c
put 8 d
put 2 e
put 100 G
print
 */