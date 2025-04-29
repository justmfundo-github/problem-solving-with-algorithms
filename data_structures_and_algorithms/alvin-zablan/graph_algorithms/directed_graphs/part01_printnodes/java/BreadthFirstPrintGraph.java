/* Write a method that iterates through every node in the graph and prints it out
   Note that this is a directed graph.
*/

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Queue;

public class BreadthFirstPrintGraph {
  public static void main(String[] args) {
    HashMap<String, ArrayList<String>> graph = new HashMap<>(); 
    // Creating the graph to work with
    graph.put("a", new ArrayList<String>(Arrays.asList("c", "b")));
    graph.put("b", new ArrayList<String>(Arrays.asList("d")));
    graph.put("c", new ArrayList<String>(Arrays.asList("e")));
    graph.put("d", new ArrayList<String>(Arrays.asList("f")));
    graph.put("e", new ArrayList<String>());
    graph.put("f", new ArrayList<String>());

    breadthFirstTraverseAndPrint(graph, "a");
  }

  private static void breadthFirstTraverseAndPrint(HashMap<String, ArrayList<String>> graph, String startNode) {
    // To perform breadth first traversal, we need to use a queue
    Queue<String> nodeDeqQueue = new ArrayDeque<>();
    nodeDeqQueue.add(startNode);
    
    while(nodeDeqQueue.size() > 0){
      // First pop off the node
      String currentNode = nodeDeqQueue.poll();
      System.out.println(currentNode);
      // now check this node's neighbours
      for(String neighbour : graph.get(currentNode)){
        nodeDeqQueue.add(neighbour);
      }
    }

  }
}
