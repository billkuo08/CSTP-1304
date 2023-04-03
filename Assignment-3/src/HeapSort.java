package src;

public class HeapSort {
    public void heapSort(int arr[]) {
        int n = arr.length;

        // Build max heap, rearrange array
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // One by one extract an element from heap
        for (int i = n - 1; i >= 0; i--) {
            // Move current root to end
            swap(arr, i);

            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    private void swap(int[] arr, int i) {
        int tmp = arr[0];
        arr[0] = arr[i];
        arr[i] = tmp;
    }
    
    //Traversal of the tree
    private void heapify(int arr[], int n, int i) {

        int largestIndex = i; // Initialize largest as root
        int leftChildIndex = 2 * i + 1; // left = 2*i + 1
        int rightChildIndex = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (leftChildIndex < n && arr[leftChildIndex] > arr[largestIndex])
            largestIndex = leftChildIndex;

        // If right child is larger than largest so far
        if (rightChildIndex < n && arr[rightChildIndex] > arr[largestIndex])
            largestIndex = rightChildIndex;

        // If largest is not root
        if (largestIndex != i) {
            int tmp = arr[i];
            arr[i] = arr[largestIndex];
            arr[largestIndex] = tmp;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largestIndex);
        }
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