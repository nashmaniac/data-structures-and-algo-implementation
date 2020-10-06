package data_structures.search_trees.binary_search_trees;

public interface BinarySearchTreeInterface<T, K> {
    void insert(K key);
    void delete(K key);
    boolean contains(K key);
    T maximum();
    T minimum();
    void display();
}
