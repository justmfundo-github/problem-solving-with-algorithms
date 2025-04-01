import java.util.HashMap;
import java.util.Map;

public class GridTravellerMemoisation {
  public static void main(String[] args) {

    Map<String, Long> gridTravelMemo = new HashMap<>();

    System.out.println(travelGrid(1,1, gridTravelMemo));
    gridTravelMemo.clear();
    System.out.println(travelGrid(2,3, gridTravelMemo));
    gridTravelMemo.clear();
    System.out.println(travelGrid(3,2, gridTravelMemo));
    gridTravelMemo.clear();
    System.out.println(travelGrid(3,3, gridTravelMemo));
    gridTravelMemo.clear();
    System.out.println(travelGrid(10,12, gridTravelMemo));
    gridTravelMemo.clear();
  } 
  
  public static long travelGrid(int m, int n, Map<String, Long> gridTravelMemo){
    String key = m + "," + n;
    if(gridTravelMemo.containsKey(key)){
      return (long)gridTravelMemo.get(key);
    }
    if(m == 1 && n == 1){return 1;}
    if(m == 0 || n == 0){return 0;}

    gridTravelMemo.put(key, (travelGrid(m-1, n, gridTravelMemo) + travelGrid(m, n-1, gridTravelMemo)));
    return (long)gridTravelMemo.get(key);
  }
}
