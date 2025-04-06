import java.util.ArrayList;

public class HowSum{
  public static void main(String[] args) {

    System.out.println(doHowSum(7, new int[]{2,3}));      //true
    System.out.println(doHowSum(7, new int[]{5,3,4,7}));  //true
    System.out.println(doHowSum(7, new int[]{2,4}));      //false
    System.out.println(doHowSum(8, new int[]{2,3,5}));    //true
    //System.out.println(doHowSum(300, new int[]{7,14}));   //false
    
  }

  public static ArrayList<Integer> doHowSum(int targetSum, int[] numbers ){
    if(targetSum == 0) return new ArrayList<Integer>();
    if(targetSum < 0) return null;

    for(int num : numbers){
      int remainder = targetSum - num;
      ArrayList<Integer> remainderResult = doHowSum(remainder, numbers );
      if(remainderResult != null){
        remainderResult.add(num);
        return remainderResult;
      }
    }
    return null;
  }
}