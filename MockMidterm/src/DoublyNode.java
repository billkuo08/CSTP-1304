package src;

public class DoublyNode<T> {
    T data;
    DoublyNode<T> next;
    DoublyNode<T> prev;
  
    DoublyNode() {
      next = null;
      prev = null;
    }
}
