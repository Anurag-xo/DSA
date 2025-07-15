import java.util.Scanner;

public class ArmStrong {

  public static void main(String[] agrgs) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    boolean ans = isArmStrong(n);
    System.out.println(ans);

    // print all 3 digit ArmStrong numbers between 1000 and 1000.
    //   for (int i = 100; i < 1000; i++) {
    //     if (isArmStrong(i)) {
    //       System.out.println(i + " ");
    //     }
    //   }
  }

  // print all 3 digit ArmStrong numbers( it is basically, cube of addition will be the same nunmber
  // probiced in input)
  static boolean isArmStrong(int n) {
    int original = n;
    int sum = 0;

    while (n > 0) {

      int rem = n % 10;
      n = n / 10;
      sum = sum + rem * rem * rem;
    }

    // if (sum == original) {
    //   return true;
    // }
    // return false;
    return sum == original; // same thing
  }
}
