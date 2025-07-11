import java.util.Scanner;

public class ReverseNum {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter a number to print reverse: ");
    int num = sc.nextInt();

    int ans = 0;

    while (num > 0) {
      int rem = num % 10;
      num /= 10;

      ans = ans * 10 + rem;
    }
    sc.close();
    System.out.println(ans);
  }
}
