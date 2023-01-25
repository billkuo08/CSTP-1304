package src;
//List is a collecttion of ordered items
//each item has a position
//positioning starts from 1

public interface List {

    //add an elemnt to the end of the list
    public void add(int element);

    //add an element at a specific position in the list
    public void add(int position, int element);

    //add an element to specific position in the list
    public void remove(int position);

    //add an element to specific position in the list
    public int get(int position);

    //get the size of the list
    public int size();
}
