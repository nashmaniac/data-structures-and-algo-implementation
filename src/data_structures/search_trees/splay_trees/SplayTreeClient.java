package data_structures.search_trees.splay_trees;

public class SplayTreeClient {

    public static void main(String[] args) {
        SplayTree<Integer> spl = new SplayTree<>();
        spl.insert(30);
        spl.display();
        spl.insert(20);
        spl.display();
        spl.insert(10);
        spl.display();
        spl.insert(15);
        spl.insert(12);
        spl.display();

        System.out.println(spl.find(35).getData());
        spl.display();

        spl.delete(30);
        spl.display();

        spl.delete(15);
        spl.display();

    }
}
