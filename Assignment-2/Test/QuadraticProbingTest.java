package Test;

import static org.junit.Assert.*;
import org.junit.Test;
import Src.HashDictionaryWIthQuadraticProbing;

public class QuadraticProbingTest {

    @Test
    public void testPut() {
        HashDictionaryWIthQuadraticProbing<String, Integer> dict = new HashDictionaryWIthQuadraticProbing<>();
        dict.put("A", 1);
        dict.put("B", 2);
        dict.put("C", 3);
        dict.put("D", 4);
        dict.put("E", 5);
        dict.put("F", 6);
        dict.put("G", 7);
        dict.put("H", 8);
        dict.put("I", 9);
        dict.put("J", 10);
        dict.put("K", 11);
        dict.put("L", 12);
        dict.put("M", 13);
        dict.put("N", 14);
        dict.put("O", 15);
        dict.put("P", 16);
        dict.put("Q", 17);
        dict.put("R", 18);
        dict.put("S", 19);
        dict.put("T", 20);
        dict.put("U", 21);
        dict.put("V", 22);
        dict.put("W", 23);
        dict.put("X", 24);
        dict.put("Y", 25);
        dict.put("Z", 26);
        assertEquals(26, dict.size());
    }

    @Test
    public void testGet() {
        HashDictionaryWIthQuadraticProbing<String, Integer> dict = new HashDictionaryWIthQuadraticProbing<>();
        dict.put("A", 1);
        dict.put("B", 2);
        dict.put("C", 3);
        dict.put("D", 4);
        dict.put("E", 5);
        dict.put("F", 6);
        dict.put("G", 7);
        dict.put("H", 8);
        dict.put("I", 9);
        dict.put("J", 10);
        dict.put("K", 11);
        dict.put("L", 12);
        dict.put("M", 13);
        dict.put("N", 14);
        dict.put("O", 15);
        dict.put("P", 16);
        dict.put("Q", 17);
        dict.put("R", 18);
        dict.put("S", 19);
        dict.put("T", 20);
        dict.put("U", 21);
        dict.put("V", 22);
        dict.put("W", 23);
        dict.put("X", 24);
        dict.put("Y", 25);
        dict.put("Z", 26);
        assertEquals(26, dict.size());
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
        assertEquals(13, (int) dict.get("M"));
        assertEquals(14, (int) dict.get("N"));
        assertEquals(15, (int) dict.get("O"));
        assertEquals(16, (int) dict.get("P"));
        assertEquals(17, (int) dict.get("Q"));
        assertEquals(18, (int) dict.get("R"));
    }

    @Test
    public void testRemove() {
        HashDictionaryWIthQuadraticProbing<String, Integer> dict = new HashDictionaryWIthQuadraticProbing<>();
        dict.put("A", 1);
        dict.put("B", 2);
        dict.put("C", 3);
        dict.put("D", 4);
        dict.put("E", 5);
        dict.put("F", 6);
        dict.put("G", 7);
        dict.put("H", 8);
        dict.put("I", 9);
        dict.put("J", 10);
        dict.put("K", 11);
        dict.put("L", 12);
        dict.put("M", 13);
        dict.put("N", 14);
        dict.put("O", 15);
        dict.put("P", 16);
        dict.put("Q", 17);
        dict.put("R", 18);
        dict.put("S", 19);
        dict.put("T", 20);
        dict.put("U", 21);
        dict.put("V", 22);
        dict.put("W", 23);
        dict.put("X", 24);
        dict.put("Y", 25);
        dict.put("Z", 26);
        assertEquals(26, dict.size());
        dict.remove("A");
        assertFalse(dict.containsKey("A"));


    }

}