package src;

public class ListUsingArray<E> implements List<E> {
  E[] arr;
  int numberOfElements;
  final int ARR_SIZE = 11;
  final int MAX_CAPACITY = ARR_SIZE - 1;

  ListUsingArray() {
    arr = (E[])new Object[ARR_SIZE]; // 10 items
    numberOfElements = 0;
  }

  public void add(E element) {
    if (numberOfElements != MAX_CAPACITY) {
      numberOfElements = numberOfElements + 1;
      arr[numberOfElements] = element;
    }
  }

  // position is >= 1
  public void add(int position, E element) {
    if (numberOfElements != MAX_CAPACITY) {
      // shifting to the right >>
      for (int i = numberOfElements; i > position; i--) {
        arr[i + 1] = arr[i];
      }
      arr[position] = element;
      numberOfElements++;
    }
  }

  public void remove(int position) {
    if (numberOfElements >= 1
        && (position <= numberOfElements && position >= 1)) {
      // shifting to the left <<
      for (int i = position; i < numberOfElements; i++) {
        arr[i] = arr[i + 1];
      }
      numberOfElements--;
    }
  }

  public E get(int position) {

    E x = arr[position];
    return x;

  }

  public int size() {
    return numberOfElements;
  }

  public static void main(String[] args) {
    ListUsingArray<Integer> x = new ListUsingArray<Integer>();
    // Position starts from 1
    x.add(10);
    x.add(20);
    x.add(30);
    System.out.println(x.get(3));// 30
    x.add(1, 5);
    System.out.println(x.get(3));// 20
    x.remove(3); // 20
    System.out.println(x.size());// 3
  }
}