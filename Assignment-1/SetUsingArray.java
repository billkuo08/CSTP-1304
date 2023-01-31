
public class SetUsingArray<T> implements SetInterface<T> {

    public SetUsingArray() {
       T[] arr;
       arr = (T[]) new Object[10];
    }

    public boolean add(T newEntry) {
        return false;
    }

    public boolean remove(T anEntry) {
        return false;
    }

    public boolean contains(T anEntry) {
        return false;
    }

    public int getCurrentSize() {
        return 0;
    }

    public void clear() {
    }

    public boolean isEmpty() {
        return false;
    }

    public T[] toArray() {
        return null;
    }

       
}