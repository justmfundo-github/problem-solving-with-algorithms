import java.util.HashSet;

public class MinimumIsland {
  public static void main(String[] args) {
    String[][] gridArray = {
      {"W", "L", "W", "W","W"},
      {"W", "L", "W", "W", "W"},
      {"W", "W", "W", "L", "W"},
      {"W", "W", "L", "L", "W"},
      {"L", "W", "W", "L", "L"},
      {"L", "L", "W", "W", "W"}
    };

    HashSet<String> visited = new HashSet<String>();
    //minimumIsland(grid); // -> 2
  }
}