/* Write a function, that takes in an object representing the adjacency list of an acyclic graph and two nodes (src, dst).
   The function should return a boolean indicating whether or not there exists a path from the source node to the 
   destination node. Note that ACYCLIC means that the graph does not allow you to travel the same paths
   on nodes.
*/ 

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Queue;

public class HasPathBreadthFirst {
  public static void main(String[] args) {
    HashMap<String, ArrayList<String>> graph = new HashMap<>(); 
    // Creating the graph to work with
    graph.put("f", new ArrayList<String>(Arrays.asList("g", "i")));
    graph.put("g", new ArrayList<String>(Arrays.asList("h")));
    graph.put("h", new ArrayList<String>());
    graph.put("i", new ArrayList<String>(Arrays.asList("g", "k")));
    graph.put("j", new ArrayList<String>(Arrays.asList("i")));
    graph.put("k", new ArrayList<String>());

    String nodeA = "f";
    String nodeB = "k";
    boolean hasPath = exploreGraphPathBreadthFirst(graph, nodeA, nodeB);
    System.out.println("Path exists between " + nodeA + " and " + nodeB + ":  " + hasPath );
  }

  private static boolean exploreGraphPathBreadthFirst(HashMap<String, ArrayList<String>> graph, String startNode, String destNode){

    Queue<String> nodeDequeQueue = new ArrayDeque<String>();    
    nodeDequeQueue.add(startNode);

    while (nodeDequeQueue.size() > 0){
      String currentNode = nodeDequeQueue.poll();
      if(currentNode == destNode){
        return true;
      }
      for(String neighbour : graph.get(currentNode)){
        nodeDequeQueue.add(neighbour);
      }

    }
  
    return false;
  }
}
