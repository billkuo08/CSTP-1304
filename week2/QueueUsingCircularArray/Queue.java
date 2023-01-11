package QueueUsingCircularArray;

public class Queue {

    Integer[] arr;
    int front;
    int num; // number of elements in the queue
    final int MAXSIZE = 6;

    Queue() {
        arr = new Integer[6];
        front = 0;
        num = 0;
    }

    void insert(int element) {
        // insert the element at the back of the queue
        int back = (front + num) % MAXSIZE;
        arr[back] = element;
        num++;

    }

    void remove() {
        front = (front + 1) % MAXSIZE;
        num--;
    }

    int getFront() {
        if (num != 0)
            return arr[front];
        return -1; // to indicate that the queue is empty
    }

    boolean contains(int input) {
        for (int i = 0; i < num; i++) {
            if (arr[(front + i) % MAXSIZE] == input)
                return true;
        }
        return false;

    }

    boolean isEmpty(){
        if(num == 0)
            return true;
        return false;
    }

    int size(){
        return num;
    }

    void printAll(){
        for (int i = 0; i < num; i++) {
            System.out.println(arr[(front + i) % MAXSIZE]);
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
        System.out.println(q.contains(4     ));// false
        // System.out.println(q.isEmpty());// false
        // System.out.println(q.size());// 5
        q.printAll();
    }

}

