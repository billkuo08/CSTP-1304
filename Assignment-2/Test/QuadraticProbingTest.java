package Test;

import static org.junit.Assert.*;
import org.junit.Test;
import Src.HashDictionaryWIthQuadraticProbing;

public class QuadraticProbingTest {

    @Test
    public void testInsert() {
        HashDictionaryWIthQuadraticProbing dict = new HashDictionaryWIthQuadraticProbing();
        dict.insert(1, 1);
        dict.insert(2, 2);
        dict.insert(3, 3);
        dict.insert(4, 4);
        dict.insert(5, 5);   
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
    }

    @Test
    public void testRemove(){
        HashDictionaryWIthQuadraticProbing dict = new HashDictionaryWIthQuadraticProbing();
        dict.insert(1, 1);
        dict.insert(2, 2);
        dict.insert(3, 3);
        dict.insert(4, 4);
        dict.insert(5, 5);   
        assertEquals(5, dict.size());
        dict.remove(1);
        assertFalse(dict.containsKey(1));
        assertEquals(4, dict.size());
        dict.remove(1);
        assertFalse(dict.containsKey(1));
        assertEquals(4, dict.size());
    }

    

    
}