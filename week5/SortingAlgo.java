public class SortingAlgo {
    static void selectionSort(int arr[]) {
      for (int i = 0; i < arr.length - 1; i++) {
        // I want the inner loop tp find me the smallest
        int indexOfSmallest = -1;
        int min = Integer.MAX_VALUE;
        for (int j = i + 1; j < arr.length; j++) {
          if (arr[j] < min) {
            indexOfSmallest = j;
            min = arr[j];
          }
        }
        swap(i, indexOfSmallest, arr);
      }
    }
  
    static void swap(int a, int b, int[] arr) {
      int tmp = arr[a];
      arr[a] = arr[b];
      arr[b] = tmp;
    }
  
    public static void main(String[] args) {
      int[] arr = { 23, 41, 33, 81, 07, 19, 11, 45 };
      selectionSort(arr);
      for (int i = 0; i < arr.length; i++) {
        System.out.print(arr[i] + " ");
      } // 7 11 19 23 33 41 45 81
    }
  
  }