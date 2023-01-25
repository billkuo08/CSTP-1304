package src;

public class ListUsingLinkedList implements List {
    Node front;
    int numberOfElements;

    ListUsingLinkedList() {
        front = null;
        numberOfElements = 0;
    }

    Node getNode(int position) {
        if (position > numberOfElements) {
            return null;
        }
        Node tmp = front;
        if (front != null) {
            int counter = 1; // first position
            while (counter < position) {
                counter++;
                tmp = tmp.next;
            }
        }
        return tmp;

    }

    public void add(int element) {
        // Node aNewNode = new Node();
        // aNewNode.data = element;

        // front = aNewNode;
        // numberOfElements++;
        add(numberOfElements + 1, element);
    }

    public void add(int position, int element) {
        Node aNewNode = new Node();
        aNewNode.data = element;
        Node x = getNode(position - 1);

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

    public void remove(int position) {
        if (position > 1) {
            Node prevNode = getNode(position - 1);
            Node tmp = prevNode.next;
            prevNode.next = prevNode.next.next;
            tmp.next = null;
            numberOfElements--;
        } else if (position == 1) {
            Node tmp = front;
            front = front.next;
            tmp.next = null;
            numberOfElements--;
        } else {
            System.out.println("Invalid position");
        }
    }

    public int get(int position) {
        if (position >= 1) {
            return getNode(position).data;
        }
        return -1;
    }

    public int size() {
        return numberOfElements;
    }

    public static void main(String[] args) {
        List x = new ListUsingLinkedList();
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