package test;
import org.junit.Test;
import static org.junit.Assert.*;
import src.HeapSort;

public class HeapSortTest {
    @Test
    public void testInsert() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        int [] expected = {13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        HeapSort myHeapTree = new HeapSort();
        myHeapTree.heapSort(arr, 12);
        assertArrayEquals(expected, arr);
      

     
    }

    

    
}
