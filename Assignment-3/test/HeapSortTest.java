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

    @Test
    public void testNegativeAndZero() {
        int[] arr = { 12, 11, 0, 5, 6, 7, -1 };
        HeapSort myHeapTree = new HeapSort();
        myHeapTree.heapSort(arr);
        int[] expected = { -1, 0, 5, 6, 7, 11, 12 };
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testDuplicateNumber() {
        int[] arr = { 20, 18, 18, 12, 16, 4, 14, 6, 8 };
        HeapSort myHeapTree = new HeapSort();
        myHeapTree.heapSort(arr);
        int[] expected = { 4, 6, 8, 12, 14, 16, 18, 18, 20 };
        assertArrayEquals(expected, arr);
    }

}