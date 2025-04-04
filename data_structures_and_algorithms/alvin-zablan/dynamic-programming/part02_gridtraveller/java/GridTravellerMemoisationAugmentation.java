import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class GridTravellerMemoisationAugmentation {
  public static void main(String[] args) {

    Map<String, Long> gridTravelMemo = new HashMap<>();

    Instant gridTravelStart = Instant.now();
    System.out.println(travelGrid(50,50, gridTravelMemo));
    gridTravelMemo.clear();
    Instant gridTravelEnd = Instant.now();
    Duration timeElapsed = Duration.between(gridTravelStart, gridTravelEnd);
    System.out.println("Memoised GridTravel Execution time: " + timeElapsed.toMillis() + " milliseconds");
    

    Instant gridTravelAugmentStart = Instant.now();
    System.out.println(travelGridAugmented(50,50, gridTravelMemo));
    gridTravelMemo.clear();
    Instant gridTravelAugmentEnd = Instant.now();
    Duration AugmentationTimeElapsed = Duration.between(gridTravelAugmentStart, gridTravelAugmentEnd);
    System.out.println("Memoised GridTravel Execution time: " + AugmentationTimeElapsed.toMillis() + " milliseconds");
    
    
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
  
  public static long travelGridAugmented(int m, int n, Map<String, Long> gridTravelMemo){
    String key = m + "," + n;
    String keyRev = n + "," + m;
    if(gridTravelMemo.containsKey(key) || gridTravelMemo.containsKey(keyRev)){
      return (long)gridTravelMemo.get(key);
    }
    if(m == 1 && n == 1){return 1;}
    if(m == 0 || n == 0){return 0;}

    gridTravelMemo.put(key, (travelGridAugmented(m-1, n, gridTravelMemo) + travelGridAugmented(m, n-1, gridTravelMemo)));
    gridTravelMemo.put(keyRev, gridTravelMemo.get(key));
    return (long)gridTravelMemo.get(key);
  }
  
}
