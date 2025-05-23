/* Write a method that iterates through every node in the graph and prints it out
   Note that this is a directed graph.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class DepthFirstPrintGraphRecursive {
  public static void main(String[] args) {
    HashMap<String, ArrayList<String>> graph = new HashMap<>(); 
    // Creating the graph to work with
    graph.put("a", new ArrayList<String>(Arrays.asList("c", "b")));
    graph.put("b", new ArrayList<String>(Arrays.asList("d")));
    graph.put("c", new ArrayList<String>(Arrays.asList("e")));
    graph.put("d", new ArrayList<String>(Arrays.asList("f")));
    graph.put("e", new ArrayList<String>());
    graph.put("f", new ArrayList<String>());

    depthFirstTraverseAndPrint(graph, "a");
  }

  private static void depthFirstTraverseAndPrint(HashMap<String, ArrayList<String>> graph, String startNode) {
    // To perform depth first traversal, we either need to use recursion or a stack
    // Base case(s)
    System.out.println(startNode);
    // if(graph.get(startNode).size() <= 0)return;
    // First pop off the node

    for(String neighbour : graph.get(startNode)){
      depthFirstTraverseAndPrint(graph, neighbour);
    }
  }
}
