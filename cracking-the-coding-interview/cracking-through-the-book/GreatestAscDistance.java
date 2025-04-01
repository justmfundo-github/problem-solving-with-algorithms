public class GreatestAscDistance {
    public static void main(String[] args){
        //int[] arr = {4, 2, 5, 8, 1};
        int[] arr = {6, 5, 4, 3, 2, 1};

        int min = arr[0]; // int to be reassigned when found
        int max = arr[0]; // int to be reassigned when found
        int current = 0;
        int index = 0; // use this var to find the index of min
        // check values to the right of the index

        for(int i = 0; i<arr.length; i++){
            current = arr[i];
            // step 1: find the lowest value on the left hand side
            // assume there is at least one element on the right hand side
            if(min > current && current != arr[arr.length-1]){
                min = current; // find the new minimum
                index = i;
            }

            // step 2: find the largest value on the right hand side
            if(min < current && current > arr[index]){
                max = current; // find the new maximum
                //index = i;
            }
            
        }
        
        // print out some test values
        System.out.println("minimum: " + min);
        System.out.println("max: " + max);

        // step 3: verify that min is not greater than max. return -1 otherwise
        if(min > max){
            System.out.println(-1);
        }else{
            System.out.println(max - min);
        }
    }
}
