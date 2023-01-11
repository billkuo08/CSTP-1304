package QueueUsingCircularArray;

public class Queue {

    Integer []arr;
    int front;
    int num; // number of elements in the queue
    final int MAXSIZE = 6;

    Queue(){
        arr = new Integer[6];
        front = 0;
        num = 0;
    }

    void insert(int element) {
        //insert the element at the back of the queue
        int back = (front + num)%MAXSIZE;
        arr[back] = element;
        num ++;


    }

    void remove(){
        front = (front + 1)%MAXSIZE;
        num --;
    }

    int getFront(){
        if(num != 0)
         return arr[front];
        return -1; // to indicate that the queue is empty
    }

    boolean contains(){
        if()
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        q.insert(6);
        q.insert(4);
        q.insert(7);
        q.insert(3);
        q.insert(8);
        q.remove();//front to 1
        q.remove();//front to 2
        q.insert(9);
        q.insert(5);//back should be 0 and this should fail because it exceeds the MAXSIZE
        q.getFront();// should print 7
        // q.contains(10);
        // q.isEmpty();//false
        // q.size();//5
        // q.printAll();
      }

}
