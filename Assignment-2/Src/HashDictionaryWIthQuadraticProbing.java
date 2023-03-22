package Src;

public class HashDictionaryWIthQuadraticProbing<K, V> {

    private static final int TABLE_CAPACITY = 10;
    private static final float RESIZE_FACTOR = 0.8f;

    //Could change it into <Integer, String> if I want to like we did in class
    private Entry<K, V>[] myDict;
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

        public void setValue(V value) {
            this.value = value;
        }
    }

    public HashDictionaryWIthQuadraticProbing() {
        myDict = new Entry[TABLE_CAPACITY];
        size = 0;
    }

    
    public int getIndex(K key) {
        int hash = key.hashCode();
        // return hash % TABLE_CAPACITY; 
        // index starts at 5
        return hash & (myDict.length - 1);
    }
    
    public void insert(K key, V value) {
        int index = getIndex(key);
        for (int i = 0; i < myDict.length;) {
            //Quadratic probing:
            int probe = (index + i * i) % myDict.length;
            System.out.println("probe: " + probe);
            Entry<K, V> entry = myDict[probe];
            if (entry == null) {
                myDict[probe] = new Entry<>(key, value);
                size++;
                if (size > myDict.length * RESIZE_FACTOR) {
                    resize();
                }
                return;
            }
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return;

            }
        }
    }

    public V get(K key) {
        int index = getIndex(key);
        for (int i = 0; i < myDict.length; i++) {
            int probeIndex = (index + i * i) % myDict.length;
            Entry<K, V> entry = myDict[probeIndex];
            if (entry == null) {
                return null;
            }
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }
        return null;
    }

    public void remove(K key) {
        int index = getIndex(key);
        for (int i = 0; i < myDict.length; i++) {
            int probeIndex = (index + i * i) % myDict.length;
            Entry<K, V> entry = myDict[probeIndex];
            if (entry == null) {
                return;
            }
            if (entry.getKey().equals(key)) {
                myDict[probeIndex] = null;
                size--;
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
        Entry<K, V>[] tmp = myDict;
        myDict = new Entry[myDict.length * 2];
        size = 0;
        for (Entry<K, V> entry : tmp) {
            if (entry != null) {
                insert(entry.getKey(), entry.getValue());
            }
        }
    }

}
