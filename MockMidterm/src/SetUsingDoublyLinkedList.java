package src;

import java.util.Iterator;
import java.util.LinkedList;

public class SetUsingDoublyLinkedList<T> implements SetInterface<T> {
    private DoublyNode<T> front;
    private DoublyNode<T> back;
    private int size;

    public SetUsingDoublyLinkedList() {
        front = null;
        back = null;
        size = 0;
    }

    DoublyNode<T> getNode(int position) {
        if (position > size) {
            return null;
        }
        DoublyNode<T> tmp = front;
        if (front != null) {
            int counter = 1; // first position
            while (tmp.next != null && counter < position) {
                counter++;
                tmp = tmp.next;
            }
        }
        return tmp;

    }

    @Override
    public int getCurrentSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;

    }

    @Override
    public boolean add(T newEntry) {
        DoublyNode<T> tmp = new DoublyNode();
        tmp.data = newEntry;
        if (front == null) {
            front = tmp;
            back = tmp;
            front.prev = null;
            back.next = null;
            size++;
            return true;

        } else {
            DoublyNode<T> tmp2 = front;
            while (tmp2.next != null) {
                if (tmp2.data.equals(newEntry)) {
                    return false;
                }
                tmp2 = tmp2.next;
            }
            if(tmp2.data.equals(newEntry)) {
                return false;
            }
            back.next = tmp;
            tmp.prev = back;
            back = tmp;
            back.next = null;
            size++;
            return true;

        }
    }

    @Override
    public boolean remove(T anEntry) {
        DoublyNode<T> tmp = front;
        if (tmp == null) {
            return false;
        }
        while (tmp.next != null) {
            if (tmp.data.equals(anEntry)) {
                if (tmp.prev != null) {
                    tmp.prev.next = tmp.next;
                } else {
                    front = tmp.next;
                }
                if (tmp.next != null) {
                    tmp.next.prev = tmp.prev;
                } else {
                    back = tmp.prev;
                }
                size--;
                return true;
            }
            tmp = tmp.next;
        }

        return false;

    }

    @Override
    public void clear() {

        if (front != null) {
            front = null;
            size = 0;
        }
    }

    @Override
    public boolean contains(T anEntry) {
        if (front != null) {
            DoublyNode<T> tmp = front;
            while (tmp.next != null) {
                if (tmp.data.equals(anEntry)) {
                    return true;
                }
                tmp = tmp.next;
            }
            if (tmp.data.equals(anEntry)) {
                return true;
            }

        }
        return false;
    }

    @Override
    public T[] toArray() {
        if (front != null) {
            DoublyNode<T> tmp = front;
            LinkedList<T> myList = new LinkedList<>();
            while (tmp.next != null) {
                myList.add(tmp.data);
                tmp = tmp.next;
            }
            myList.add(tmp.data);
            T[] arr = myList.toArray((T[]) new Object[myList.size()]);
            return arr;
        }
        return null;

    }

    public static void main(String[] args) {
        SetUsingDoublyLinkedList<Integer> mySet = new SetUsingDoublyLinkedList<>();
        mySet.add(1);// add when set is null
        mySet.add(2);
        mySet.add(2);// Should not be added due to duplicate
        mySet.add(3);
        mySet.add(4);
        mySet.add(4);// Should not be added due to duplicate

    }

}
