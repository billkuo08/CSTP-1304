package src;

import java.util.*;

public class SetUsingCircularLinkedList<T> {
    private CircularNode<T> front;
    private int size;

    public SetUsingCircularLinkedList() {
        front = null;
        size = 0;
    }

    public int getCurrentSize() {
        return size;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public boolean add(T aNewEntry) {
        if (front == null) {
            front = new CircularNode<T>();
            front.data = aNewEntry;
            front.next = front;
            size++;
            return true;
        } else {
            if (!contains(aNewEntry)) {
                CircularNode<T> tmp = front;
                while (tmp.next != front) {
                    tmp = tmp.next;
                }
                CircularNode<T> newNode = new CircularNode<T>();
                newNode.data = aNewEntry;
                newNode.next = front;
                tmp.next = newNode;
                size++;
                return true;
            }
        }
        return false;

    }

    public boolean remove(T anEntry) {
        if (front == null) {
            return false;
        }
        CircularNode<T> tmp = front;
        CircularNode<T> prev = null;
        do {
            if (tmp.data.equals(anEntry)) {
                if (tmp == front) {
                    front = front.next;
                } else {
                    prev.next = tmp.next;
                }
                size--;
                return true;
            }
            prev = tmp;
            tmp = tmp.next;
        } while (tmp != front);

        return false;

    }

    public boolean contains(T anEntry) {
        if (front == null) {
            return false;
        }
        CircularNode<T> tmp = front;
        do {
            if (tmp.data.equals(anEntry)) {
                return true;
            }
            tmp = tmp.next;
        } while (tmp != front);
        return false;
    }

    public void clear() {
        front = null;
        size = 0;
    }

    public T[] toArray() {
        T[] arr = (T[]) new Object[size];
        CircularNode<T> tmp = front;
        for (int i = 0; i < size; i++) {
            arr[i] = tmp.data;
            tmp = tmp.next;
        }
        return arr;
    }

}
