import java.util.Arrays;

public class SumArray {
  public static void main(String[] args) {
    int[] intArray = new int[]{1,5,7,-2};
    System.out.println(sumArray(intArray));
  }

  private static int sumArray(int[] intArray) {
    if(intArray.length == 0)return 0;

    int[] restOfArray = Arrays.copyOfRange(intArray, 1, intArray.length);
    //printArray(restOfArray);
    return intArray[0] + sumArray(restOfArray);
  }

  private static void printArray(int[] array){
    for(int n : array)System.out.print(n + " ");

    System.out.println();
  }
}
