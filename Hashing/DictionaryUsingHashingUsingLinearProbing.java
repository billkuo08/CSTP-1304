
enum STATUS {
    OCCUPIED,
    // UNOCCUPIED,
    EMPTY,
    DELETED // OR AVAILABLE
  }
  
  class DictionaryUsingHashingUsingLinearProbing {
    class Item {
      public String value;
      public Integer key;
      public STATUS status;
  
      Item() {
        value = null;
        key = null;
        status = STATUS.EMPTY;
      }
    }
  
    Item[] arr;
    final int TABLE_SIZE = 23;
  
    DictionaryUsingHashingUsingLinearProbing() {
      arr = new Item[TABLE_SIZE]; // you may rename arr to hashTable
      for (int i = 0; i < TABLE_SIZE; i++) {
        arr[i] = new Item();
      }
    }
  
    private int getHashIndex(Integer key) {
      //
      int hashCode = key; // TODO implement hashCode using Horner's rule
      int hashIndex = hashCode % TABLE_SIZE;
      return hashIndex;
    }
  
    // return an available index or return the matching idex for "key"
    private int probe(int index, int key) {
      // linearly probe to find an available location
      boolean found = false;
      int iterator = index;
      int firstDELETED = -1;
      while (!found && arr[iterator].status != STATUS.EMPTY ) {
        // Occupied, check whether the key is at that index
        if (arr[iterator].status == STATUS.OCCUPIED)
          if (arr[iterator].key == key) { // found our key
            found = true;
          } else
            iterator = (iterator + 1) % TABLE_SIZE;
        else if(arr[iterator].status == STATUS.DELETED) {
          // DELETED
          // track the first empty location
          if (firstDELETED == -1)
            firstDELETED = iterator;
          iterator = (iterator + 1) % TABLE_SIZE;
        }
      }
      if (found || firstDELETED == -1)
        return iterator;
      else {
        return firstDELETED;
      }
    }
  
    public void insert(Integer key, String value) {
      arr[probe(getHashIndex(key), key)].key = key;
      arr[probe(getHashIndex(key), key)].value = value;
      arr[probe(getHashIndex(key), key)].status = STATUS.OCCUPIED;
    }
  
    public String get(Integer key) {
      return arr[probe(getHashIndex(key), key)].value;
    }
  
    public void delete(Integer key) {
      arr[probe(getHashIndex(key), key)].status = STATUS.DELETED; // TODO to be checked
  
    }
  
    public static void main(String[] args) {
      DictionaryUsingHashingUsingLinearProbing aDict = new DictionaryUsingHashingUsingLinearProbing();
      aDict.insert(29, "some value1"); // should be inserted at index 6
      aDict.insert(32, "some value2"); // should be inserted at index 9
      aDict.insert(58, "some value3"); // should be inserted at index 12
      aDict.insert(81, "some value4"); // should be inserted at index 13
      aDict.insert(35, "some value5"); // should be inserted at index 14
      aDict.insert(15, "some value6"); // should be inserted at index 15
      aDict.delete(15);
      aDict.insert(12, "some value7"); // should be inserted at index 15
      // aDict.get(81); // "some value4"
      System.out.println(aDict.get(12)); // "some value7"
    }
  
  }