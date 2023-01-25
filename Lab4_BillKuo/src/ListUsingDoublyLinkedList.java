package src;

public class ListUsingDoublyLinkedList implements List {
  DoublyNode front;
  DoublyNode back;
  int numberOfElements = 0;

  ListUsingDoublyLinkedList() {

  }

  // helper function
  DoublyNode getNode(int position) {
    if (position <= numberOfElements) {
      DoublyNode tmp = front;
      int counter = 1; // first position
      while (tmp.next != null && (counter < position)) {
        counter++;
        tmp = tmp.next;
      }
      return tmp;
    }
    return null;
  }

  public void add(int element) {
    DoublyNode aNewNode = new DoublyNode();
    aNewNode.data = element;

    if (numberOfElements == 0) {
      front = aNewNode;
      back = aNewNode;
      front.prev = null;
      back.next = null;

    } else {
      back.next = aNewNode;
      aNewNode.prev = back;
      back = aNewNode;
      back.next = null;
    }
    numberOfElements++;

  }

  public void add(int position, int element) {
    DoublyNode x = getNode(position);
    DoublyNode aNewNode = new DoublyNode();
    aNewNode.data = element;
    // @TODO
    // think about the case when position is 1
    if (position == 1) {
      aNewNode.next = front;
      front.prev = aNewNode;
      aNewNode.prev = null;
      front = aNewNode;
    } else {
      aNewNode.next = x;
      aNewNode.prev = x.prev;
      x.prev.next = aNewNode;
      x.prev = aNewNode;
    }

    numberOfElements++;
  }

  /**
   * @param position
   */
  public void remove(int position) {
    // @TODO
    DoublyNode x = getNode(position);

    if (front == null) {
      return;

    } else {
    
      if (x == front) {
        front = x.next;
      } else if (x == back) {
        back = back.prev;
      } else {
        x.prev.next = x.next;
        x.next.prev = x.prev;
      }
      x = null;

    }

    numberOfElements--;

  }

  public int get(int position) {
    return getNode(position).data;
  }

  public int size() {
    return numberOfElements;
  }

  public static void main(String[] args) {
    ListUsingDoublyLinkedList x = new ListUsingDoublyLinkedList();
    // Position starts from 1
    x.add(10);
    x.add(20);
    x.add(30);
    System.out.println(x.get(3));// 30
    x.add(1, 5);
    System.out.println(x.get(3));// 20
    x.remove(3); // 20
    // System.out.println(x.size());// 3
  }

}
