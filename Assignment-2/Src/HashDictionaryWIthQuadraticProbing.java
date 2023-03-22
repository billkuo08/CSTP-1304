package Src;

public class HashDictionaryWIthQuadraticProbing {

    private int[] table;
    private int size;
    private final int INITIAL_CAPACITY = 10;
    private final float RESIZE_FACTOR = 0.75f;

    public HashDictionaryWIthQuadraticProbing() {
        table = new int[INITIAL_CAPACITY];
        size = 0;
    }

    private int hash(int key) {
        return key % table.length;
    }

    public void insert(int key, int value) {
        int index = hash(key);
        int offset = 0;
        if(size >= table.length * RESIZE_FACTOR){
            resize();
        }
        while (table[index] != 0) {
            offset++;
            index = (index + offset*offset) % table.length;
        }
        table[index] = value;
        size++;
    }

  

    public int get(int key) {
        int index = hash(key);
        int offset = 0;
        while (table[index] != 0) {
            if (table[index] == key) {
                return table[index];
            }
            offset++;
            index = (index + offset*offset) % table.length;
        }
        return 0;
    }
    
    public int size() {
        return size;
    }

    public boolean containsKey(int key) {
        int index = hash(key);
        int offset = 0;
        while (table[index] != 0) {
            if (table[index] == key) {
                return true;
            }
            offset++;
            index = (index + offset*offset) % table.length;
        }
        return false;
    }

    public int remove(int key){
        int index = hash(key);
        int offset = 0;
        while (table[index] != 0) {
            if (table[index] == key) {
                table[index] = 0;
                size--;
                return key;
            }
            offset++;
            index = (index + offset*offset) % table.length;
        }
        return 0;
    }

    private void resize() {
        int[] tmp = new int[table.length * 2];
        for (int i = 0; i < table.length; i++) {
            if (table[i] != 0) {
                int index = hash(table[i]);
                int offset = 0;
                while (tmp[index] != 0) {
                    offset++;
                    index = (index + offset*offset) % tmp.length;
                }
                tmp[index] = table[i];
            }
        }
        table = tmp;
    }

}