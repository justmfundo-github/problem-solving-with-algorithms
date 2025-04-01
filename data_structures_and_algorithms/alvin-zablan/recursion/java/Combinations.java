import java.util.Arrays;

public class Combinations {
  static int stackCount = 0;
  public static void main(String[] args) {
    char[] charElements = new char[]{'a', 'b', 'c', 'd'};
    System.out.println(combinations(charElements));

  }

  public static char[] combinations(char[] charElements){
    //establishing the base case
    if(charElements.length == 0)return new char[]{};

    char[] restOfCharElements = Arrays.copyOfRange(charElements, 1, charElements.length);
    char[] combsWithoutFirst = combinations(restOfCharElements);
    
    return combsWithoutFirst;
  }

  public static void printCharArray(char[] charArray){
    for(char c : charArray){
      System.out.println(c);
    }
  }
}
