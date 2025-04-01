
public class GridTraveller {
  public static void main(String[] args) {
    System.out.println(travelGrid(1,1));
    System.out.println(travelGrid(2,3));
    System.out.println(travelGrid(3,2));
    System.out.println(travelGrid(3,3));
    System.out.println(travelGrid(10,12));
  } 
  
  public static long travelGrid(int m, int n){
    if(m == 1 && n == 1){return 1;}
    if(m == 0 || n == 0){return 0;}

    return travelGrid(m-1, n) + travelGrid(m, n-1);
  }
}
