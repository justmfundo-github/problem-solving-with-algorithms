/* Write a function that takes in an undirected array of edges for an undirected graph and two nodes (nodeA, nodeB)
   The function should return a boolean indicating whether or not there exists a path between nodeA and nodeB. 
*/
const undirectedPath = (edges, nodeA, nodeB) => {
  // Lets start by building an adjacency graph object
  const graph = buildGraph(edges);
  return hasPath(graph, nodeA, nodeB, new Set());
};

// Let's build this solution using a good old stack instead of doing iit recursively this time...
const hasPath = (graph, src, dst, visited) => {
  const stack = [src];

  while (stack.length > 0) {
    const current = stack.pop(); // let's remove our current node and work with it
    if (visited.has(current)) {
      stack.pop; // if it has been dealt with then just remove it and keep searching until we remove all nodes from the stack
      continue; // continue the while loop without processing the rest of the below code in the while loop
    }
    if (current === dst) return true; // Every time we pop a node off we need to check if it is our destination
    visited.add(current); // let's also make a note that we've dealt with this particular node now

    for (let neighbour of graph[current]) {
      stack.push(neighbour); // let's iterate through each neighbour of this node and add neighbour to the stack
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
