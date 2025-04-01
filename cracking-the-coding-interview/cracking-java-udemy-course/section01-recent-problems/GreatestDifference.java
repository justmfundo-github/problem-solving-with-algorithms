public class GreatestDifference {
  // Given an array of elements (integers), find the greatest difference between any two elements x and y  as long as, 
  // y > x  and y comes after x in the array 

  public static void main(String[] args) {
    System.out.println(getGreatestDifference(new int[]{2, 3, 7, 9, 1}));
    System.out.println(getGreatestDifference(new int[]{2, 3, 7, 9, 1, 12, 4, 32, 43, 12, 11, 2, 17}));
      }
    
      private static int getGreatestDifference(int[] intArray) {
        int difference = -1; 
        // int testNum = intArray[]

        for( int i=0; i<intArray.length; i++){
          for(int j=0; j<intArray.length; j++){
            int tempDiff = intArray[j] - intArray[i];
            if(j > i && tempDiff > 0 && tempDiff > difference){
              difference = tempDiff;
            }
          }
        }
        return difference;
      }
  
}
