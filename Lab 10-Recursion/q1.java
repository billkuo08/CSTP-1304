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

