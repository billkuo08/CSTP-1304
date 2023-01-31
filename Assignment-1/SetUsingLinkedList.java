
import java.util.LinkedList;

public class SetUsingLinkedList<T> implements SetInterface<T> {

  private LinkedList<T> list;

  public SetUsingLinkedList() {
    list = new LinkedList<>();
  }

  public boolean add(T newEntry) {
    if (list.contains(newEntry)) {
      return false;
    } else {
      list.add(newEntry);
      return true;
    }
  }

  public boolean remove(T anEntry) {
    return list.remove(anEntry);
  }

  public boolean contains(T anEntry) {
    return list.contains(anEntry);
  }

  public int getCurrentSize() {
    return list.size();
  }

  public void clear() {
    list.clear();
  }

  public boolean isEmpty() {
    return list.isEmpty();

  }

  public T[] toArray() {
    return (T[]) list.toArray();
  }
}