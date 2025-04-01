public class Fibonacci {
  public static void main(String[] args) {
    System.out.println(fibonacci(4));
  }

  private static int fibonacci(int n) {
    if(n == 0) return 0;
    if(n == 1) return 1;

    int left = fibonacci(n-1);
    int right = fibonacci(n-2);

    return left + right;
  }
}
