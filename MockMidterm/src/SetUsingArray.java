package src;

import java.util.Arrays;

public class SetUsingArray<T> implements SetInterface<T> {
    T[] arr;
    T[] tmp;
    int size;
    public int CAPACITY = 10;

    public SetUsingArray() {
        arr = (T[]) new Object[CAPACITY];
        size = 1;

    }

    public boolean add(T newEntry) {
        double data = CAPACITY * 0.8;
        int newCap = (int) data;
        if (size >= newCap) {
            tmp = (T[]) new Object[CAPACITY * 2];
            // for (int i = 0; i < CAPACITY; i++) {
            //     tmp[i] = arr[i];
            // }
            System.arraycopy(arr,0,tmp,0, CAPACITY);
            arr = tmp;
            CAPACITY = CAPACITY * 2;

        }

        if (!contains(newEntry)) {
            if (size == arr.length) {
                arr = Arrays.copyOf(arr, arr.length + 1);
            }
            arr[size++] = newEntry;

            return true;
        }
        return false;
    }

    public boolean remove(T anEntry) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == anEntry) {
                arr[i] = arr[size - 1];
                size--;
                return true;
            }
        }
        return false;

    }

    public boolean contains(T anEntry) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == anEntry) {
                return true;
            }
        }
        return false;

    }

    public int getCurrentSize() {
        return size;
    }

    public void clear() {
        size = 0;
        arr = (T[]) new Object[0];

    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public T[] toArray() {
        return Arrays.copyOf(arr, size);
    }

    public static void main(String[] args) {
        SetUsingArray<Integer> mySet = new SetUsingArray<>();
        mySet.add(1);// add when set is null
        mySet.add(2);
        mySet.add(2);// Should not be added due to duplicate
        mySet.add(3);
        mySet.add(4);
        mySet.add(4);// Should not be added due to duplicate
        mySet.add(5);
        mySet.add(6);
        mySet.add(7);
        mySet.add(8);
        mySet.add(9);

    }

}