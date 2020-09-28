package data_structures.hash_map_table.implementations;

import data_structures.hash_map_table.classes.HashEntry;
import data_structures.hash_map_table.interfaces.HashTableInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CustomHashTable<K, V> implements HashTableInterface<K, V> {

    List<HashEntry<K, V>>[] table;

    private int prime = 109345121;
    private int scale;
    private int shift;
    private int cardinality = 0;


    private void createTable() {
        Random rand = new Random();
        scale = rand.nextInt(prime-1)+1;
        shift = rand.nextInt(prime);
        this.table = new ArrayList[this.cardinality];
    }

    public CustomHashTable() {
        this(10);
    }

    public CustomHashTable(int cardinality) {
        this.cardinality = cardinality;
        this.createTable();
    }

    @Override
    public int hash(K key) {
        return Math.abs(((key.toString().hashCode()*scale + shift)%prime)%cardinality);
    }

    @Override
    public void add(K key, V value) {
        int h = hash(key);
        if(table[h] == null) {
            List<HashEntry<K, V>> t = new ArrayList<>();
            table[h] = t;
        }
        table[h].add(0, new HashEntry<>(key, value));
    }

    @Override
    public V get(K key) {
        int h = hash(key);
        if(table[h] != null) {
            for(HashEntry<K, V> obj: table[h]) {
                if(obj.getKey().equals(key)) {
                    return obj.getValue();
                }
            }
        }
        return null;
    }

    @Override
    public void remove(K key) {
        int h = hash(key);
        if(table[h] != null) {
            for(HashEntry<K, V> obj: table[h]) {
                if(obj.getKey().equals(key)) {
                    table[h].remove(obj);
                    return;
                }
            }
        }
    }

    @Override
    public List<V> getChain(int hash) {
        List<HashEntry<K, V>> chain = this.table[hash];
        if(chain != null) {
            List<V> v = new ArrayList<>();
            for(HashEntry<K, V> p: chain) {
                v.add(p.getValue());
            }
            return v;
        }
        return null;
    }

    @Override
    public void print() {
        for(int i=0;i<this.table.length;i++) {
            List<HashEntry<K, V>> chain = this.table[i];
            if(chain == null) {
                System.out.println(i+" -> empty");
            } else {
                System.out.print(i+": ");
                for(HashEntry<K, V> a: chain) {
                    System.out.print(a.getValue() + " ");
                }
                System.out.println();
            }

        }
    }
}
