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
        CircularNode<T> newNode = new CircularNode();
        if (front == null) {
            front = newNode;
            front.next = front;
            size++;
            return true;
        } else {
            CircularNode<T> tmp = front;
            while (tmp.next != front && tmp.data != aNewEntry) {
                tmp = tmp.next;
            }
            if (tmp.data != aNewEntry) {
                tmp.next = newNode;
                newNode.next = front;
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
        if (front.data.equals(anEntry)) {
            if (front.next == front) {
                front = null;
                size--;
                return true;
            } else {
                CircularNode<T> tmp = front;
                while (tmp.next != front) {
                    front = front.next;
                }
                tmp.next = front.next;
                front = front.next;
                size--;
                return true;
            }
        } else {
            CircularNode<T> tmp = front;
            while (tmp.next != front && !tmp.next.data.equals(anEntry)) {
                tmp = tmp.next;
            }
            if (tmp.next.data.equals(anEntry)) {
                tmp.next = tmp.next.next;
                size--;
                return true;
            }
        }
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
        if (front != null) {
            front = null;
            size = 0;
        }
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
