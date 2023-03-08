class q1 {
  static void countDown_i(int input) {
    while (input >= 1) {
      System.out.println(input);
      input--;
    }
  }

  static void countDown_r(int input) {
    System.out.println(input);
    if (input == 1) {
      return;
    } else {
      countDown_r(input - 1);
    }
  }

  public static void main(String[] args) {
    // countDown_i(10); // 10, 9, 8, ...
    countDown_r(10); // 10, 9, 8, ...
  }
}

class q2 {
  static int sumOf_i(int input) {
    int sum = 0;
    for (int i = 1; i <= input; i++) {
      sum += i;
    }
    return sum;
  }

  static int sumOf_r(int input) {
    if (input == 0)
      return 0;
    else
      return input + sumOf_r(input - 1);
  }

  public static void main(String[] args) {
    System.out.println(sumOf_r(10)); // 55
  }
}

class q3 {

  static void displayArrayFromFirst_i(int[] array, int firstIndex, int lastIndex) {
    for (int i = 0; i <= lastIndex; i++) {
      System.out.println(array[i]);
    }
  }

  static void displayArrayFromFirst_r(int[] array, int firstIndex, int lastIndex) {
    // stopping condition
    System.out.println(array[firstIndex]);
    // basic and the recursive steps
    if (firstIndex != lastIndex) {
      System.out.println(array[firstIndex]);
      displayArrayFromFirst_r(array, firstIndex + 1, lastIndex);
    }
  }

  public static void main(String[] args) {
    int[] array = { 1, 2, 3, 4, 5 };
    // displayArrayFromFirst_i(array, 0, 4);
    displayArrayFromFirst_r(array, 0, 4);

  }

}

class q4 {
  static void displayArrayFromLast_i(int[] array, int firstIndex, int lastIndex) {
    for (int i = lastIndex; i >= firstIndex; i--) {
      System.out.println(array[i]);
    }
  }

  static void displayArrayFromLast_r(int[] array, int firstIndex, int lastIndex) {
    System.out.println(array[lastIndex]);
    if (firstIndex <= lastIndex)
      displayArrayFromLast_r(array, firstIndex, lastIndex - 1);
  }

  public static void main(String[] args) {
    int[] array = { 1, 2, 3, 4, 5 };
    // displayArrayFromFirst_i(array, 0, 4);
    displayArrayFromLast_i(array, 0, 4); // 5, 4, 3, 2, 1

  }
}