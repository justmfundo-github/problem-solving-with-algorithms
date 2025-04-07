package part06_canconstruct.java;

public class CountConstruct {

  public static void main(String[] args) {
    System.out.println(countConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"}));
    System.out.println(countConstruct("purple", new String[]{"purp", "p", "ur", "le", "purpl"}));
    System.out.println(countConstruct("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"}));
    System.out.println(countConstruct("enterapotentpot", new String[]{"a", "p", "ent", "enter", "ot", "o", "t"}));
    // System.out.println(countConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", new String[]{"e", "ee", "eee", "eeee", "eeeee", "eeeeee"}));

  }

  private static int countConstruct(String targetStr, String[] wordBank) {
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

    return totalNumWays;
  }
}
