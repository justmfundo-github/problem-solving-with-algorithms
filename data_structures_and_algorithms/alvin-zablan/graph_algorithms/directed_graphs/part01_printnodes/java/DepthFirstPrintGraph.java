/* Write a method that iterates through every node in the graph and prints it out
   Note that this is a directed graph.
*/
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class DepthFirstPrintGraph {
  public static void main(String[] args) {
    HashMap<String, ArrayList<String>> graph = new HashMap<>(); 
    // Creating the graph to work with
    graph.put("a", new ArrayList<String>(Arrays.asList("c", "b")));
    graph.put("b", new ArrayList<String>(Arrays.asList("d")));
    graph.put("c", new ArrayList<String>(Arrays.asList("e")));
    graph.put("d", new ArrayList<String>(Arrays.asList("f")));
    graph.put("e", new ArrayList<String>());
    graph.put("f", new ArrayList<String>());

    depthFirstTraverseAndPrint(graph);
  }

  private static void depthFirstTraverseAndPrint(HashMap<String, ArrayList<String>> graph) {
    // To perform depth first traversal, we either need to use recursion or a stack
    Deque<String> nodeStack = new ArrayDeque<>();
    nodeStack.add("a");

    while( nodeStack.size() > 0){
      // First pop off the node
      String currentNode = nodeStack.pop();
      System.out.println(currentNode);

      for(String neighbour : graph.get(currentNode)){
        nodeStack.push(neighbour);
      }

    }
  }
}
