/* Write a function that takes in an undirected array of edges for an undirected graph and two nodes (nodeA, nodeB)
   The function should return a boolean indicating whether or not there exists a path between nodeA and nodeB. 
*/
const undirectedPath = (edges, nodeA, nodeB) => {
  // Lets start by building an adjacency graph object
  const graph = buildGraph(edges);
  return hasPath(graph, nodeA, nodeB, new Set());
};

const hasPath = (graph, src, dst, visited) => {
  if (src === dst) return true;
  if (visited.has(src)) return false;

  visited.add(src);

  for (let neighbour of graph[src]) {
    if (hasPath(graph, neighbour, dst, visited) === true) {
      return true;
    }
  }
  return false;
};

// Function to build the adjacency list with each node listed and it's associated edges listed. I.e. Representing a graph
const buildGraph = (edges) => {
  const graph = {};

  for (let edge of edges) {
    const [a, b] = edge;
    if (!(a in graph)) graph[a] = [];
    if (!(b in graph)) graph[b] = [];
    graph[a].push(b);
    graph[b].push(a);
  }

  return graph;
};

const edges = [
  ["i", "j"],
  ["k", "i"],
  ["m", "k"],
  ["k", "l"],
  ["o", "n"],
];

console.log(undirectedPath(edges, "j", "m"));
