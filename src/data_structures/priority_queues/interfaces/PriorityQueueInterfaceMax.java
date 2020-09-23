package data_structures.priority_queues.interfaces;

public interface PriorityQueueInterfaceMax<K, V> {
    int size();
    boolean isEmpty();
    Entry<K, V> insert(K key, V value);
    Entry<K, V> maxElement();
    Entry<K, V> removeMax();

    void print();
}
