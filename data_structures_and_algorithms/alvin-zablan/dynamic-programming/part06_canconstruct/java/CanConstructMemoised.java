package part06_canconstruct.java;

import java.util.HashMap;
import java.util.Map;

public class CanConstructMemoised {
  private static Map<String, Boolean> constructMemo = new HashMap<>();
  public static void main(String[] args) {
    
    System.out.println(canConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"}));
    constructMemo.clear();
    System.out.println(canConstruct("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"}));
    constructMemo.clear();
    System.out.println(canConstruct("enterapotentpot", new String[]{"a", "p", "ent", "enter", "ot", "o", "t"}));
    constructMemo.clear();
    System.out.println(canConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", new String[]{"e", "ee", "eee", "eeee", "eeeee", "eeeeee"}));
    constructMemo.clear();
  } 

  public static boolean canConstruct(String targetStr, String[] wordBank){
    if(constructMemo.containsKey(targetStr)){return constructMemo.get(targetStr);}
    if(targetStr == ""){
      return true;
    }

    for(String word : wordBank){
      if(targetStr.indexOf(word) == 0){
        // System.out.println("Works so far..." + word);
        String strRemainder = targetStr.substring(word.length());
        if(canConstruct(strRemainder, wordBank) == true){
          constructMemo.put(strRemainder, true);
          return true;
        }
      }
    }
    constructMemo.put(targetStr, false);
    return false;
  }
}

