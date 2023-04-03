package src;

public class MergeSortRecursive {

    // Break down the array into smaller arrays
    public void mergeSort(int[] arr, int n) {
        if (n < 2) {
            return;
        }
        // size of left side
        int mid = n / 2;
        // size of right side
        int rightOfMid = n - mid;
        int[] leftTmpArr = new int[mid];
        int[] rightTmpArr = new int[rightOfMid];
        // copy the left side of the array
        for (int i = 0; i < mid; i++) {
            leftTmpArr[i] = arr[i];
        }
        // copy the right side of the array
        for (int i = mid; i < n; i++) {
            rightTmpArr[i - mid] = arr[i];
        }
        // recursive call
        mergeSort(leftTmpArr, mid);
        mergeSort(rightTmpArr, n - mid);

        // merge all arrays
        merging(arr, leftTmpArr, rightTmpArr, mid, rightOfMid);
    }

    public void merging(int[] arr, int[] leftTmpArr, int[] rightTmpArr, int left, int right) {
        /*
         * arr is the original/final array
         * left is the size of leftTmpArr
         * right is the size of rightTmpArr
         * i for left[]
         * j for right[]
         * k for arr[]
         */
        int i = 0, j = 0, k = 0;
        // merge the two arrays
        while (i < left && j < right) {
            // if the leftTmpArr[i] is smaller than rightTmpArr[j]
            if (leftTmpArr[i] <= rightTmpArr[j]) {
                // put the leftTmpArr[i] into the arr[k]
                arr[k++] = leftTmpArr[i++];
                // if the leftTmpArr[i] is bigger than rightTmpArr[j]
            } else {
                // put the rightTmpArr[j] into the arr[k]
                arr[k++] = rightTmpArr[j++];
            }
        }
        // if there are still elements in leftTmpArr
        while (i < left) {
            arr[k++] = leftTmpArr[i++];
        }
        // if there are still elements in rightTmpArr
        while (j < right) {
            arr[k++] = rightTmpArr[j++];
        }
    }

    public static void main(String[] args) {
        int[] arr = { 5, 1, 6, 2, 3, 4 };;
        int n = arr.length;
        MergeSortRecursive myArr = new MergeSortRecursive();
        myArr.mergeSort(arr, n);
        for(int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        
    }

}
