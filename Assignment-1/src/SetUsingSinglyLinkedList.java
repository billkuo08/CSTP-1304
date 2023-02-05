package src;
import java.util.LinkedList;

public class SetUsingSinglyLinkedList<T> implements SetInterface<T> {
    Node<T> front;
    int size;

    public SetUsingSinglyLinkedList() {
        front = null;
        size = 0;
    }

    Node<T> getNode(int position) {
        if (position > size) {
            return null;
        }
        Node<T> tmp = front;
        if (front != null) {
            int counter = 1; // first position
            while (counter < position) {
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
        if(size == 0) {
            return true;
        }
        return false;
        
    }

    @Override
    public boolean add(T newEntry) {
        if(front == null) {
            front = new Node<T>();
            front.data = newEntry;
            size++;
            return true;
        }
        if(front != null) {
            Node<T> tmp = front;
            while(tmp.next != null) {
                if(tmp.data.equals(newEntry)) {
                    return false;
                }
                tmp = tmp.next;
            }
            if(tmp.data.equals(newEntry)) {
                return false;
            }
            tmp.next = new Node<T>();
            tmp.next.data = newEntry;
            size++;
        }   

        return true;

    }

    @Override
    public boolean remove(T anEntry) {
        if(front != null) {
            Node<T> tmp = front;
            if(tmp.data.equals(anEntry)) {
                front = front.next;
                size--;
                return true;
            }
            while(tmp.next != null) {
                if(tmp.next.data.equals(anEntry)) {
                    tmp.next = tmp.next.next;
                    size--;
                    return true;
                }
                tmp = tmp.next;
            }
        } 

        return false;
        
     }

    @Override
    public void clear() {
        
        if(front != null) {
            front = null;
            size = 0;
        }
    }

    @Override
    public boolean contains(T anEntry) {
        if(front != null) {
            Node<T> tmp = front;
            while(tmp.next != null) {
                if(tmp.data.equals(anEntry)) {
                    return true;
                }
                tmp = tmp.next;
            }
            if(tmp.data.equals(anEntry)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public T[] toArray() {        
        if(front != null) {
            Node<T> tmp = front;
            LinkedList<T> myList = new LinkedList<>();
            while(tmp.next != null) {
                myList.add(tmp.data);
                tmp = tmp.next;
            }            
            myList.add(tmp.data);
            T[] arr = myList.toArray((T[]) new Object[myList.size()]);
            return arr;
        }
        return null;
       
    }

}
