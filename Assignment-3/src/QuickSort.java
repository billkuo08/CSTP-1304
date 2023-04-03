package src;

public class QuickSort {

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;

    }

    /*
     * Takes the last element as pivot, places the pivot element at its correct
     * position in sorted array,
     * and places all smaller (smaller than pivot) to left of pivot and all greater
     * elements to right of pivot
     */
    private int partition(int[] arr, int low, int high) {
        // choose the last element as the pivot
        int pivot = arr[high];
        // i is the index of the smaller element
        int i = low - 1;
        for (int j = low; j <= high - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    /*
     * The main function that implements QuickSort
     * arr[] --> Array to be sorted,
     * low --> Starting index,
     * high --> Ending index
     */
    public void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // arr[partitionIndex] is now at right place
            int partitionIndex = partition(arr, low, high);
            quickSort(arr, low, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, high);
        }
    }

    private static void printArr(int[] arr, int size) {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 10, 4, 8, 9, 1, 3, 5 };
        int n = arr.length;
        QuickSort myArr = new QuickSort();
        myArr.quickSort(arr, 0, n - 1);
        System.out.println("Sorted array: ");
        printArr(arr, n);
    }
}
