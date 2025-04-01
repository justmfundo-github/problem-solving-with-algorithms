import java.util.HashMap;

public class CanSumMemoisation {

  public static void main(String[] args) {
    HashMap<Integer, Boolean> canSumMemo = new HashMap<Integer, Boolean>();
    System.out.println(doCanSum(7, new int[]{2,3}, canSumMemo));      //true  
    /*
     * Important to not that every iteration of the doCanSum recursive call has access to the same HashMap
     * So before calling the recursive method with new parameters, it is important to reset/clear the HashMap
     */
    canSumMemo.clear();
    
    System.out.println(doCanSum(7, new int[]{5,3,4,7}, canSumMemo));  //true
    canSumMemo.clear();

    System.out.println(doCanSum(7, new int[]{2,4}, canSumMemo));      //false
    canSumMemo.clear();

    System.out.println(doCanSum(8, new int[]{2,3,5}, canSumMemo));    //true
    canSumMemo.clear();

    System.out.println(doCanSum(300, new int[]{7,14}, canSumMemo));   //false
    canSumMemo.clear();

    System.out.println(doCanSum(7, new int[]{4,2}, canSumMemo)); //false
    canSumMemo.clear();
  } 
  
  public static boolean doCanSum(int targetSum, int[] numbers, HashMap<Integer, Boolean> canSumMemo){
    if(canSumMemo.containsKey(targetSum)){
      return canSumMemo.get(targetSum);
    } 
    if(targetSum == 0) return true;
    if(targetSum < 0) {
      return false;
    } 

    for(int num : numbers){
      int remainder = targetSum - num;
      if(doCanSum(remainder, numbers, canSumMemo) == true){
        canSumMemo.put(targetSum, true);
        return true;
      }
    }

    canSumMemo.put(targetSum, false);
    return false;
  }
}
