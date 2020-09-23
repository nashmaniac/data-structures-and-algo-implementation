package data_structures.priority_queues.interfaces;

public interface PriorityQueueInterfaceMin<K, V> {
    public Entry<K, V> insert(K key, V value);
    int size();
    boolean isEmpty();
    Entry<K, V> min();
    Entry<K, V> removeMin();
    void print();
}
