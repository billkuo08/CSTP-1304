package src;

public interface SetInterface<T> {

    public int getCurrentSize();

    public boolean isEmpty();

    /**
     * Adds a new entry to this set, avoiding duplicates.
     * 
     * @param item The object to be added as a new entry.
     * @return True if the addition is successful, or
     *         false if the item already is in the set.
     */
    public boolean add(T item);

    /**
     * Removes a specific entry from this set, if possible.
     * 
     * @param item The entry to be removed.
     * @return True if the removal was successful, or false if
     *         not.
     */
    public boolean remove(T item);
    //Empty the set
    public void clear();
    //Check if an element exists within the set or not, return true if does
    public boolean contains(T item);
    //Return an array
    public T[] toArray();
}
