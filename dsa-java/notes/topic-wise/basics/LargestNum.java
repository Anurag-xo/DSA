import java.util.Scanner;

public class LargestNum {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int a = sc.nextInt();
    int b = sc.nextInt();
    int c = sc.nextInt();

    // Q: Find the largest of the 3 numbers
    int max = a;
    if (b > max) {
      max = b;
    }
    if (c > max) {
      max = c;
    }
    sc.close();
    System.out.println(max);
  }
}

// or we can usethis
/*
 * int max = Math.max(c, Math.max(a, b));
 * System.out.println(max);
 *
 */
