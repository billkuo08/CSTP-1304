package test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


import org.junit.Test;

import src.SetUsingArray;

public class SetUsingArrayTest {

    @Test
    public void sizeAndIsEmptyTest() {
        SetUsingArray<Integer> mySet = new SetUsingArray<>();

        assertTrue(mySet.isEmpty());// Return true because it is empty atm
        assertEquals(0, mySet.getCurrentSize());
        mySet.add(1);
        assertEquals(1, mySet.getCurrentSize());
        mySet.add(2);
        assertEquals(2, mySet.getCurrentSize());
        mySet.add(3);
        assertEquals(3, mySet.getCurrentSize());
        assertFalse(mySet.isEmpty());// no longer an empty set

    }

    @Test
    public void addAndContainTest() {
        SetUsingArray<Integer> mySet = new SetUsingArray<>();
        assertFalse(mySet.contains(1));// Will pass because when set is null, it returns full
        mySet.add(1);// add when set is null
        mySet.add(2);
        mySet.add(2);// Should not be added due to duplicate
        mySet.add(3);
        mySet.add(4);
        mySet.add(4);// Should not be added due to duplicate
        assertTrue(mySet.contains(3));// return true if contains 3
        assertEquals(4, mySet.getCurrentSize());

    }

    @Test
    public void removeTest() {
        SetUsingArray<Integer> mySet = new SetUsingArray<>();
        assertFalse(mySet.remove(1));// Return false because the set is empty
        mySet.add(1);
        assertTrue(mySet.remove(1));// Return true when removing from a set with only one element
        mySet.add(2);
        mySet.add(3);
        mySet.add(4);
        assertTrue(mySet.remove(2));// Return true when removing from a set with multiple elements
        assertFalse(mySet.contains(1));// 1 removed
        assertFalse(mySet.contains(2));// 2 removed
        assertTrue(mySet.contains(3));// 3 still exists
        assertTrue(mySet.contains(4));// 4 still exists
        assertEquals(2, mySet.getCurrentSize());// size of set is 2 now

    }

    @Test
    public void clearTest() {
        SetUsingArray<Integer> mySet = new SetUsingArray<>();
        mySet.add(1);
        mySet.add(2);
        mySet.add(3);
        mySet.add(4);
        assertEquals(4, mySet.getCurrentSize());// Check the size of the set
        mySet.clear();
        assertEquals(0, mySet.getCurrentSize());// Check the size of the set again, should be 0 now
        assertTrue(mySet.isEmpty());

    }

    @Test
    public void toArrayTest() {
        SetUsingArray<Integer> mySet = new SetUsingArray<>();
        mySet.add(1);
        mySet.add(2);
        mySet.add(3);
        mySet.add(4);
        assertArrayEquals(mySet.toArray(), new Integer[] {1, 2, 3, 4});// Test if the set became an array


    }
 
}
