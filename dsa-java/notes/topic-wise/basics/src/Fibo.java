import java.util.Scanner;

public class Fibo {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter a number to find it Fibonacci: ");

    int n = sc.nextInt();
    int p = 0; // previous
    int i = 1; // current index
    int count = 2;

    while (count <= n) {

      int temp = i;
      i = i + p;
      p = temp;
      count++;
    }

    sc.close();
    System.out.println(i);
  }
}
