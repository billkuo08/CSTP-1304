package src;

public class HeapSort {
    Integer[] arr;
    int lastIndex;

    public HeapSort() {
        arr = new Integer[100];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        arr[3] = 4;
        arr[4] = 5;
        arr[5] = 6;
        arr[6] = 7;
        arr[7] = 8;
        arr[8] = 9;
        arr[9] = 10;
        arr[10] = 11;
        arr[11] = 12;
        arr[12] = 13;
        lastIndex = 12;
    }

    void insert(int newElement) {
        ++lastIndex;
        arr[lastIndex] = newElement;
        bubbleUp(lastIndex);
    }

    // bubble up the element at the provided index
    void bubbleUp(int elementIndex) {
        int theElementToBeBubbledUp = arr[elementIndex];
        int indexOfTheElementToBeBubbledUp = elementIndex;
        // check whether we need to do swap
        // parent of 81
        int parentIndex = (elementIndex - 1) / 2;
        int parentElement = arr[parentIndex];
        while (parentElement < theElementToBeBubbledUp) {
            swap(parentIndex, indexOfTheElementToBeBubbledUp);
            indexOfTheElementToBeBubbledUp = parentIndex;
            parentIndex = (parentIndex - 1) / 2;
            if (parentElement < 0) {
                break;
            }
            parentElement = arr[parentIndex];
        }

    }

    // remove the root from the heap
    int remove() {
        int result = arr[0];
        arr[0] = arr[lastIndex];
        lastIndex--;
        if(lastIndex != 0)
            bubbleDown(0);
        return result;

    }

    void swap(int aIndex, int b) {
        int tmp = arr[aIndex];
        arr[aIndex] = arr[b];
        arr[b] = tmp;
    }

    // bubble down the element at the provided index
    void bubbleDown(int index) {
        int i = index;

        int leftChildIndex = 2 * i + 1;
        int rightChildIndex = 2 * i + 2;
        int x = arr[i];
        int leftChildElement = arr[2 * i + 1];
        int rightChildElement = arr[2 * i + 2];


        while (leftChildElement >= x ||
                rightChildElement >= x) {
            int maxIndex;
            if (leftChildElement > rightChildElement) {
                maxIndex = leftChildIndex;
            } else {
                maxIndex = rightChildIndex;
            }
            swap(maxIndex, i);

            // update i
            i = maxIndex;

            leftChildIndex = 2 * i + 1;
            rightChildIndex = 2 * i + 2;
            if (leftChildIndex > lastIndex || rightChildIndex > lastIndex)
                break;
            leftChildElement = arr[2 * i + 1];
            rightChildElement = arr[2 * i + 2];
        }

    }

    public void heapSort(int[]arr, int lastIndex) {
        // Heapify the array
        for (int i = (lastIndex / 2) - 1; i >= 0; i--) {
            bubbleDown(i);
        }

        // remove the root and add it to the end of the array
        // remove the prcess until the heap is empty
        int size = lastIndex + 1;
        for (int i = 0; i < size; i++) {
            arr[i] = remove();
        }
    }

    public static void main(String[] args) {
        HeapSort aHeapTree = new HeapSort(); 
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};        
        aHeapTree.heapSort(arr, 12);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        

    }


}
