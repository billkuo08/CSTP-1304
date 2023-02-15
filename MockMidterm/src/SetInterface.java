package src;

public interface SetInterface<T> {

    public int getCurrentSize();

    public boolean isEmpty();

    /**
     * Adds a new entry to this set, avoiding duplicates.
     * 
     * @param aNewEntry The object to be added as a new entry.
     * @return True if the addition is successful, or
     *         false if the item already is in the set.
     */
    public boolean add(T aNewEntry);

    /**
     * Removes a specific entry from this set, if possible.
     * 
     * @param anEntry The entry to be removed.
     * @return True if the removal was successful, or false if
     *         not.
     */
    public boolean remove(T anEntry);
    //Empty the set
    public void clear();
    //Check if an element exists within the set or not, return true if does
    public boolean contains(T anEntry);
    //Return an array
    public T[] toArray();

    
}
