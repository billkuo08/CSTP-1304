package Src;

public class HashDictionaryWIthQuadraticProbing {

    private int[] hashTable;
    private int size;
    private final int INITIAL_CAPACITY = 10;
    private final float RESIZE_FACTOR = 0.75f;

    public HashDictionaryWIthQuadraticProbing() {
        hashTable = new int[INITIAL_CAPACITY];
        size = 0;
    }

    private int hash(int key) {
        return key % hashTable.length;
    }

    public void insert(int key, int value) {
        int index = hash(key);
        int offset = 0;
        if (size >= hashTable.length * RESIZE_FACTOR) {
            resize();
        }
        while (hashTable[index] != 0) {
            offset++;
            // Quadratic probing formula
            index = (index + offset * offset) % hashTable.length;
        }
        System.out.println("index: " + index);
        hashTable[index] = value;
        size++;
    }

    public int get(int key) {
        int index = hash(key);
        int offset = 0;
        while (hashTable[index] != 0) {
            if (hashTable[index] == key) {
                return hashTable[index];
            }
            offset++;
            // Quadratic probing formula
            index = (index + offset * offset) % hashTable.length;
        }
        return 0;
    }

    public int size() {
        return size;
    }

    public boolean containsKey(int key) {
        int index = hash(key);
        int offset = 0;
        while (hashTable[index] != 0) {
            if (hashTable[index] == key) {
                return true;
            }
            offset++;
            // Quadratic probing formula
            index = (index + offset * offset) % hashTable.length;
        }
        return false;
    }

    public int remove(int key) {
        int index = hash(key);
        int offset = 0;
        while (hashTable[index] != 0) {
            if (hashTable[index] == key) {
                hashTable[index] = 0;
                size--;
                return key;
            }
            offset++;
            // Quadratic probing formula
            index = (index + offset * offset) % hashTable.length;
        }
        return 0;
    }

    private void resize() {
        int[] tmp = new int[hashTable.length * 2];
        for (int i = 0; i < hashTable.length; i++) {
            if (hashTable[i] != 0) {
                int index = hash(hashTable[i]);
                int offset = 0;
                while (tmp[index] != 0) {
                    offset++;
                    // Quadratic probing formula
                    index = (index + offset * offset) % tmp.length;
                }
                tmp[index] = hashTable[i];
            }
        }
        hashTable = tmp;
    }

}