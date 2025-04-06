package part06_canconstruct.java;

public class CanConstruct {
  public static void main(String[] args) {
    System.out.println(canConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"}));
    System.out.println(canConstruct("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"}));
    System.out.println(canConstruct("enterapotentpot", new String[]{"a", "p", "ent", "enter", "ot", "o", "t"}));
    // System.out.println(canConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", new String[]{"e", "ee", "eee", "eeee", "eeeee", "eeeeee"}));
  } 

  public static boolean canConstruct(String targetStr, String[] wordBank){
    if(targetStr == ""){
      return true;
    }

    for(String word : wordBank){
      if(targetStr.indexOf(word) == 0){
        // System.out.println("Works so far..." + word);
        String strRemainder = targetStr.substring(word.length());
        if(canConstruct(strRemainder, wordBank) == true){
          return true;
        }
      }
    }

    return false;
  }
}

