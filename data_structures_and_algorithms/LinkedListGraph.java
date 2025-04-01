import java.util.LinkedList;

/*
 * In this case we represent the graph using an array of all the nodes/vertices and their list of adjacent nodes or linked nodes
 */

public class LinkedListGraph {
  private int vertices; //number of vertices
  private int edges;    //number of edges

  LinkedList<Integer>[] adjacentVertices;

  public LinkedListGraph(int nodes){
    this.vertices = nodes; //nodes and vertices are interchangeable. Vertex is a node.
    this.edges = 0;
    this.adjacentVertices = new LinkedList[nodes];// don't forget to initialize the array of LinkedLists
    for(int n = 0; n < nodes; n++){//for each node, initialize a list of adjacent nodes
      adjacentVertices[n] = new LinkedList<Integer>();
    }
  }

  public void addEdge(int u, int v){
    adjacentVertices[u].add(v);
    adjacentVertices[v].add(u);   //undirected graph means each vertex/node has to also have a reference to the one pointing to it
    edges++;  //increment number of edges
  }

  public String toString(){
    StringBuilder sb = new StringBuilder();
    sb.append(vertices + " vertices, " + edges + " edges " + "\n");
    for(int v=0; v<vertices; v++){
      sb.append(v + ": ");
      for(int w : adjacentVertices[v]){
        sb.append(w + " ");
      }
      sb.append("\n");      
    }
    return sb.toString();
  }

  public static void main(String[] args){
    LinkedListGraph linkedListGraph = new LinkedListGraph(4);
    linkedListGraph.addEdge(0, 1);
    linkedListGraph.addEdge(1, 2);
    linkedListGraph.addEdge(2, 3);
    linkedListGraph.addEdge(3, 0);

    System.out.println(linkedListGraph);
  }
}
