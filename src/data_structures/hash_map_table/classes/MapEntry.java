package data_structures.hash_map_table.classes;

import data_structures.hash_map_table.interfaces.Entry;

public class MapEntry<K, V> implements Entry<K, V> {

    K key;
    V value;

    public MapEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public K getKey() {
        return this.key;
    }

    @Override
    public V getValue() {
        return this.value;
    }

    @Override
    public void setKey(K key) {
        this.key = key;
    }

    @Override
    public void setValue(V value) {
        this.value = value;
    }
}
