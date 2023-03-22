package Test;

import static org.junit.Assert.*;
import org.junit.Test;
import Src.HashDictionaryWIthQuadraticProbing;

public class QuadraticProbingTest {

    @Test
    public void testPut() {
        HashDictionaryWIthQuadraticProbing<String, Integer> dict = new HashDictionaryWIthQuadraticProbing<>();
        dict.insert("A", 1);
        dict.insert("A", 2);
        dict.insert("A", 3);
        dict.insert("A", 4);
        dict.insert("A", 5);   
        // assertEquals(5, dict.size());
       
    }

    @Test
    public void testGet() {
        HashDictionaryWIthQuadraticProbing<String, Integer> dict = new HashDictionaryWIthQuadraticProbing<>();
        dict.insert("A", 1);
        dict.insert("B", 2);
        dict.insert("C", 3);
        dict.insert("D", 4);
        dict.insert("E", 5);       
        assertEquals(5, dict.size());
        assertEquals(1, (int) dict.get("A"));
        assertEquals(2, (int) dict.get("B"));
        assertEquals(3, (int) dict.get("C"));
        assertEquals(4, (int) dict.get("D"));
        assertEquals(5, (int) dict.get("E"));
      
    }

    @Test
    public void testRemove() {
        HashDictionaryWIthQuadraticProbing<String, Integer> dict = new HashDictionaryWIthQuadraticProbing<>();
        dict.insert("A", 1);
        dict.insert("B", 2);
        dict.insert("C", 3);
        dict.insert("D", 4);
        dict.insert("E", 5);
        assertEquals(5, dict.size());
        dict.remove("A");
        assertFalse(dict.containsKey("A"));
        assertEquals(4, dict.size());



    }

    @Test
    public void testResize(){
        HashDictionaryWIthQuadraticProbing<String, Integer> dict = new HashDictionaryWIthQuadraticProbing<>();
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
        assertEquals(1, (int) dict.get("A"));
        assertEquals(2, (int) dict.get("B"));
        assertEquals(3, (int) dict.get("C"));
        assertEquals(4, (int) dict.get("D"));
        assertEquals(5, (int) dict.get("E"));
        assertEquals(6, (int) dict.get("F"));
        assertEquals(7, (int) dict.get("G"));
        assertEquals(8, (int) dict.get("H"));
        assertEquals(9, (int) dict.get("I"));
        assertEquals(10, (int) dict.get("J"));
        assertEquals(11, (int) dict.get("K"));
        assertEquals(12, (int) dict.get("L"));
      
    }

}