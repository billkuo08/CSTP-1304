package Src;

import java.util.ArrayList;
import java.util.List;

public class HashDictionaryWithSeparateChaining<K, V> {

    private static final int INITIAL_CAPACITY = 10;
    private static final float RESIZE_FACTOR = 0.8f;

    private List<Entry<K, V>>[] myDict;
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
        myDict = new ArrayList[INITIAL_CAPACITY];
        size = 0;
    }

    private int getIndex(K key) {
        int hash = key.hashCode();
        return hash % INITIAL_CAPACITY;
    }

    public void insert(K key, V value) {
        int index = getIndex(key);
        List<Entry<K, V>> tmp = myDict[index];
        if (tmp == null) {
            tmp = new ArrayList<>();
            myDict[index] = tmp;
        }
        for (Entry<K, V> entry : tmp) {
            if (entry.getKey().equals(key)) {
                tmp.add(entry);
                return;
            }
        }
        tmp.add(new Entry<>(key, value));
        size++;
        if (size > myDict.length * RESIZE_FACTOR) {
            resize();
        }
    }

    public V get(K key) {
        int index = getIndex(key);
        List<Entry<K, V>> tmp = myDict[index];
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
        int index = getIndex(key);
        List<Entry<K, V>> tmp = myDict[index];
        if (tmp == null) {
            return;
        }
        for (Entry<K, V> entry : tmp) {
            if (entry.getKey().equals(key)) {
                tmp.remove(entry);
                if(tmp.isEmpty()) {
                    myDict[index] = null;
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
        List<Entry<K, V>>[] tmp = myDict;
        myDict = new ArrayList[myDict.length * 2];
        size = 0;
        for (List<Entry<K, V>> x : tmp) {
            if (x != null) {
                for (Entry<K, V> entry : x) {
                    insert(entry.getKey(), entry.getValue());
                }
            }
        }
    }

}
