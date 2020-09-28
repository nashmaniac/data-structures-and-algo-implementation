package data_structures.hash_map_table.classes;

import data_structures.hash_map_table.interfaces.Entry;

public class HashEntry<K, V> implements Entry<K, V> {
    K key;
    V value;

    public HashEntry(K key, V value) {
        this.setKey(key);
        this.setValue(value);
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
