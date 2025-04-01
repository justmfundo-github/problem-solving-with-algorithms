public class CommonCharacters {
    public static void main(String[] ars){
        String str1 = "t1343o@#";
        String str2 = "hellot132#@";

        System.out.println("Common characters are/is: " + getCommon(str1, str2));
    }

    private static String getCommon(String str1, String str2) {
        String result = ""; // variable to store the common characters
        // let's check if either string has no character
        if(str1.length() == 0 || str2.length() == 0){
            return ""; // we exit the application if one of the strings has no characters
        }
        // let's check which string is shorter
        String shorter = str1.length() > str2.length()?str2 : str1;

        // let's check which string is longer
        String longer = str2.length() > str1.length()?str2 : str1;

        // compare the shorter string to the characters in the longer string
        for(int i=0; i<shorter.length(); i++){
            // get each character of the shorter string
            String c = Character.toString(shorter.charAt(i));
            System.out.println(c);
            // compare each character to the longer string using the String.contains() methods
            if(longer.contains(c) && Character.isLetter(c.charAt(0))){
                result += c;
            }
        }
        if(result.equalsIgnoreCase(""))result = "no mathing characters";
        return result;
    }


}
