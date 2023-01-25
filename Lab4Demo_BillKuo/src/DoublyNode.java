package src;
public class DoublyNode<E> {
  E data;
  DoublyNode<E> next;
  DoublyNode<E> prev;

  DoublyNode() {
    next = null;
    prev = null;
  }
}
