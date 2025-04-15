// Write a function that takes in the adjacency list of an undirected graph. The function should
// return the number of connected components within the graph. (Islands of connected nodes)

const connectedComponentsCount = (graph) => {
  const visited = new Set();
  let count = 0;

  for (let node in graph) {
    console.log(visited);
    if (explore(graph, node, visited) === true) {
      count += 1;
    }
  }

  return count;
};

const explore = (graph, current, visited) => {
  if (visited.has(String(current))) {
    return false;
  }

  visited.add(String(current));
  for (let neighbour of graph[current]) {
    explore(graph, neighbour, visited);
  }

  return true;
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

console.log(connectedComponentsCount(graph)); // 2
