import java.util.HashSet;

public class IslandCount {
  public static void main(String[] args) {
    String[][] islandArray  = {
      {"W", "L", "W", "W", "W"},
      {"W", "L", "W", "W", "W"},
      {"W", "W", "W", "L", "W"},
      {"W", "W", "L", "L", "W"},
      {"L", "W", "W", "L", "L"},
      {"L", "L", "W", "W", "W"}
    };

    HashSet<String> visited = new HashSet<String>();
    int islandCount = 0;

    // System.out.println("Row Length: " + islandArray.length);
    // System.out.println("Col length: " + islandArray[0].length);
    for(int row=0; row < islandArray.length; row++){
      for(int col=0; col < islandArray[0].length; col++){
        if(exploreIsland(islandArray, row, col, visited)){ // -> 3
          islandCount += 1;
        }
      }
    }
    System.out.println("Number of islands...: " + islandCount);
  }

  private static boolean exploreIsland(String[][] islandArray, int row, int col, HashSet<String> visited) {
    // Let's create a unique string key consisting of the index position of a cell
    String pos = row + "," + col;
    // Ensure that row and column are not out of bounds before processing. Return false
    if(!(row >= 0 && row < islandArray.length)) return false;
    if(!(col >= 0 && col < islandArray[0].length)) return false;
    // If cell we are hitting is not land return false
    if(islandArray[row][col].equalsIgnoreCase("W")) return false;
    // If we've already visited a cell, return false
    if(visited.contains(pos)) return false;

    visited.add(pos);

    exploreIsland(islandArray, row - 1, col, visited);
    exploreIsland(islandArray, row + 1, col, visited);
    exploreIsland(islandArray, row, col - 1, visited);
    exploreIsland(islandArray, row, col + 1, visited);
    return true;
  }
}
