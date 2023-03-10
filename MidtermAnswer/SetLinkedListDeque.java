public class SetLinkedListDeque<T> implements NoDuplicatesDeQueueInterface<T> {

    int numElements;
    Node dummy;

    SetLinkedListDeque(){
        numElements = 0;
        dummy = new Node();

    }
    class Node{
        T value;
        Node next;
        Node(){
            next = null;
        }
    }
    @Override
    public boolean addFirst(T item) throws Exception {
        if(contains(item)) return false;
        Node newNode = new Node();
        newNode.value = item;
        if(numElements == 0){
            dummy.next = newNode;
            numElements++;
            return true;
        }
        newNode.next = dummy.next;
        dummy.next = newNode;
        numElements++;
        return true;
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean addLast(T item) throws Exception {
        if(contains(item)) return false;
        Node newNode = new Node();
        newNode.value = item;
        if(numElements == 0){
            dummy.next = newNode;
            numElements++;
            return true;
        }

        Node tmp = dummy.next;
        while(tmp.next != null){
            tmp = tmp.next;
        }
        tmp.next = newNode;
        numElements++;
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean removeFirst() throws Exception {

        if(numElements > 0){
            Node remove = dummy.next;
            dummy.next = remove.next;
            remove.next = null;
            numElements--;
            return true;
        }
        // TODO Auto-generated method stub
        throw new Exception("Empty Set");
    }

    @Override
    public boolean removeLast() throws Exception {
        if(numElements > 0){
            Node tmp = dummy.next;
            
            while(tmp.next.next != null){
                tmp = tmp.next;
            }
            numElements--;
            tmp.next = null;
            return true;
        }
        // TODO Auto-generated method stub
        throw new Exception("Empty Set");
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
            Node tmp = dummy.next;
        while(tmp.next != null){
            tmp = tmp.next;
        }
        return tmp.value;
        }
        // TODO Auto-generated method stub
        throw new Exception("Empty Set");
    }

    @Override
    public boolean contains(T item){
        if(numElements == 0)  return false;

        Node tmp = dummy.next;
        while (tmp != null) {
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
        dummy.next = null;
        numElements = 0;
        // TODO Auto-generated method stub
        
    }


  
}
