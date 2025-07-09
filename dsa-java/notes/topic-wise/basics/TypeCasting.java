import java.util.Scanner;

public class TypeCasting {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    // TypeCasting (compressing a bigger numebr in smaller type explicitly)
    int num = (int) (67.56f); // This will conver float into integer
    // System.out.println(num);

    // automatic type promotion in expressions
    // int a = 257;
    // byte b = (byte) (a);
    // since a byter can only handle 256 it will give the reaminder of the number that
    // we have given so 257 % 256 = 1 will be the output

    byte a = 40;
    byte b = 50;
    byte c = 100;
    int d = a * b / c;

    int number = 'A'; //  this will return the ascii vvalue of A which is 65.

    System.out.println(d);
    System.out.println(number);
  }
}
