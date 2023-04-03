package test;

import org.junit.Test;
import static org.junit.Assert.*;
import src.HeapSort;

public class HeapSortTest {

    @Test
    public void testHeapSort() {
        int[] arr = { 12, 11, 13, 5, 6, 7 };
        HeapSort myHeapTree = new HeapSort();
        myHeapTree.heapSort(arr);
        int[] expected = { 5, 6, 7, 11, 12, 13 };
        assertArrayEquals(expected, arr);
    }
 

}