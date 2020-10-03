package data_structures.search_trees.interfaces;

import java.util.List;

public interface SearchTreeInterface<T, K, V> {
    void insert(T node);
    void insert(K key, V value);
    boolean isEmpty();
    T find(K key, T root);
    void print(String mode);

    T Next(T node);
    T minimum(T node);
    T maximum(T node);
    List<T> rangeSearch(K start, K end);

    int height(T node);
    void delete(K key);

}
