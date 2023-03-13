class LinearSearchAlgo {

    static int linearSearch(int arr[], int target) {
      for (int i = 0; i < arr.length; i++) {
        if (arr[i] == target) {
          return i;
        }
      }
      return -1;
    }
  
    // -1 means the target is not in the array
    static int binarySearch(int arr[], int target, int leftIndex, int rightIndex) {
      if (leftIndex >= rightIndex)
        return -1;
  
      int middleIndex = (leftIndex + rightIndex) / 2; // integer division
      if (arr[middleIndex] == target) {
        return middleIndex;
      } else {
        if (target > arr[middleIndex])
          return binarySearch(arr, target, middleIndex + 1, rightIndex);
        else
          return binarySearch(arr, target, leftIndex, middleIndex - 1);
      }
    }
  
    public static void main(String[] args) {
      int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
      //System.out.println(linearSearch(arr, 5));// 4
      int result = binarySearch(arr, 23483, 0, arr.length - 1);
      System.out.println(result);// -1
      // if (result != -1)
      //   System.out.println(result);// 4
    }
  
  }