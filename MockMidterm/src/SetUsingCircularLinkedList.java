package src;

import java.util.*;

public class SetUsingCircularLinkedList<T> {
    private CircularNode<T> front;
    private CircularNode<T> back;
    private int size;

    public SetUsingCircularLinkedList() {
        front = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean add(T aNewEntry) {
        CircularNode<T> newNode = new CircularNode();
        if (front == null) {
            front = newNode;
            front.next = front;
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

    // public boolean remove(T anEntry) {

    // }

}
