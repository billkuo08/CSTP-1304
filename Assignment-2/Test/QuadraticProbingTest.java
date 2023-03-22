package Test;

import static org.junit.Assert.*;
import org.junit.Test;
import Src.HashDictionaryWIthQuadraticProbing;

public class QuadraticProbingTest {

    @Test
    public void testInsert() {
        HashDictionaryWIthQuadraticProbing dict = new HashDictionaryWIthQuadraticProbing();
        dict.insert(1, 1);
        dict.insert(1, 2);
        dict.insert(1, 3);
        dict.insert(1, 4);
        dict.insert(1, 5);   
        assertEquals(5, dict.size());
       
    }

    @Test
    public void testGet(){
        HashDictionaryWIthQuadraticProbing dict = new HashDictionaryWIthQuadraticProbing();
        dict.insert(1, 1);
        dict.insert(2, 2);
        dict.insert(3, 3);
        dict.insert(4, 4);
        dict.insert(5, 5);   
        assertEquals(5, dict.size());
        assertEquals(1, dict.get(1));
        assertEquals(2, dict.get(2));
        assertEquals(3, dict.get(3));
        assertEquals(4, dict.get(4));
        assertEquals(5, dict.get(5));
        // dict.insert(1, 1);
        // dict.insert(1, 2);
        // dict.insert(1, 3);
        // dict.insert(1, 4);
        // dict.insert(1, 5);   
        // assertEquals(5, dict.size());
        // assertEquals(1, dict.get(1));
        // assertEquals(2, dict.get(1));
        // assertEquals(3, dict.get(1));
        // assertEquals(4, dict.get(1));
        // assertEquals(5, dict.get(1));
    }

    @Test
    public void testRemove(){
        HashDictionaryWIthQuadraticProbing dict = new HashDictionaryWIthQuadraticProbing();
        dict.insert(1, 1);
        dict.insert(1, 2);
        dict.insert(1, 3);
        dict.insert(1, 4);
        dict.insert(1, 5);   
        assertEquals(5, dict.size());
        dict.remove(1);
        assertFalse(dict.containsKey(1));
        assertEquals(4, dict.size());
        dict.remove(1);
        assertFalse(dict.containsKey(1));
        assertEquals(4, dict.size());
    }

   
    @Test
    public void testResize(){
        HashDictionaryWIthQuadraticProbing dict = new HashDictionaryWIthQuadraticProbing();
        dict.insert(1, 1);
        dict.insert(2, 2);
        dict.insert(3, 3);
        dict.insert(4, 4);
        dict.insert(5, 5);   
        dict.insert(6, 6);
        dict.insert(7, 7);
        dict.insert(8, 8);
        dict.insert(9, 9);
        dict.insert(10, 10);
        dict.insert(11, 11);
        dict.insert(12, 12);
        dict.insert(13, 13);
        dict.insert(14, 14);
        dict.insert(15, 15);
        assertEquals(15, dict.size());

       
    }
    

    
}