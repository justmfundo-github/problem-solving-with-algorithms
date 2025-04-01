import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Given two strings, write a method to decide if one is a permutation of the other. I.e same number of letters but different order*/

public class IsPermutation {
  public static void main(String[] args) {
    // Create some string pairs and compare them using two methods with different algorithms
    List<StringPair> pairsList = new ArrayList<StringPair>();
    pairsList.add(new StringPair("dog","god"));
    pairsList.add(new StringPair("abcd","acbd"));
    pairsList.add(new StringPair("moat","goat"));
    pairsList.add(new StringPair("miriam","mairims"));
    pairsList.add(new StringPair("@#$%&", "&$%#@"));

    for(StringPair sp : pairsList){
      System.out.println(sp.leftString + ": is a permutation of : " + sp.rightString + " : " + isPermutationSortAndCompare(sp.leftString, sp.rightString));
      //System.out.println(sp.leftString + ": is a permutation of : " + sp.rightString + " : " + isPermutationCompareCharCountInArray(sp.leftString, sp.rightString));
    }
  }

  public static class StringPair {
    String leftString;
    String rightString;

    public StringPair(String leftString, String rightString) {
      this.leftString = leftString;
      this.rightString = rightString;
    }
 
    
    //NOTE: override hashcode and equals methods
 }

  public static boolean isPermutationSortAndCompare(String input1, String input2){
    //before anything else, we can check the length of the Strings. If they aren't equal we can return false and exit
    if(input1.length() != input2.length()){
      return false;
    } 
    //place both strings in a character array
    char[] input1CharArr = input1.toCharArray();
    char[] input2CharArr = input2.toCharArray();
    //uses Arrays.sort() to sort said arrays
    Arrays.sort(input1CharArr);
    Arrays.sort(input2CharArr);
    //parse char arrays back to string 
    input1 = new String(input1CharArr);
    input2 = new String(input2CharArr);

    //finally, compare the strings
    if(input1.equalsIgnoreCase(input2)){
      return true;
    }else{
      return false;
    }
  }

  // 
  public static boolean isPermutationCompareCharCountInArray(String input1, String input2){
    //first things first, check if the strings are the same length otherwise return false
    if(input1.length() != input2.length()){
      return false;
    } 

    //we're going to create two array of ASCII characters. I.e use their int values to represent indexes on an array of 128 size
    char[] input1CharArr = new char[128];
    char[] input2CharArr = new char[128];

    //now count the number of occurrances of each characters from both strings and store the count in their arrays respectively
    for(char c : input1.toCharArray()){
      int charVal = c;
      input1CharArr[charVal] += 1;
    }

    for(char c : input2.toCharArray()){
      int charVal = c;
      input2CharArr[charVal] += 1;
    }

    //now time to compare the two arrays by making sure that each character is represented the same number of times
    for(int i=0; i<input1CharArr.length; i++){//doesn't matter which array is used for max length because they are the same
      if(input1CharArr[i] != input2CharArr[i]){
        return false;
      } 
    }
    return true;
  }
}
