package dinesh_varyani.graph_fundamentals;

/*
 * In this case we represent a graph usig a matrix/grid/two directional array with the nodes on the row and column. 
 * Any connection between two nodes is denoted by placing a value of 1 in the matrix connecting the two nodes
 */

public class MatrixGraph{
  private int vertices; //number of vertices
  private int edges;    //number of edges
  
  private int[][] adjacencyMatrix;

  public MatrixGraph(int nodes){
    this.vertices = nodes;
    this.edges = 0;
    this.adjacencyMatrix = new int[nodes][nodes];
  }

  public void addEdge(int u, int v){
    this.adjacencyMatrix[u][v] = 1;
    this.adjacencyMatrix[v][u] = 1; // since this is an undirected graph you need to specify that the edge goes both ways
    edges++;
  }

  public String toString(){
    StringBuilder sb = new StringBuilder();
    sb.append(vertices + " vertices, " + edges + " edges " + "\n");
    for(int v = 0; v < vertices; v++){
      sb.append(v + " : ");
      for(int w : adjacencyMatrix[v]){
        sb.append(w + " ");
      }
      sb.append("\n");
    }
    return sb.toString();
  }
  public static void main(String[] args) {
    MatrixGraph graph = new MatrixGraph(4);// creating the graph matrix
    graph.addEdge(0, 1);
    graph.addEdge(1, 2);
    graph.addEdge(2, 3);
    graph.addEdge(3, 0);

    System.out.println(graph);
  }
}