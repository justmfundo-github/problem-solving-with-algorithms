public class Fibonacci{
  public static void main(String[] args) {
    System.out.println(calcFibonacci(1));
    System.out.println(calcFibonacci(2));
    System.out.println(calcFibonacci(3));
    System.out.println(calcFibonacci(4));
    System.out.println(calcFibonacci(5));
    System.out.println(calcFibonacci(6));
    System.out.println(calcFibonacci(7));

    //Although this solution to the fibonacci problem works. The moment you put in a large value for n, 
    //there is a significant delay before getting the result. The solution is not efficient.
    //System.out.println(calcFibonacci(50));    
  }

  public static long calcFibonacci(int n){
    if(n <= 2){return 1;}

    return calcFibonacci(n-1) + calcFibonacci(n-2);
  }
}