package src;

public class ListUsingLinkedList<E> implements List<E> {
    Node<E> front;
    int numberOfElements;

    ListUsingLinkedList() {
        front = null;
        numberOfElements = 0;
    }

    Node<E> getNode(int position) {
        if (position > numberOfElements) {
            return null;
        }
        Node<E> tmp = front;
        if (front != null) {
            int counter = 1; // first position
            while (counter < position) {
                counter++;
                tmp = tmp.next;
            }
        }
        return tmp;

    }

    public void add(E element) throws CapacityReachedListException {
        // Node aNewNode = new Node();
        // aNewNode.data = element;

        // front = aNewNode;
        // numberOfElements++;
        add(numberOfElements + 1, element);
    }

    public void add(int position, E element) {
        Node<E> aNewNode = new Node<E>();
        aNewNode.data = element;
        Node<E> x = getNode(position - 1);

        if (position == 1) {
            aNewNode.next = front;
            front = aNewNode;
            numberOfElements++;

        } else if (position > 1) {
            aNewNode.next = x.next;
            x.next = aNewNode;
            numberOfElements++;

        } else {
            System.out.println("Invalid position");
        }

    }

    public void remove(int position) throws RemovalOnAnEmptyListException {
        if (position > 1 && numberOfElements > 1) {
            Node<E> prevNode = getNode(position - 1);
            Node<E> tmp = prevNode.next;
            prevNode.next = prevNode.next.next;
            tmp.next = null;
            numberOfElements--;
        } else if (numberOfElements == 1) {
            Node<E> tmp = front;
            front = front.next;
            tmp.next = null;
            numberOfElements--;
        } else {

            // System.out.println("Invalid position");
            // Unchecked Exception
            //throw new RuntimeException("You should not remove from an empty list");
            throw new RemovalOnAnEmptyListException("You should not remove from an empty list");


        }
    }

    public E get(int position) {
        if (position >= 1) {
            return getNode(position).data;
        }
        return null;
    }

    public int size() {
        return numberOfElements;
    }

    public static void main(String[] args) {
        List<Integer> x = new ListUsingLinkedList<Integer>();
        try {
            // Position starts from 1
            x.add(10);
            x.add(20);
            x.add(30);
            System.out.println(x.get(3));// 30
            x.add(1, 5);
            System.out.println(x.get(3));// 20
            x.remove(3); // 20
            x.remove(1);
            x.remove(1);
            x.remove(1);
            System.out.println(x.size());// 0
            x.remove(1); // should throw an exception
            System.out.println(x.size());// this should still be print
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}