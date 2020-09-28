package data_structures.hash_map_table.interfaces;

public interface MapInterface<K, V> {
    int size();
    boolean isEmpty();
    V get(K key);
    void put(K key, V value);
    void remove(K key);
    Iterable<K> keySet();
    Iterable<V> values();
    Iterable<Entry<K, V>> entrySet();
    void print();
}
