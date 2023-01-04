public class StackUsingLinkList{

    Node head;

    StackUsingLinkList(){
        head = null;

    }

    void push(int anElement){
        Node newNode = new Node();
        newNode.data = anElement;

        newNode.next = head;
        head = newNode;

    }

    void pop(){
        ;
    }

    int peek(){
        
        return head.data;

    }
}