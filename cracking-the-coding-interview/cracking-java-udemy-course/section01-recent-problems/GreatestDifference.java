public class GreatestDifference {
  // Given an array of elements (integers), find the greatest difference between any two elements x and y  as long as, 
  // y > x  and y comes after x in the array 

  public static void main(String[] args) {
    // System.out.println(getGreatestDifferenceV2(new int[]{2, 3, 7, 9, 1}));
    // System.out.println(getGreatestDifferenceV2(new int[]{2, 3, 7, 9, 1, 14, 0}));
    // System.out.println(getGreatestDifference(new int[]{2, 3, 7, 9, 1, 12, 4, 32, 43, 12, 11, 2, 17}));
    // System.out.println(getGreatestDifference(new int[]{12, 4, 32, 43, 12, 11, 2, 17}));
  
    // System.out.println(getGreatestDifferenceV2(new int[]{2, 3, 7, 9, 1}));
    // System.out.println(getGreatestDifferenceV2(new int[]{2, 3, 7, 9, 1, 14, 0}));
    // System.out.println(getGreatestDifferenceV2(new int[]{2, 3, 7, 9, 1, 12, 4, 32, 43, 12, 11, 2, 17}));
    // System.out.println(getGreatestDifferenceV2(new int[]{12, 4, 32, 43, 12, 11, 2, 17}));
    System.out.println(getGreatestDifference(new int[]{19, 14, 11, 9, 1}));
    System.out.println(getGreatestDifferenceV2(new int[]{19, 14, 11, 9, 1}));
  }
    
  /* BRUTE FORCE approach has a time complexity of n^2 because of the inner for loop on the input n */
      private static int getGreatestDifference(int[] intArray) {
        int difference = -1; 
        // int testNum = intArray[]

        for( int i=0; i<intArray.length; i++){  // Anytime you create a nested array that uses the same value n, 
          for(int j=0; j<intArray.length; j++){ // you create a bottleneck
            int tempDiff = intArray[j] - intArray[i];
            if(j > i && tempDiff > 0 && tempDiff > difference){
              difference = tempDiff;
            }
          }
        }
        return difference;
      }

      /* More efficient approach using one loop and no inner loop */
      private static int getGreatestDifferenceV2(int[] intArray) {
        //initialise max difference using the first and second elements in the array 
        int maxDiff = intArray[1] - intArray[0];
        int minElement = intArray[0];

        for( int i=0; i<intArray.length; i++){
          // As wew move along the array, we will keep track of two values. 
          // Maximum difference and Minimum element. NB: Even though the minimum element may change to a lower 
          // value, the max number doesn't change unless we encounter another large number in the array. That
          // new large number is then compared to the new minimum and if it is larger than max. We update max. 
          // We will always end up comparing the smallest number to a larger number on the right side of the smallest
          // number because we are always moving to the right along the array. We just keep holding onto the 
          // smallest number and hoping to find another larger number that when compared to the smallest number
          // returns a difference that is greater than our max. At which point we update max.  
          
          // Maximum difference tracking tracking
          if(intArray[i] - minElement > maxDiff ){
            maxDiff = intArray[i] - minElement;
          }


          // Tracking the smallest element
          if(intArray[i] < minElement){
            minElement = intArray[i];
          }
          
        }
        // System.out.println("Min Element: " + minElement);
        
        return maxDiff <= 0? -1 : maxDiff;
      }
  
}
