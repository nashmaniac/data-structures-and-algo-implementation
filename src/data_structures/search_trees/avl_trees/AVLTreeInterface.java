package data_structures.search_trees.avl_trees;

public interface AVLTreeInterface<T, K> {
    void insert(K key);
    void delete(K key);
    boolean contains(K key);
    T maximum();
    T minimum();
    void display();
}
