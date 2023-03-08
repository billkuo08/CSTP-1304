public class q4 {
    static void displayArrayFromLast_i(int[] array, int firstIndex, int lastIndex) {
        for (int i = lastIndex; i >= firstIndex; i--) {
            System.out.println(array[i]);
        }
    }

    static void displayArrayFromLast_r(int[] array, int firstIndex, int lastIndex) {
        if (firstIndex <= lastIndex) {
            System.out.println(array[lastIndex]);
            displayArrayFromLast_r(array, firstIndex, lastIndex - 1);
        }
    }

    static void displayArrayFromLast_r2(int[] array, int firstIndex, int lastIndex) {
        if (firstIndex <= lastIndex) {
            displayArrayFromLast_r(array, firstIndex + 1, lastIndex);
            System.out.println(array[firstIndex]);
        }
    }

    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 4, 5 };
        // displayArrayFromFirst_i(array, 0, 4);
        displayArrayFromLast_r2(array, 0, 4); // 5, 4, 3, 2, 1

    }
}
