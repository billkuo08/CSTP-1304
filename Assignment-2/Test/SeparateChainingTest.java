package Test;

import static org.junit.Assert.*;
import org.junit.Test;
import Src.HashDictionaryWithSeparateChaining;

public class SeparateChainingTest {

    @Test
    public void testInsert() {
        HashDictionaryWithSeparateChaining<String, Integer> dict = new HashDictionaryWithSeparateChaining<>();
        dict.insert("A", 1);
        dict.insert("B", 2);
        dict.insert("C", 3);
        dict.insert("D", 4);
        dict.insert("E", 5);  
        assertEquals(5, dict.size());

    }

    @Test
    public void testGet() {
        HashDictionaryWithSeparateChaining<String, Integer> dict = new HashDictionaryWithSeparateChaining<>();
        dict.insert("A", 1);
        dict.insert("B", 2);
        dict.insert("C", 3);
        dict.insert("D", 4);
        dict.insert("E", 5);
        dict.insert("A", 2);// testing the chain list
        dict.insert("B", 3);
        assertEquals(5, dict.size());
        assertEquals(1, (int) dict.get("A"));
        assertEquals(2, (int) dict.get("B"));
        assertEquals(3, (int) dict.get("C"));
        assertEquals(4, (int) dict.get("D"));
        assertEquals(5, (int) dict.get("E"));

    }

    @Test
    public void testRemove() {
        HashDictionaryWithSeparateChaining<String, Integer> dict = new HashDictionaryWithSeparateChaining<>();
        dict.insert("A", 1);
        dict.insert("B", 2);
        dict.insert("C", 3);
        dict.insert("D", 4);
        dict.insert("E", 5);
        dict.insert("A", 2);// testing the chain list
        dict.insert("B", 3);
        assertEquals(5, dict.size());
        dict.remove("A");// first remove
        assertTrue(dict.containsKey("A"));// still contains key A
        assertEquals(5, dict.size());
        dict.remove("A");// second remove
        assertFalse(dict.containsKey("A"));// Now it's all gone
        assertEquals(4, dict.size());// size reduced to 3


    }

    @Test
    public void testResize() {
        HashDictionaryWithSeparateChaining<String, Integer> dict = new HashDictionaryWithSeparateChaining<>();
        dict.insert("A", 1);
        dict.insert("B", 2);
        dict.insert("C", 3);
        dict.insert("D", 4);
        dict.insert("E", 5);
        dict.insert("F", 6);
        dict.insert("G", 7);
        dict.insert("H", 8);
        dict.insert("I", 9);
        dict.insert("J", 10);
        dict.insert("K", 11);
        dict.insert("L", 12);
        assertEquals(12, dict.size());

    }

}