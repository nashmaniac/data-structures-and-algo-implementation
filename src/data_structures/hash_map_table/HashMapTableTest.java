package data_structures.hash_map_table;

import data_structures.hash_map_table.implementations.CustomHashMap;
import data_structures.hash_map_table.interfaces.Entry;

import java.util.Iterator;
import java.util.Scanner;

public class HashMapTableTest {

    public static void main(String[] args) {
        CustomHashMap<String, Integer> customHashMap = new CustomHashMap<>();
        String command = "s";
        Scanner scanner = new Scanner(System.in);
        while (!command.equals("q")) {
            command = scanner.next();
            if("put".equals(command)) {
                String key = scanner.next();
                Integer i = scanner.nextInt();
                customHashMap.put(key, i);
            }
            if("get".equals(command)) {
                String key = scanner.next();
                System.out.println(customHashMap.get(key));
            }

            if("remove".equals(command)) {
                String key = scanner.next();
                customHashMap.remove(key);
            }
            if("values".equals(command)) {
                for (Integer i: customHashMap.values()) {
                    System.out.print(i+" ");
                }
                System.out.println();
            }
            if("keys".equals(command)) {
                for (String i: customHashMap.keySet()) {
                    System.out.print(i+" ");
                }
                System.out.println();
            }
            if("entries".equals(command)) {
                for (Entry<String, Integer> b: customHashMap.entrySet()) {
                    System.out.print("("+b.getKey()+","+b.getValue()+") ");
                }
                System.out.println();
            }
            customHashMap.print();
        }
    }
}


/*
put a 5
put b 7
put c 2
put d 8
put e 2
get b
get f
get c
remove a
remove e
values
keys
entries

 */