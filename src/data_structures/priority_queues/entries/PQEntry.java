package data_structures.priority_queues.entries;

import data_structures.priority_queues.interfaces.Entry;

public class PQEntry<K, V> implements Entry<K, V> {
    K key;
    V value;

    public PQEntry(K key, V value) {
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

    public void setValue(V value) {
        this.value = value;
    }

    public void setKey(K key) {
        this.key = key;
    }
}
