package test;
import org.junit.Test;
import static org.junit.Assert.*;
import src.MergeSortRecursive;
public class MergeSortRecursiveTest {

    @Test
    public void positiveTest() {
        int[] arr = { 5, 1, 6, 2, 3, 4 };
        int[] expected = { 1, 2, 3, 4, 5, 6 };
        int n = arr.length;
        MergeSortRecursive myMergeSort = new MergeSortRecursive();
        myMergeSort.mergeSort(arr, n);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void negativeTest(){
        int[] arr = { 5, 1, 6, 2, 3, -4 };
        int[] expected = { -4, 1, 2, 3, 5, 6 };
        int n = arr.length;
        MergeSortRecursive myMergeSort = new MergeSortRecursive();
        myMergeSort.mergeSort(arr, n);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void oddTest(){
        int[] arr = { 5, 1, 6, 2, 3 };
        int[] expected = { 1, 2, 3, 5, 6 };
        int n = arr.length;
        MergeSortRecursive myMergeSort = new MergeSortRecursive();
        myMergeSort.mergeSort(arr, n);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void zeroTest(){
        int[] arr = { 0, 0, 0, 0, 0 };
        int[] expected = { 0, 0, 0, 0, 0 };
        int n = arr.length;
        MergeSortRecursive myMergeSort = new MergeSortRecursive();
        myMergeSort.mergeSort(arr, n);
        assertArrayEquals(expected, arr);
    }
}
