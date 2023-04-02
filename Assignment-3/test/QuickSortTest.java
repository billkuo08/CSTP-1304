package test;

import org.junit.Test;
import static org.junit.Assert.*;
import src.QuickSort;

public class QuickSortTest {
    
    @Test
    public void testQuickSort1(){
        int[] arr = { 10, 4, 8, 9, 1, 3, 5 };
        int n = arr.length;
        QuickSort.quickSort(arr, 0, n - 1);
        int[] expected =  { 1, 3, 4, 5, 8, 9, 10 };
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testQuickSort2(){
        // even number of length
        int[] arr = { 20, 18, 12, 16, 4, 14, 6, 8 };
        int n = arr.length;
        QuickSort.quickSort(arr, 0, n - 1);
        int[] expected =  { 4, 6, 8, 12, 14, 16, 18, 20};
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testQuickSort3(){
        // negative numbers as element
        int[] arr = { 20, 18, 12, 16, 4, -14, 6, -1 };
        int n = arr.length;
        QuickSort.quickSort(arr, 0, n - 1);
        int[] expected =  {-14, -1 , 4, 6, 12, 16, 18, 20};
        assertArrayEquals(expected, arr);
    }
}
