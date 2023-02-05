package src;

import java.util.Arrays;

public class SetUsingArray<T> implements SetInterface<T> {
    T[] arr;
    int size;

    public SetUsingArray() {
        arr = (T[]) new Object[10];
        size = 0;

    }

    public boolean add(T newEntry) {

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

}