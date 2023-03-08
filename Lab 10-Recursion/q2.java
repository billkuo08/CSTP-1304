public class q2 {
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
