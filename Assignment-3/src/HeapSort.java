package src;

public class HeapSort {
    public void heapSort(int arr[]) {
        int n = arr.length;

        // Build max heap, sort the array
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // One by one extract an element from heap
        for (int i = n - 1; i >= 0; i--) {
            // Move current root to new end
            swap(arr, i);

            // call max heapify on the newly changed heap
            heapify(arr, i, 0);
        }
    }

    private void swap(int[] arr, int i) {
        int tmp = arr[0];
        arr[0] = arr[i];
        arr[i] = tmp;
    }

    // Traverse through the tree
    private void heapify(int arr[], int size, int i) {

        int largestIndex = i; // Initialize largest as root, starting at mid
        int leftChildIndex = 2 * i + 1; // left = 2*i + 1
        int rightChildIndex = 2 * i + 2; // right = 2*i + 2

        // Check if left child is larger than root
        if (leftChildIndex < size && arr[leftChildIndex] > arr[largestIndex])
            largestIndex = leftChildIndex;

        // Check if right child is larger than largest so far
        if (rightChildIndex < size && arr[rightChildIndex] > arr[largestIndex])
            largestIndex = rightChildIndex;

        // If largest is not root, AKA found a larger element than the current root
        if (largestIndex != i) {
            int tmp = arr[i];
            arr[i] = arr[largestIndex];
            arr[largestIndex] = tmp;

            // Recursively heapify the affected sub-tree
            heapify(arr, size, largestIndex);
        }
    }

    public void insert(int arr[], int newElement, int lastIndex) {
        int n = lastIndex + 1;
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);
        
       
        arr[n] = newElement;
        lastIndex++;

        int i = n - 1;
        while (i > 0 && arr[parent(i)] < arr[i]) {
            insertSwap(arr, i, parent(i));
            i = parent(i);
        }

        // Heapify the entire array again
        for (int j = n - 1; j > 0; j--) {
            insertSwap(arr, 0, j);
            heapify(arr, j, 0);
        }

    }

    private static int parent(int i) {
        return (i - 1) / 2;
    }

    private static void insertSwap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    

    private static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
    }

    // Driver program
    public static void main(String args[]) {
        int arr[] = { 12, 11, 13, 5, 6, 7 };

        HeapSort myHeapTree = new HeapSort();
        myHeapTree.heapSort(arr);

        System.out.println("Sorted array is");
        printArray(arr);
    }

}