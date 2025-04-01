import java.util.ArrayList;

public class BestSum {
  public static void main(String[] args) {
    System.out.println(doBestSum(7, new int[]{5, 3, 4, 7}));      //true
    System.out.println(doBestSum(8, new int[]{2, 3, 5}));  //true
    System.out.println(doBestSum(8, new int[]{1, 4, 5}));      //false
    System.out.println(doBestSum(25, new int[]{1, 2, 5, 25}));    //true
    System.out.println(doBestSum(0, new int[]{7,14}));   //false
  }

  public static ArrayList<Integer> doBestSum(int targetSum, int[] numbers){
    if(targetSum == 0) return new ArrayList<Integer>();
    if(targetSum < 0) return null;

    ArrayList<Integer> shortestCombination = null;

    for( int num : numbers){
      int remainder = targetSum - num;
      ArrayList<Integer> remainderCombination = doBestSum(remainder, numbers);

      if(remainderCombination != null){
        remainderCombination.add(num);

        //ArrayList<Integer> combination = remainderCombination;

        if(shortestCombination == null || remainderCombination.size() < shortestCombination.size()){
          shortestCombination = remainderCombination;
        }

      }
    }
    
    return shortestCombination;
  }
}
