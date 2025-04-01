import java.util.ArrayList;
import java.util.HashMap;

public class HowSumMemoisation {
  public static void main(String[] args) {
    HashMap<Integer, ArrayList<Integer>> howSumMemo = new HashMap<Integer, ArrayList<Integer>>();

    System.out.println(doHowSum(7, new int[]{2,3}, howSumMemo));      //true
    howSumMemo.clear();
    System.out.println(doHowSum(7, new int[]{5,3,4,7}, howSumMemo));  //true
    howSumMemo.clear();
    System.out.println(doHowSum(7, new int[]{2,4}, howSumMemo));      //false
    howSumMemo.clear();
    System.out.println(doHowSum(8, new int[]{2,3,5}, howSumMemo));    //true
    howSumMemo.clear();
    //System.out.println(doHowSum(300, new int[]{7,14}, howSumMemo));   //false
    howSumMemo.clear();
  }

  public static ArrayList<Integer> doHowSum(int targetSum, int[] numbers, HashMap<Integer, ArrayList<Integer>> howSumMemo ){
    if(howSumMemo.containsKey(targetSum)) return howSumMemo.get(targetSum);
    if(targetSum == 0) return new ArrayList<Integer>();
    if(targetSum < 0) return null;

    for(int num : numbers){
      int remainder = targetSum - num;
      ArrayList<Integer> remainderResult = doHowSum(remainder, numbers, howSumMemo);
      if(remainderResult != null){
        remainderResult.add(num);
        howSumMemo.put(targetSum, remainderResult);
        return remainderResult;
      }
    }
    howSumMemo.put(targetSum, null);
    return null;
  }
}
