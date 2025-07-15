public class FuncArguments {

  public static void main(String[] args) {
    int ans = sum(20, 30);
    System.out.println(ans);
  }

  // Pass the values of number when you are calling the method in main()
  static int sum(int a, int b) {
    int sum = a + b;
    // return the value
    return sum;
  }
}
