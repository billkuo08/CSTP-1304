package src;
//List is a collecttion of ordered items
//each item has a position
//positioning starts from 1

public interface List<E> {

    //add an elemnt to the end of the list
    public void add(E element) throws CapacityReachedListException;

    //add an element at a specific position in the list
    public void add(int position, E element);

    //add an element to specific position in the list
    public void remove(int position) throws RemovalOnAnEmptyListException;

    //add an element to specific position in the list
    public E get(int position);

    //get the size of the list
    public int size();
}
