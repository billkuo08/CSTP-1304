package test;

import org.junit.Test;
import static org.junit.Assert.*;
import src.HeapSort;

public class HeapSortTest {
    @Test
    public void testHeapSort() {
        int[] arr = { 98, 86, 41, 13, 65, 32, 29, 9, 10, 44, 23, 21, 17 };
        int[] expected = { 98, 86, 65, 44, 41, 32, 29, 23, 21, 17, 13, 10, 9 };
        HeapSort myHeapTree = new HeapSort();
        myHeapTree.heapSort(arr, 12);
        assertArrayEquals(expected, arr);

    }

    @Test
    public void testInsert() {
        int[] arr = { 98, 86, 41, 13, 65, 32, 29, 9, 10, 44, 23, 21, 17 };
        int[] expected = { 98, 86, 65, 44, 41, 32, 29, 23, 21, 17, 14, 13, 10, 9 };
        HeapSort myHeapTree = new HeapSort();
        myHeapTree.insert(14);
        myHeapTree.heapSort(arr, 13);
        assertArrayEquals(expected, arr);


    }

}
