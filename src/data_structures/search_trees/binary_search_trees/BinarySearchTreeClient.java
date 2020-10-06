package data_structures.search_trees.binary_search_trees;

public class BinarySearchTreeClient {

    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(7);
        bst.insert(20);
        bst.insert(5);
        bst.insert(15);
        bst.insert(10);
        bst.insert(4);
        bst.insert(4);
        bst.insert(33);
        bst.insert(25);
        bst.insert(18);
        bst.insert(12);

        bst.display();

        bst.delete(25);
        bst.display();
        bst.delete(5);
        bst.display();
        bst.delete(10);
        bst.display();
        bst.delete(20);
        bst.display();
        bst.delete(7);
        bst.display();

        System.out.println(bst.contains(5));
        System.out.println(bst.contains(16));
        System.out.println(bst.maximum().getData());
        System.out.println(bst.minimum().getData());
        System.out.println(bst.inOrder());
        System.out.println(bst.postOrder());
        System.out.println(bst.preOrder());
    }

}
