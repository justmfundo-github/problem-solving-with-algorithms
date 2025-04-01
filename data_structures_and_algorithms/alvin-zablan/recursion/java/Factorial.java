

public class Factorial{
  public static void main(String[] args) {
    int num = 5;
    System.out.println("Calculating Factorial of: " + factorial(num));
  }

  private static int factorial(int num) {
    if(num == 0)return 0;
    if(num == 1)return 1;

    return num * factorial(num - 1);
  }
}