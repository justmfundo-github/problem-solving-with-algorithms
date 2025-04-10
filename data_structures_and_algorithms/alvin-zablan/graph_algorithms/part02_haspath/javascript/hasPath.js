/* Write a function, that takes in an object representing the adjacency list of an acyclic graph and two nodes (src, dst).
   The function should return a boolean indicating whether or not there exists a path from the source node to the 
   destination node.
*/

const hasPathDepthFirstRecursive = (graph, src, dst) => {
  if (src === dst) return true;

  for (let neighbour of graph[src]) {
    if (hasPathDepthFirstRecursive(graph, neighbour, dst) === true) {
      return true;
    }
  }
  return false;
};

/* NB: Bread first search cannot be implemented RECURSIVELY on a graph */
const hasPathBreadthFirst = (graph, src, dst) => {
  const queue = [src];

  while (queue.length > 0) {
    if (queue.shift() === dst) {
      return true;
    }
    for (let neighbour of graph[src]) {
      queue.push(neighbour);
    }
  }
  return false;
};

const graph = {
  f: ["g", "i"],
  g: ["h"],
  h: [],
  i: ["g", "k"],
  j: ["i"],
  k: [],
};

console.log(hasPathDepthFirstRecursive(graph, "f", "k"));
console.log(hasPathBreadthFirst(graph, "f", "k"));
