package test;

import org.junit.Test;
import static org.junit.Assert.*;
import src.MergeSortRecursive;

public class MergeSortRecursiveTest {

    @Test
    public void evenSizeTest() {
        int[] arr = { 5, 1, 6, 2, 3, 4 };
        int[] expected = { 1, 2, 3, 4, 5, 6 };
        int n = arr.length;
        MergeSortRecursive myMergeSort = new MergeSortRecursive();
        myMergeSort.mergeSort(arr, n);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void oddSizeAndZeroTest() {
        int[] arr = { 12, 11, 13, 5, 0 };
        int[] expected = { 0, 5, 11, 12, 13 };
        int n = arr.length;
        MergeSortRecursive myMergeSort = new MergeSortRecursive();
        myMergeSort.mergeSort(arr, n);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void negativeTest() {
        int[] arr = { 5, 1, 6, 2, 3, -4 };
        int[] expected = { -4, 1, 2, 3, 5, 6 };
        int n = arr.length;
        MergeSortRecursive myMergeSort = new MergeSortRecursive();
        myMergeSort.mergeSort(arr, n);
        assertArrayEquals(expected, arr);
    }

  

    @Test
    public void duplicateTest() {
        int[] arr = { 12, 11, 13, 5, 11 };
        int[] expected = { 5, 11, 11, 12, 13 };
        int n = arr.length;
        MergeSortRecursive myMergeSort = new MergeSortRecursive();
        myMergeSort.mergeSort(arr, n);
        assertArrayEquals(expected, arr);
    }
}
