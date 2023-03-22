package Src;

public class HashDictionaryWIthQuadraticProbing {

    private int[] hashTable;
    private int size;
    private final int INITIAL_CAPACITY = 10;
    private final float RESIZE_FACTOR = 0.8f;

    public HashDictionaryWIthQuadraticProbing() {
        hashTable = new int[INITIAL_CAPACITY];
        size = 0;
    }

    private int hashIndex(int key) {
        return key % hashTable.length;
    }

    public void insert(int key, int value) {
        int index = hashIndex(key);
        int quadFactor = 0;        
        while (hashTable[index] != 0) {
            // Quadratic probing formula
            quadFactor++;
            index = (index + quadFactor * quadFactor) % hashTable.length;
            // index = (1 + quadFactor * quadFactor) % hashTable.length;

        }

        System.out.println("index: " + index + " value: " + value);
        hashTable[index] = value;
        size++;
        if (size > hashTable.length * RESIZE_FACTOR) {
            resize();
        }
    }

    public int get(int key) {
        int index = hashIndex(key);
        int quadFactor = 0;
        while (hashTable[index] != 0) {
            if (hashTable[index] == key) {
                return hashTable[index];
            }
            quadFactor++;
            // Quadratic probing formula
            index = (index + quadFactor * quadFactor) % hashTable.length;
        }
        return 0;
    }

    public int size() {
        return size;
    }

    public boolean containsKey(int key) {
        int index = hashIndex(key);
        int quadFactor = 0;
        while (hashTable[index] != 0) {
            if (hashTable[index] == key) {
                return true;
            }
            quadFactor++;
            // Quadratic probing formula
            index = (index + quadFactor * quadFactor) % hashTable.length;
        }
        return false;
    }

    public int remove(int key) {
        int index = hashIndex(key);
        int quadFactor = 0;
        while (hashTable[index] != 0) {
            if (hashTable[index] == key) {
                hashTable[index] = 0;
                size--;
                return key;
            }
            quadFactor++;
            // Quadratic probing formula
            index = (index + quadFactor * quadFactor) % hashTable.length;
        }
        return 0;
    }

    private void resize() {
        int[] tmp = new int[hashTable.length * 2];
        for (int i = 0; i < hashTable.length; i++) {
            if (hashTable[i] != 0) {
                int index = hashIndex(hashTable[i]);
                int quadFactor = 0;
                while (tmp[index] != 0) {
                    quadFactor++;
                    // Quadratic probing formula
                    index = (index + quadFactor * quadFactor) % tmp.length;
                }
                tmp[index] = hashTable[i];
            }
        }
        hashTable = tmp;
    }

}