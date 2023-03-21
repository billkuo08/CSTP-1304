package Src;

public class HashDictionaryWIthQuadraticProbing<K, V> {

    private static final int INITIAL_CAPACITY = 16;
    private static final float LOAD_FACTOR = 0.75f;

    private Entry<K, V>[] table;
    private int size;

    public HashDictionaryWIthQuadraticProbing() {
        table = new Entry[INITIAL_CAPACITY];
        size = 0;
    }

    public void put(K key, V value) {
        int index = getIndex(key);
        for (int i = 0; i < table.length; i++) {
            int probeIndex = (index + i * i) % table.length;
            Entry<K, V> entry = table[probeIndex];
            if (entry == null) {
                table[probeIndex] = new Entry<>(key, value);
                size++;
                if (size > table.length * LOAD_FACTOR) {
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
        for (int i = 0; i < table.length; i++) {
            int probeIndex = (index + i * i) % table.length;
            Entry<K, V> entry = table[probeIndex];
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
        for (int i = 0; i < table.length; i++) {
            int probeIndex = (index + i * i) % table.length;
            Entry<K, V> entry = table[probeIndex];
            if (entry == null) {
                return;
            }
            if (entry.getKey().equals(key)) {
                table[probeIndex] = null;
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

    private int getIndex(K key) {
        int hash = key.hashCode();
        return hash & (table.length - 1);
    }

    private void resize() {
        Entry<K, V>[] oldTable = table;
        table = new Entry[table.length * 2];
        size = 0;
        for (Entry<K, V> entry : oldTable) {
            if (entry != null) {
                put(entry.getKey(), entry.getValue());
            }
        }
    }

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
}
