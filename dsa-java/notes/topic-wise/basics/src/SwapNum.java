public class SwapNum {

  public static void main(String[] args) {
    int a = 10;
    int b = 20;

    // swap the numbers
    int temp = a;
    a = b;
    b = temp;

    System.out.println("The value of a is " + a);
    System.out.println("The value of b is " + b);
  }
}
