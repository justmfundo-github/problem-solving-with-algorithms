// Write a function that takes in the adjacency list of an undirected graph. The function should
// return the largest connected components group/island within the graph. (Islands of connected nodes
// are seen as a group/connected components set. Which of those sets/groups is the largest?)

const connectedComponentsMaxSize = (graph) => {
  const visited = new Set(); // use this variable to store the visited nodes
  let maxSize = 0;

  // because we don't have a starting node, and we have no real information about how we should start the search
  // we explore each node to see what other nodes it connects to and how big those connected sets are
  for (let node in graph) {
    // "in" means for each index in the graph

    //perform an exploration of adjacent nodes
    // each node exploration should return the associated node network size
    const connectedNodeSize = exploreSize(graph, node, visited);
    if (maxSize < connectedNodeSize) {
      maxSize = connectedNodeSize;
    }
  }
  return maxSize;
};

// explore the graph and return the number of nodes in the connected components set
const exploreSize = (graph, current, visited) => {
  // if we've already seen a node, we can't count it again.
  if (visited.has(String(current))) return 0;

  visited.add(String(current)); // if we haven't seen this node before, add it to the visited list.
  let connectedNodeSize = 1; //assigning the size to 1 because we've just entered a node.
  // for each current node, we will check it's neighbours BUT we will then call the exploreSize call for each neighbour
  for (let neighbour of graph[current]) {
    // recursive call, where we also accumulate the returned size of connected components per neighbour
    connectedNodeSize += exploreSize(graph, neighbour, visited);
  }

  return connectedNodeSize;
};

const graph = {
  0: [8, 1, 5],
  1: [0],
  5: [0, 8],
  8: [0, 5],
  2: [3, 4],
  3: [2, 4],
  4: [3, 2],
};

console.log(`Max size is...: ${connectedComponentsMaxSize(graph)}`); // 2
