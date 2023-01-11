package QueueUsingCircularLinkedList;

public class Queue {

    Node back;

    Queue() {
        back = null;
    }

    void insert(int inputInteger) {
        Node aNewNode = new Node();
        aNewNode.data = inputInteger;
        if (back == null) {
            // the first node to be added to your ciruclar linked list
            back = aNewNode;
            Node tmp = back;
            back.next = tmp;
        } else {
            // if we have one node
            Node front = back.next; // 1
            back.next = aNewNode; // 2
            aNewNode.next = front; // 3
            back = aNewNode;
        }

    }

    void remove() {
        if (back.next != back) {
            // if more than one node
            Node destinationNode = back.next.next;
            back.next = destinationNode;
        } else {
            // we have only one node or if the queue is empty
            back = null;
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        q.insert(6);
        q.insert(4);
        q.insert(7);
        q.insert(3);
        q.insert(8);
        q.remove();// front to 1
        q.remove();// front to 2
        q.insert(9);
        q.insert(5);// back should be 0
        //System.out.println(q.getFront());// should print 7
        //System.out.println(q.contains(10));// false
        //System.out.println(q.isEmpty());// false
        //System.out.println(q.size());// 5
        //q.printAll();
    }

}
