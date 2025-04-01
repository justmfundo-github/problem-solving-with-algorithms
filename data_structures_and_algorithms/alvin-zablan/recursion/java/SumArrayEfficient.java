//in this case we are going to perform the sumArray again but without making a copy of the array that leads to a performance hit

public class SumArrayEfficient {
  public static void main(String[] args) {
    int[] intArray = new int[]{1,5,7,-2};
    System.out.println(sumArrayEfficient(intArray, 0));
  }

  public static int sumArrayEfficient(int[] array, int index){
    if(index == array.length)return 0;

    return array[index] + sumArrayEfficient(array, index+1);
  }
}
