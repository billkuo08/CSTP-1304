import java.io.ObjectInputFilter.Status;

enum STATUS {
    OCCUPIED,
    UNOCCUPIED,
}

class Item {
    public String value;
    public Integer key;
    public STATUS status;

    Item() {
        value = null;
        key = null;
        status = STATUS.UNOCCUPIED;
    }
}

class DictionaryUsingHashingUsingLinearProbing {
    Item[] arr;
    final int TABLE_SIZE = 23;

    DictionaryUsingHashingUsingLinearProbing() {
        arr = new Item[TABLE_SIZE];// you may renamed arr to hashTable
        for (int i = 0; i < TABLE_SIZE; i++) {
            arr[i] = new Item();
        }
    }

    int getHashIndex(Integer key) {

        int hashCode = key;// TODO implement hasCode using Horner's rule
        int hashIndex = hashCode % TABLE_SIZE;
        return hashIndex;
    }

    // return an available index or return the matching index for "key"
    int probe(int index, int key) {
        // Linearly probe to find an available location
        // boolean found = false;
        int iterator = index + 1;
        while (arr[iterator].status == STATUS.OCCUPIED) {
            // Occupided, check whether the key is at that index
            if (arr[iterator].key == key) {
                // found our key
                return iterator;
            } else {
                iterator = (iterator + 1) % TABLE_SIZE;
            }
        }
        return iterator;
    }

    void insert(Integer key, String value) {
        arr[probe(getHashIndex(key), key)].key = key;
        arr[probe(getHashIndex(key), key)].value = value;
        arr[probe(getHashIndex(key), key)].status = STATUS.OCCUPIED;

    }

    String get(Integer key) {
        return arr[probe(getHashIndex(key), key)].value;
    }

    public static void main(String[] args) {

        DictionaryUsingHashingUsingLinearProbing aDict = new DictionaryUsingHashingUsingLinearProbing();
        aDict.insert(29, "some value1");// should be inserted at index 6
        aDict.insert(32, "some value2");// should be inserted at index 9
        aDict.insert(58, "some value3");// should be inserted at index 12
        aDict.insert(81, "some value4");// should be inserted at index 13
        System.out.println(aDict.get(81));// "some value4"

    }
}