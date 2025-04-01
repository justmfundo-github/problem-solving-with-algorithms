public class CommonCharacters{

  // Given two strings, find the common letters in the two strings. 
  // I.e. are and hello should have "e" as the common letter
  
  public static void main(String[] args) {
    System.out.println(getCommon("are", "stand"));
    System.out.println(getCommon("le", "hello"));
    System.out.println(getCommon("are#$@", "stand#$#"));
    System.out.println(getCommon("are#$@", "hello"));
  }

  public static String getCommon(String str1, String str2){
    String result = "";

    // rulle out odd case where either string is empty
    if(str1.length() == 0 || str2.length() == 0) return "";
    
    // find which string is the shortest...and longest;
    String shorter = str1.length() < str2.length()? str1 : str2;
    String longer = shorter.equals(str1)? str2 : str1;

    // compare shorter string's characters to the longer string
    for( int i=0; i < shorter.length(); i++){
      String c = Character.toString(shorter.charAt(i));
      // Character.isLetter() also ensures that we only concern our test with valid letters as opposed to special characters
      if(longer.contains(c) && Character.isLetter(c.charAt(0))) result += c;
    }
    

    return result;
  }
}