package data_structures.search_trees.avl_trees;

public class AVLTreeClient {

    public static void main(String[] args) {
        AVLTree<Integer> avl = new AVLTree<>();
        avl.insert(10);
        avl.insert(30);
        avl.insert(20);
        avl.insert(15);
        avl.insert(10);
        avl.insert(4);
        avl.insert(4);
        avl.insert(33);
        avl.insert(25);
        avl.insert(18);
        avl.insert(12);
        avl.delete(10);
        avl.delete(12);
        avl.delete(30);
        avl.delete(18);
        avl.delete(15);
        avl.delete(4);

        avl.display();

    }
}
