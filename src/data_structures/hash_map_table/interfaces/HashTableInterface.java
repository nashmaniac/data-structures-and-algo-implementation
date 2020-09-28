package data_structures.hash_map_table.interfaces;

import java.util.List;

public interface HashTableInterface<K, V> {
    int hash(K key);
    void add(K key, V value);
    V get(K key);
    void remove(K key);
    List<V> getChain(int hash);
    void print();
}
