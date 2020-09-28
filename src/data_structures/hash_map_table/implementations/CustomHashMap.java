package data_structures.hash_map_table.implementations;

import data_structures.hash_map_table.classes.MapEntry;
import data_structures.hash_map_table.interfaces.Entry;
import data_structures.hash_map_table.interfaces.MapInterface;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CustomHashMap<K, V> implements MapInterface<K,V> {

    List<Entry<K, V>> table = new ArrayList<>();

    private int findIndex(K key) {
        for(int i=0;i<this.size();i++) {
            if(this.table.get(i).getKey().equals(key)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return this.table.size();
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public V get(K key) {
        int index = this.findIndex(key);
        if(index != -1) {
            return this.table.get(index).getValue();
        }
        return null;
    }

    @Override
    public void put(K key, V value) {
        int index = this.findIndex(key);
        if(index != -1) {
            this.table.get(index).setValue(value);
        }
        this.table.add(0, new MapEntry<>(key, value));
    }

    @Override
    public void remove(K key) {
        int index = this.findIndex(key);
        if(index != -1) {
            this.table.remove(index);
        }
    }

    @Override
    public Iterable<K> keySet() {
        List<K> v = new ArrayList<>();
        for(Entry<K, V> b: this.table) {
            v.add(b.getKey());
        }
        return (Iterable<K>) v;
    }

    @Override
    public Iterable<V> values() {
        List<V> v = new ArrayList<>();
        for(Entry<K, V> b: this.table) {
            v.add(b.getValue());
        }
        return (Iterable<V>) v;
    }

    @Override
    public Iterable<Entry<K, V>> entrySet() {
        return this.table;
    }

    @Override
    public void print() {
        System.out.println("Size: "+ this.size());
        for(Entry<K, V> b: this.table) {
            System.out.print("("+b.getKey()+","+b.getValue()+") ");
        }
        System.out.println();
    }
}


/*
put A 5
put B 7
put C 2
put D 8
put E 2
get B
get 4
get G
remove D
remove E
remove A
keys
 */
