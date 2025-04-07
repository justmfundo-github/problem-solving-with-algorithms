package part06_canconstruct.java;

import java.util.HashMap;
import java.util.Map;

public class CountConstructMemoised {
  private static Map<String, Integer> countConstructMemmo = new HashMap<>();

  public static void main(String[] args) {
    System.out.println(countConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"}));
    countConstructMemmo.clear();

    System.out.println(countConstruct("purple", new String[]{"purp", "p", "ur", "le", "purpl"}));
    countConstructMemmo.clear();

    System.out.println(countConstruct("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"}));
    countConstructMemmo.clear();
    System.out.println(countConstruct("enterapotentpot", new String[]{"a", "p", "ent", "enter", "ot", "o", "t"}));
    countConstructMemmo.clear();
    System.out.println(countConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", new String[]{"e", "ee", "eee", "eeee", "eeeee", "eeeeee"}));
    countConstructMemmo.clear();
  }

  private static int countConstruct(String targetStr, String[] wordBank) {
    if(countConstructMemmo.containsKey(targetStr)){
      return countConstructMemmo.get(targetStr);
    }
    if(targetStr == ""){
      return 1;
    }

    int totalNumWays = 0;

    for(String word : wordBank){
      if(targetStr.indexOf(word) == 0){
        int numWays = countConstruct(targetStr.substring(word.length()), wordBank);
        totalNumWays += numWays;
      }
    }
    countConstructMemmo.put(targetStr, totalNumWays);
    return totalNumWays;
  }
}
