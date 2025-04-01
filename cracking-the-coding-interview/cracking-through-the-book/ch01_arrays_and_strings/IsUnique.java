/* Implement an algorithm to determine if a string has all unique characters */

import java.util.Arrays;
import java.util.HashSet;

public class IsUnique{
  public static void main(String[] args) {
    String input = "asdflkj"; //"asdflkj" "thecultofjava"
    
    //System.out.println("String " + input + " has unique characters: " + hasAllUniqueCharsBruteForce(input));
    // System.out.println("String " + input + " has unique characters: " + hasAllUniqueCharsAsciiSort(input));
    System.out.println("String " + input + " has unique characters: " + hasAllUniqueCharsBooleanFlags(input));
    // System.out.println("String " + input + " has unique characters: " + hasAllUniqueCharsHashSet(input));
  }

  private static boolean hasAllUniqueCharsBooleanFlags(String input) {
    // First check to see if the string length is greater than the length of all possible available chars
    // there are 128 character alphabet
    if(input.length() > 128) return false;

    // create an array of booleans of size 128
    boolean[] char_set = new boolean[128];
    for(int i=0; i<input.length(); i++){
      int val = input.charAt(i); //note that assigning charAt to an int means it's ASCII value. ASCII characters go up to 127
      // So now we can set the charAt value index to a boolean of true but first check if that index is already set to true
      if(char_set[val]){
        return false;
      }
      char_set[val] = true;
      //System.out.println(val);
    }
    return true;
  }

  // Using a brute force approach, create two iterators and simply compare each char to all the other characters
  // Soon as you get chars that match, we know the string has non unique characters and we can return false
  public static boolean hasAllUniqueCharsBruteForce(String input){
    
    for(int i = 0; i < input.length(); i++){
      for(int j = i+1; j < input.length(); j++){
        if(input.charAt(i) == input.charAt(j)){
          return false;
        }
      }
    }

    //if no duplicates are found 
    return true;
  }

  // The sort approach entails, sorting the string and then checking for characters followed by a duplicate
  public static boolean hasAllUniqueCharsAsciiSort(String input){
    char[] charArray = input.toCharArray();

    //sort the array
    Arrays.sort(charArray);

    //iterate through the array and check for duplicates
    for(int i=0; i<charArray.length - 1; i++){
      if(charArray[i] != charArray[i+1]){//if the characters are not the same, keep going with the checks
        continue;
      }else{
        return false;
      }
    }

    return true;
  }

  /*
   * One solution is to create an array of boolean values, where the flag at index i indicates whether character
     i in the alphabet is contained in the string. The second time you see this character you can immediately
     return false.
   */

  // In this case we create a hashset using the string. Note that duplicates are not allowed. so the final length of the hashset will either be 
  // equal to the input string length if there are no duplicates. Or less than the length of the input string if there are in fact 
  // any duplicates. Remember that duplicates will be discarded from the Hashset.
  public static boolean hasAllUniqueCharsHashSet(String input){
    HashSet<Character> inputHashSet = new HashSet<>();

    for(int i = 0; i < input.length(); i++){
      inputHashSet.add(input.charAt(i));
    }

    System.out.println(inputHashSet + " and hashset size is: " + inputHashSet.size());

    if(input.length() != inputHashSet.size()){
      return false;
    }

    //if no duplicates are found 
    return true;
  }
}