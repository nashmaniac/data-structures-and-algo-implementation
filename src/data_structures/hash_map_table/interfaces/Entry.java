package data_structures.hash_map_table.interfaces;

public interface Entry<K, V> {
    public K getKey();
    public V getValue();
    public void setKey(K key);
    public void setValue(V value);
}
