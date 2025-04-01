public class URLify {
  public static void main(String[] args) {
    String input = "Mr John Smith    , 13";
    System.out.println("Using the traversal string method: " + traverseAndUrlify(input));
    System.out.println("Using the replaceAll string method: " + replaceMethodToUrlify(input));
  }

  private static String replaceMethodToUrlify(String input) {
    String strInput = "";
    int strInputLength = 0;

    String tempArray[] = input.split(",");
    strInput = tempArray[0].trim();
    strInputLength = Integer.parseInt(tempArray[1].trim());

    System.out.println( "String to URLify: " + strInput + "\nLength of the string: " + strInputLength);
    return strInput.replace(" ", "%20");
  }

  private static String traverseAndUrlify(String input) {
    String finalUrl = "";
    for(int i=0; i<input.length(); i++){
      // if(input.charAt(i) == ' '){
      //   input.charAt(i).replace(" ");
      // }
    }


    return finalUrl;
  }
}
