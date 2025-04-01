import java.util.ArrayList;
import java.util.HashMap;

public class BestSumMemoisation {

  private static HashMap<Integer, ArrayList<Integer>> addendsMemo = new HashMap<Integer, ArrayList<Integer>>();
  public static void main(String[] args) {
    
    System.out.println(doBestSum(7, new int[]{5, 3, 4, 7}));      //true
    addendsMemo.clear();

    System.out.println(doBestSum(8, new int[]{2, 3, 5}));  //true
    addendsMemo.clear();

    System.out.println(doBestSum(8, new int[]{1, 4, 5}));      //false
    addendsMemo.clear();

    System.out.println(doBestSum(250, new int[]{1, 2, 5, 25}));    //true
    addendsMemo.clear();

    System.out.println(doBestSum(0, new int[]{7,14}));   //false
    addendsMemo.clear();
  }

  public static ArrayList<Integer> doBestSum(int targetSum, int[] numbers){
    if(addendsMemo.containsKey(targetSum)) return addendsMemo.get(targetSum);
    if(targetSum == 0) return new ArrayList<Integer>();
    if(targetSum < 0) return null;

    ArrayList<Integer> shortestCombination = null;

    for( int num : numbers){
      int remainder = targetSum - num;
      ArrayList<Integer> remainderCombination = doBestSum(remainder, numbers);

      if(remainderCombination != null){
        
        ArrayList<Integer> combination = new ArrayList<>(remainderCombination);
        // combination = (ArrayList)remainderCombination.clone();

        combination.add(num);
        // if the combination is shorter than the current "shortest" then update it
        if(shortestCombination == null || combination.size() < shortestCombination.size()){
          shortestCombination = combination;
        }

      }
    }
    
    addendsMemo.put(targetSum, shortestCombination);
    return shortestCombination;
  }
}
