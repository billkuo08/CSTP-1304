class Heap {
    Integer[] arr;
    int lastIndex;

    Heap() {
        arr = new Integer[100];
        arr[0] = 98;
        arr[1] = 86;
        arr[2] = 41;
        arr[3] = 13;
        arr[4] = 65;
        arr[5] = 32;
        arr[6] = 29;
        arr[7] = 9;
        arr[8] = 10;
        arr[9] = 44;
        arr[10] = 23;
        arr[11] = 21;
        arr[12] = 17;
        lastIndex = 12;

    }

    void insert(int newElement) {
        lastIndex++;
        arr[lastIndex] = newElement;
        bubbleUp(lastIndex);

    }

    // bubble down the element at the provdied index
    void bubbleDown(int index) {
        int i = index;
        int leftChildIndex = 2 * i + 1;
        int rightChildIndex = 2 * i + 2;
        int leftChildElement = arr[2 * i + 1];
        int rightChildElement = arr[2 * i + 2];
        int maxIndex = i;
        while (maxIndex < lastIndex) {
            // while (leftChildElement > arr[i] || rightChildElement > arr[i]) {
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

    // bubble up the element at the provided index
    void bubbleUp(int elementIndex) {
        int elementToBubbleUp = arr[elementIndex];
        int indexOfElementToBubbleUp = elementIndex;
        // check whether we need to swap
        // parent of 81
        int parentIndex = (elementIndex - 1) / 2;
        int parentElement = arr[parentIndex];

        while (parentElement < elementToBubbleUp) {
            swap(parentElement, indexOfElementToBubbleUp);
            indexOfElementToBubbleUp = parentIndex;
            parentIndex = (parentIndex - 1) / 2;

            if (parentIndex < 0)
                break;
        }
        parentIndex = arr[parentIndex];
    }

    // remove the root from the heap
    void remove() {
        arr[0] = arr[lastIndex];
        lastIndex--;
        bubbleDown(0);

    }

    void swap(int aIndex, int bIndex) {
        int tmp = arr[aIndex];
        arr[aIndex] = arr[bIndex];
        arr[bIndex] = tmp;

    }

    public static void main(String[] args) {
        //test case icls insertion
        Heap aHeapTree = new Heap();
        // aHeapTree.insert(81); // { 98, 86, 81, 13, 65, 32, 41, 9, 10, 44, 23, 21, 17,
        // 29 }; // Expected Heap
        // // assert the new size - 14

        // test case 2 removal
        aHeapTree.remove();// { 86, 65, 41, 13, 44, 32, 29, 9, 10, 17, 23, 21}; // Expected Heap

    }
}