public class ListUsingDoubleLinkedList {
    DoublyNode front;
    DoublyNode back;
    int numOfElements = 0;

    ListUsingDoubleLinkedList() {

    }

    // Helper
    DoublyNode getNode(int position) {
        if (position <= numOfElements) {
            DoublyNode tmp = front;
            int counter = 1;// first position
            while (tmp.next != null && counter <= position) {

                counter++;
                tmp = tmp.next;

            }
            return tmp;
        }
        return null;
    }

    void add(int element) {

        DoublyNode aNewNode = new DoublyNode();
        aNewNode.data = element;

        back.next = aNewNode;
        aNewNode.prev = back;
        back = aNewNode;

        numOfElements++;

    }

    void add(int position, int element) {
        DoublyNode x = getNode(position);
        DoublyNode aNewNode = new DoublyNode();
        aNewNode.data = element;

        aNewNode.next = x;
        aNewNode.prev = x.prev;
        x.prev.next = aNewNode;
        x.prev = aNewNode;

    }

    void remove(int position) {

    }

    int get(int position) {
        return getNode(position).data;

    }

    int size() {
        return -1;
    }

    public static void main(String[] args) {
        ListUsingDoubleLinkedList x = new ListUsingDoubleLinkedList();
        // Position starts from 1
        x.add(10);
        x.add(20);
        x.add(30);
        System.out.println(x.get(3));// 30
        x.add(1, 5);
        System.out.println(x.get(3));// 20
        x.remove(3);
        System.out.println(x.size());// 3
    }

}