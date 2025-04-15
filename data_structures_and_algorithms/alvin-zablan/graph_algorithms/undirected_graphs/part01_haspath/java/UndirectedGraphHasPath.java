/* Write a method that takes in an undirected array of edges for an undirected graph and two nodes (nodeA, nodeB)
   The function should return a boolean indicating whether or not there exists a path between nodeA and nodeB. 
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UndirectedGraphHasPath {
  public static void main(String[] args) {

    char[][] arrayOfEdges = {
      {'i', 'j'},
      {'k', 'i'},
      {'m', 'k'},
      {'k', 'l'},
      {'o', 'n'}};    

      // Lets start by building an adjacency graph object
      Map<Character, ArrayList<String>> graph = new HashMap<Character, ArrayList<String>>();
      graph = buildGraph(arrayOfEdges);
      System.out.println(graph);
  }

  private static Map<Character, ArrayList<String>> buildGraph(char[][] arrayOfEdges) {
    Map<Character, ArrayList<String>> graph = new HashMap<Character, ArrayList<String>>();


    for (char edge[] : arrayOfEdges) {
      if( !graph.containsKey(edge[0])){
        graph.put(edge[0], new ArrayList<>());
      }  
      if( !graph.containsKey(edge[1])){
        graph.put(edge[1], new ArrayList<>());
      }      
      graph.put(edge[0], addToArrayList(graph.get(edge[0]), Character.toString(edge[1])));
      graph.put(edge[1], addToArrayList(graph.get(edge[1]), Character.toString(edge[0])));
    }

    return graph;
  }

  private static ArrayList<String> addToArrayList(ArrayList<String> arrayList, String charToAdd) {
    arrayList.add(charToAdd);
    return arrayList;
  }
}



/* Write a function that takes in an undirected array of edges for an undirected graph and two nodes (nodeA, nodeB)
   The function should return a boolean indicating whether or not there exists a path between nodeA and nodeB. 
*/
// const undirectedPath = (edges, nodeA, nodeB) => {
  
//   const graph = buildGraph(edges);
//   return hasPath(graph, nodeA, nodeB, new Set());
// };

// // Let's build this solution using a good old stack instead of doing iit recursively this time...
// const hasPath = (graph, src, dst, visited) => {
//   const stack = [src];

//   while (stack.length > 0) {
//     const current = stack.pop(); // let's remove our current node and work with it
//     if (visited.has(current)) {
//       stack.pop; // if it has been dealt with then just remove it and keep searching until we remove all nodes from the stack
//       continue; // continue the while loop without processing the rest of the below code in the while loop
//     }
//     if (current === dst) return true; // Every time we pop a node off we need to check if it is our destination
//     visited.add(current); // let's also make a note that we've dealt with this particular node now

    
//     let neighbour of graph[current]) {
//       stack.push(neighbour); // let's iterate through each neighbour of this node and add neighbour to the stack
//     }
//   }

//   return false;
// };

// // Function to build the adjacency list with each node listed and it's associated edges listed. I.e. Representing a graph
// const buildGraph = (edges) => {
  
// };



// console.log(undirectedPath(edges, "j", "m"));
