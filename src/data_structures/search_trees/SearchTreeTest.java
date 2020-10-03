package data_structures.search_trees;

import data_structures.search_trees.classes.TreeNode;
import data_structures.search_trees.implementations.BinarySearchTree;

import java.util.List;
import java.util.Scanner;

public class SearchTreeTest {

    private void testBST() {

        BinarySearchTree<Integer, String> bst = new BinarySearchTree<>();
        String command = "s";

        Scanner scanner = new Scanner(System.in);
        while (!command.equals("q")) {
            command = scanner.next();

            if("add".equals(command)) {
                Integer key = scanner.nextInt();
                String value = scanner.next();

                bst.insert(key, value);
            }

            if("max".equals(command)) {
                System.out.println(bst.maximum(bst.getRoot()).getKey());
            }

            if("min".equals(command)) {
                System.out.println(bst.minimum(bst.getRoot()).getKey());
            }

            if("range".equals(command)) {
                Integer start = scanner.nextInt();
                Integer end = scanner.nextInt();
                List<TreeNode<Integer, String>> nodeList = bst.rangeSearch(start, end);
                for(TreeNode<Integer, String> b: nodeList) {
                    System.out.print(b.getKey() + " ");
                }
                System.out.println();
            }

            if("height".equals(command)) {
                System.out.print(bst.height(bst.getRoot()));
            }

            if("delete".equals(command)) {
                Integer del_key = scanner.nextInt();
                bst.delete(del_key);
            }





            if("print".equals(command)) {
                String mode = scanner.next();
                bst.print(mode);
            }

        }
    }

    public static void main(String[] args) {
        SearchTreeTest t = new SearchTreeTest();
        t.testBST();

    }
}


/*
add 12 12
add 5 5
add 15 15
add 3 3
add 7 7
add 9 9
add 1 1
add 13 13
add 17 17
add 19 19
 */