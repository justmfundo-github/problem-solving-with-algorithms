import java.util.*;
public class Exercise1 {
    public static void main(String[] args){
         Scanner scanner = new Scanner(System.in); 
         // You may use scanner to get input values, see an example commented below
         // int number = scanner.nextInt();
         
        
         // Start coding below! Good luck!
        
        try{
            int number = scanner.nextInt();
            int mod = number/2;
            if(mod == 0){
                System.out.println("Even");
            }else{
                System.out.println("Odd");
            }
            
        }catch(Exception ex){
            System.out.println("Not an integer, try again!");
        }
        
        scanner.close();
    }
}