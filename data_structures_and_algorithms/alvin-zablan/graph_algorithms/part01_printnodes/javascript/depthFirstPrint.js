const depthFirstPrint = (graph, source) => {
  const stack = [source];

  while (stack.length > 0) {
    const current = stack.pop();
    console.log(current);
    for (let neighbour of graph[current]) {
      stack.push(neighbour);
    }
  }
};

const depthFirstPrintRecursive = (graph, source) => {
  console.log(source);

  for (let neighbour of graph[source]) {
    depthFirstPrintRecursive(graph, neighbour);
  }
};

const graph = {
  a: ["c", "b"],
  b: ["d"],
  c: ["e"],
  d: ["f"],
  e: [],
  f: [],
};

console.log("******************** Using a stack approach ********************");
depthFirstPrint(graph, "a"); //abdfce or acebdf depending on the order of c and b in the a map
console.log("******************** Recursive approach (still a stack)**********************");
depthFirstPrintRecursive(graph, "a"); //abdfce or acebdf depending on the order of c and b in the a map
