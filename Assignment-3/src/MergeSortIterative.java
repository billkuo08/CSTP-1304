package src;

public class MergeSortIterative {

    public void mergeSort(int[] arr, int size) {

        int currentSize;

        // Start point of left subArray
        int startIndexLeft;

        for (currentSize = 1; currentSize <= size - 1; currentSize = 2 * currentSize) {
            for (startIndexLeft = 0; startIndexLeft < size - 1; startIndexLeft += 2 * currentSize) {
                // Mid = End point of left subArray
                // Mid + 1 = Start point of right subArray
                // endIndexRight = end point of right subArray
                int mid = Math.min(startIndexLeft + currentSize - 1, size - 1);
                int endIndexRight = Math.min(startIndexLeft + 2 * currentSize - 1, size - 1);
                // Merge subArrays: arr[startIndexLeft...mid] AND arr[mid+1...endIndexRight]
                merging(arr, startIndexLeft, mid, endIndexRight);
            }
        }

    }

    private void merging(int[] arr, int left, int mid, int right) {
        int i, j, k;
        int size1 = mid - left + 1;
        int size2 = right - mid;

        int leftTmpArr[] = new int[size1];
        int rightTmpArr[] = new int[size2];

        // Copy data to tmp arrays
        for (i = 0; i < size1; i++)
            leftTmpArr[i] = arr[left + i];
        for (j = 0; j < size2; j++)
            rightTmpArr[j] = arr[mid + 1 + j];

        // Merge both tmp arrays back to the original array
        //arr[left...right]
        i = 0;
        j = 0;
        k = left;
        while (i < size1 && j < size2) {
            //If data in leftTmpArr is smaller or equal to data rightTmpArr then put it into the arr
            if (leftTmpArr[i] <= rightTmpArr[j]) {
                arr[k] = leftTmpArr[i];
                //Only increase iterator of leftTmpArr
                i++;
            //If data in leftTmpArr is larger than data in rightTmpArr then put the rightTmpArr data into the arr   
            } else {
                arr[k] = rightTmpArr[j];
                //Only increase iterator of rightTmpArr
                j++;
            }
            //Move the iterator of the original array
            k++;
        }

        // Copy the remaining data from both leftTmpArr and rightTmpArr if there are any
        while (i < size1) {
            arr[k] = leftTmpArr[i];
            i++;
            k++;
        }
        
        while (j < size2) {
            arr[k] = rightTmpArr[j];
            j++;
            k++;
        }
    }

    public static void printArr(int arr[], int size) {
        int i;
        for (i = 0; i < size; i++)
            System.out.printf("%d ", arr[i]);
        System.out.printf("\n");
    }

    public static void main(String[] args)
    {
        int arr[] = {12, 11, 13, 5, 6, 7};
        int n = arr.length;
     
        System.out.printf("Given array is \n");
        printArr(arr, n);
        
        MergeSortIterative myArr = new MergeSortIterative();
        myArr.mergeSort(arr, n);
     
        System.out.printf("\nSorted array is \n");
        printArr(arr, n);
    }
}
