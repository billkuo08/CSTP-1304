package QueueUsingLinkedList;

import javax.xml.transform.Source;

class Queue {

    Node front;
    int size;
  
    Queue() {
      front = null;
      size = 0;
    }
  
    void enqueue(int input) {
      Node aNewNode = new Node();
      aNewNode.data = input;
  
      if (front == null)
        front = aNewNode;
      else {
        // the queue is not empty
        Node tmp = front;
        while (tmp != null) {
          if (tmp.next == null) {
            break;
          }
          tmp = tmp.next;

        }
        tmp.next = aNewNode;

      }
      size += 1;
      
    }
  
    void dequeue() {
      if (front != null) {
        front = front.next;
        size -= 1;    
        return; 
      }

    }

    int getFront(){
        if (front != null) {
            return front.data;
        }
        return -1;
       
    }

    int getSize() {
        return size;
    }

    boolean isEmpty() {
        if(front == null)
            return true;

        return false;    
    }

    boolean contains(int input) {
        Node tmp = front;
        while (tmp != null) {
            if (tmp.data == input) {
                return true;
            }
            tmp = tmp.next;
        }
        return false;
    }
    
  
    public static void main(String[] args) {
      Queue q = new Queue();
      q.enqueue(1); // add 1 to the back of the queue
      q.enqueue(2);
      q.enqueue(3);
      q.dequeue(); // remove 1 from the fron the queue
      q.dequeue(); // remove 2
      System.out.println(q.getFront());  // 3
      System.out.println(q.getSize());//1
      System.out.println(q.isEmpty());// false
      System.out.println(q.contains(1));// false
     
    }
  }