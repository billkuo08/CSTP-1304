public class DequeueUsingDoublyLinkedList {
    DoublyNode front;
    DoublyNode back;

    DequeueUsingDoublyLinkedList() {
        front = null;
        back = null;
    }

    void addFirst(int anItem) {
        DoublyNode aNewNode = new DoublyNode();
        aNewNode.data = anItem;

        if (front == null) {
            front = aNewNode;
            back = aNewNode;

        } else {

            aNewNode.next = front;
            front.prev = aNewNode;
            front = aNewNode;
        }

    }

    void addLast(int anItem) {
        DoublyNode aNewNode = new DoublyNode();
        aNewNode.data = anItem;

        if (back == null) {
            back = aNewNode;
            front = aNewNode;

        } else {

            back.next = aNewNode;
            aNewNode.prev = back;
            back = aNewNode;
        }

    }

    void removeFirst(){
        front = front.next;    
    }

    void removeLast(){
        back = back.prev;
    }

    int getLast() {

        return back.data;

    }

    int getFirst() {

        return front.data;

    }

    public static void main(String[] args) {

        DequeueUsingDoublyLinkedList aDequeue = new DequeueUsingDoublyLinkedList();
        aDequeue.addFirst(1);
        aDequeue.addFirst(2);
        //System.out.println(aDequeue.getLast());// 1
        aDequeue.addLast(3);
        //System.out.println(aDequeue.getFirst());// 2
        System.out.println(aDequeue.getLast());// 3
        aDequeue.removeLast();
        System.out.println(aDequeue.getLast());// 1

    }

}