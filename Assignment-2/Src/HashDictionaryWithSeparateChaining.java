package Src;

import java.util.ArrayList;
import java.util.List;

public class HashDictionaryWithSeparateChaining<K, V> {

    private static final int INITIAL_CAPACITY = 10;
    private static final float RESIZE_FACTOR = 0.8f;

    private List<Entry<K, V>>[] hashTable;
    private int size;

    private static class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

       
    }

    public HashDictionaryWithSeparateChaining() {
        hashTable = new ArrayList[INITIAL_CAPACITY];
        size = 0;
    }
    
    //gets the index of the key
    private int hashIndex(K key) {
        int hash = key.hashCode();
        return hash % hashTable.length;
    }

    public void insert(K key, V value) {
        int index = hashIndex(key);
        List<Entry<K, V>> tmp = hashTable[index];
        if (size > hashTable.length * RESIZE_FACTOR) {
            resize();
        }
        if (tmp == null) {
            tmp = new ArrayList<>();
            hashTable[index] = tmp;
        }
        //For duplicate key
        for (Entry<K, V> entry : tmp) {
            if (entry.getKey().equals(key)) {
                //if the key is already in the list, add to the chain list
                tmp.add(entry);
                return;
            }
        }
        //if the key is not in the hashTable, add it
        tmp.add(new Entry<>(key, value));
        size++;       
    }

    public V get(K key) {
        int index = hashIndex(key);
        List<Entry<K, V>> tmp = hashTable[index];
        if (tmp == null) {
            return null;
        }
        for (Entry<K, V> entry : tmp) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }
        return null;
    }

    public void remove(K key) {
        int index = hashIndex(key);
        List<Entry<K, V>> tmp = hashTable[index];
        if (tmp == null) {
            return;
        }
        for (Entry<K, V> entry : tmp) {
            if (entry.getKey().equals(key)) {
                //Remove the entry from the chained list
                tmp.remove(entry);
                //Check if the chained list is empty
                if(tmp.isEmpty()) {
                    //Set the index to null
                    hashTable[index] = null;
                    //Decrease the size
                    size--;
                }
                return;
            }
        }
    }

    public boolean containsKey(K key) {
        return get(key) != null;
    }

    public int size() {
        return size;
    }

    private void resize() {
        List<Entry<K, V>>[] tmp = hashTable;
        //double the limit of the array
        hashTable = new ArrayList[hashTable.length * 2];
        //reset the size
        size = 0;
        //rehash the array
        for (List<Entry<K, V>> x : tmp) {
            //If there is a list in the array, rehash it
            if (x != null) {
                //Rehash each chain list in the array
                for (Entry<K, V> entry : x) {
                    //rehash the key and value
                    insert(entry.getKey(), entry.getValue());
                }
            }
        }
    }

}