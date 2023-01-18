public class ListUsingArray {
    Integer[] arr;
    int numOfElements;
    int ARR_SIZE = 11;
    int MAX_CAPACITY = ARR_SIZE - 1;

    ListUsingArray() {
        arr = new Integer[ARR_SIZE];
        numOfElements = 0;
    }

    void add(int element) {

        if (numOfElements != MAX_CAPACITY) {

            numOfElements = numOfElements + 1;
            // arr[++numOfElements] = element;
            arr[numOfElements] = element;
        }
    }

    // Position is >= 1
    void add(int position, int element) {

        if (numOfElements != MAX_CAPACITY) {
            // shift to the right
            for (int i = numOfElements; i > position; i--) {
                arr[i + 1] = arr[i];
            }

            arr[position] = element;
            numOfElements++;
        }
    }

    void remove(int position) {
        // Shifting to the left
        if (numOfElements >= 1 && position <= numOfElements && position >= 1) {

            for (int i = position; i < numOfElements; i++) {
                arr[i] = arr[i + 1];
            }

            numOfElements--;
        }
    }

    int get(int position) {

        return arr[position];

    }

    int size() {
        return numOfElements;
    }

    public static void main(String[] args) {
        ListUsingArray x = new ListUsingArray();
        // Position starts from 1
        x.add(10);
        x.add(20);
        x.add(30);
        System.out.println(x.get(3));// 30
        x.add(1, 5);
        System.out.println(x.get(3));// 20
        x.remove(3);
        System.out.println(x.size());//3
    }
}