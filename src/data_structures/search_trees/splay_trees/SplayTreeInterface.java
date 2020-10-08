package data_structures.search_trees.splay_trees;

public interface SplayTreeInterface<T, K> {
    void insert(K key);
    void display();
    T find(K key);
    void delete(K key);
}
