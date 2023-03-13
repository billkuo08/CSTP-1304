public class SetDoublyCircularLinkedListDeque<T> implements NoDuplicatesDeQueueInterface<T> {

    Node dummy;
    int numElements;

    SetDoublyCircularLinkedListDeque(){
        dummy  = new Node();
        dummy.next = dummy;
        dummy.prev = dummy;
        numElements = 0;
    }
    class Node{
        T value;
        Node next;
        Node prev;

        Node(){
            next = null;
            prev = null;
        }
    }

    @Override
    public boolean addFirst(T item) {
        if(contains(item)) return false;
        Node newNode = new Node();
        newNode.value = item;
        dummy.next.prev = newNode;
        newNode.next = dummy.next;
        dummy.next = newNode;
        newNode.prev = dummy;       
        numElements++;
        return true;
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean addLast(T item) {

        // TODO Auto-generated method stub
        if(contains(item)) return false;
        Node newNode = new Node();
        newNode.value = item;
        dummy.prev.next = newNode;
        newNode.prev = dummy.prev;
        dummy.prev = newNode;       
        newNode.next = dummy;
        numElements++;
        return true;
    }

    @Override
    public boolean removeFirst() throws Exception {
        if(numElements == 0){
            throw new Exception("Empty Set");
        }
        else{if(numElements == 0) return false;
            if(numElements == 1){
                dummy.next = dummy;
                dummy.prev = dummy;
                numElements = 0;
                return true;
            }
            Node element = dummy.next;
            element.next.prev = dummy;
            dummy.next = element.next;
            element.next = null;
            element.prev = null;
            numElements--;
            return true;}
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean removeLast() throws Exception {
        if(numElements == 0){
            throw new Exception("Empty Set");
        }
        else{
            if(numElements == 0) return false;
            if(numElements == 1){
                dummy.next = dummy;
                dummy.prev = dummy;
                numElements = 0;
                return true;
            }
            Node element = dummy.prev;
            element.prev.next = dummy;
            dummy.prev = element.prev;
            element.next = null;
            element.prev = null;
            numElements--;
            return true;
        }
        // TODO Auto-generated method stub
        
    }

    @Override
    public T getFirst() throws Exception {
        if(numElements > 0){
            return dummy.next.value;
        }
        // TODO Auto-generated method stub
        throw new Exception("Empty Set");
    }

    @Override
    public T getLast() throws Exception {
        if(numElements > 0){
            return dummy.prev.value;
        }
        // TODO Auto-generated method stub
        throw new Exception("Empty Set");
    }

    @Override
    public boolean contains(T item) {
        if(numElements == 0){
            return false;
        }
        Node tmp = dummy.next;
        while(tmp != dummy){
            if(tmp.value == item){
                return true;
            }
            tmp = tmp.next;
        }
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public int getCurrentSize() {
        // TODO Auto-generated method stub
        return numElements;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        if(numElements == 0){
            return true;
        }
        return false;
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub
        dummy.next = dummy;
        dummy.prev = dummy;
        numElements = 0;
        
    }


  
}
