/* Write a function that takes in an array of edges for an undirected graph and two nodes (nodeA, nodeB). 
   The function should return the shortest path between nodeA and nodeB. Consider the length as the number
   of edges in the path and not the number of nodes. If there is no path between nodeA and nodeB, then return -1.
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPath{
  public static void main(String[] args) {
    // To start we have list of edges that need to be converted to a version of an adjacency array
    // In this case a HashMap of character as the key and Arraylist of characters as the value
    char[][] edges = {{'w', 'x'}, {'x', 'y'},{'z', 'y'},{'z', 'v'},{'w', 'v'}};
    char nodeA = 'w';
    char nodeB = 'z';
    HashMap<Character, ArrayList<Character>> graph = new HashMap<Character, ArrayList<Character>>();
    graph = convertToGraph(edges, graph);
    System.out.println(graph + "\n\n");

    // now that we have the adjacency list we can check for the ShortestPath 
    // using a breadth first search. At first contact with the destination node, we will know that
    // we've found the shortest path.
    
    int shortestPath = performBreadthFirstSearch(graph, nodeA, nodeB);
    System.out.println("Shortest path is: " + shortestPath);
  }

  private static int performBreadthFirstSearch(HashMap<Character, ArrayList<Character>> graph, char startNode, char destinationNode) {
    HashSet<Character> visitedChars = new HashSet<>();
    Queue<CharDistancePair> charQueue = new LinkedList<CharDistancePair>();
    // Start by placing the first node in the queue
    charQueue.offer(new CharDistancePair(startNode, 0));

    while(charQueue.size() > 0){
      System.out.println(charQueue.toString());
      CharDistancePair currCharDistancePair = charQueue.poll();
      System.out.println("Going through it " + currCharDistancePair.getNodeChar());
      
      if(visitedChars.contains(currCharDistancePair.getNodeChar())){
        System.out.println("Popping...");
        // Don't have to remove anything becuase i've already polled above. I just need to make
        // sure to move onto the next loop. So, the below line is not needed.
        //charQueue.remove(); 
        continue;
      }

      visitedChars.add(currCharDistancePair.getNodeChar());

      if(currCharDistancePair.getNodeChar() ==  destinationNode){
        return currCharDistancePair.getDistance();
      }

      for(char neighbour : graph.get(currCharDistancePair.getNodeChar())){
        // put each neighbour in the queue
        System.out.println("Dealing with each neighbour.... " + neighbour);
        charQueue.offer(new CharDistancePair(neighbour, currCharDistancePair.getDistance() + 1));
      }
    }
    return -1;
  }

  private static HashMap<Character, ArrayList<Character>> convertToGraph(char[][] edges,
      HashMap<Character, ArrayList<Character>> graph) {
    // Iterate through each edge array, use each char as a node key and assign connected nodes
    for(char[] edge : edges){
      if( !graph.containsKey(edge[0])){
        graph.put(edge[0], new ArrayList<Character>());
      }
      if( !graph.containsKey(edge[1])){
        graph.put(edge[1], new ArrayList<Character>());
      }

      graph.put(edge[0], addToArrayList(graph.get(edge[0]), edge[1]));
      graph.put(edge[1], addToArrayList(graph.get(edge[1]), edge[0]));
      
    }

    return graph;
  }

  private static ArrayList<Character> addToArrayList(ArrayList<Character> arrayList, char edgeChar) {
    arrayList.add(edgeChar);
    return arrayList;
  }


}

class CharDistancePair{
  private char nodeChar;
  private int distance;

  public CharDistancePair(char nodeChar, int distance){
    this.nodeChar = nodeChar;
    this.distance = distance;
  }

  public char getNodeChar() {
    return nodeChar;
  }

  public void setNodeChar(char nodeChar) {
    this.nodeChar = nodeChar;
  }

  public int getDistance() {
    return distance;
  }

  public void setDistance(int distance) {
    this.distance = distance;
  }

  @Override
  public String toString() {
    return "CharDistancePair [nodeChar=" + nodeChar + ", distance=" + distance + "]";
  }
  
  
}