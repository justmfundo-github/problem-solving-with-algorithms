/* Write a function that takes in an array of edges for an undirected graph and two nodes (nodeA, nodeB). 
   The function should return the shortest path between nodeA and nodeB. Consider the length as the number
   of edges in the path and not the number of nodes. If there is no path between nodeA and nodeB, then return -1.
*/
const shortestPath = (edges, nodeA, nodeB) => {
  // first we need to takes edges and return an adjacency graph.
  const graph = createNodeGraph(edges);

  // we need to keep track of the visited nodes so that we don't go backwards
  const visited = new Set();

  // now to traverse our graph to find the shortest path
  const shortestDistance = shortestPathExplore(graph, nodeA, nodeB, visited);
  return shortestDistance;
};

// explore the graph and return the shortest path between the two specified nodes
const shortestPathExplore = (graph, start, dst, visited) => {
  const nodeQueue = [[start, 0]];

  while (nodeQueue.length > 0) {
    let [currentNode, shortestPath] = nodeQueue.shift();
    // if we've already seen a node, we can't count it again.
    if (visited.has(currentNode)) continue;

    visited.add(currentNode);

    if (currentNode === dst) return shortestPath;

    for (let neighbour of graph[currentNode]) {
      nodeQueue.push([neighbour, shortestPath + 1]);
    }
  }

  return -1;
};

const createNodeGraph = (edgesArray) => {
  // we need to traverse the edges, make each unique node a key on the graph and set associated nodes
  const graph = {};

  for (let edge of edgesArray) {
    const [a, b] = edge;
    if (!(a in graph)) graph[a] = [];
    if (!(b in graph)) graph[b] = [];

    graph[a].push(b);
    graph[b].push(a);
  }
  return graph;
};

const edges = [
  ["w", "x"],
  ["x", "y"],
  ["z", "y"],
  ["z", "v"],
  ["w", "v"],
];

//const edges = [["w", "x"],["x", "y"],["z", "y"], ["z", "v"],["w", "v"]];

console.log(`Shortest path is...: ${shortestPath(edges, "w", "z")}`); // 2
