import java.util.Scanner;

public class Temprature {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    System.out.println("Please Temperature in C: ");
    float tempC = input.nextFloat();

    float tempF = (tempC * 9 / 5) + 32;

    System.out.println("Temperature in Farenhiet is: " + tempF);
  }
}
