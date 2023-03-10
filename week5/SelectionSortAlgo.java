public class SelectionSortAlgo {

    static void insertionSort(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            // try insert the arr[i] to its proper place
            // in the green partition of the array
            int tmp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] > tmp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 23, 41, 33, 81, 07, 19, 11, 45 };
        // selectionSort(arr);
        insertionSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        } // 7 11 19 23 33 41 45 81
    }

}
