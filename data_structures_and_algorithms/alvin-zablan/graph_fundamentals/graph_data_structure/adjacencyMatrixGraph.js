const vertices = ["A", "B", "C", "D", "E"];

const vertexIndexes = {
  A: 0,
  B: 1,
  C: 2,
  D: 3,
  E: 4,
};

const adjacencyMatrix = [
  //initialize adjacency matrix to all zeroes
  [0, 0, 0, 0, 0],
  [0, 0, 0, 0, 0],
  [0, 0, 0, 0, 0],
  [0, 0, 0, 0, 0],
  [0, 0, 0, 0, 0],
];

// function to add an edge between two nodes/vertices... NB: assuming a bidrectional graph
const addEdges = (node1, node2) => {
  //to indicate a connection, set the value of the index to 1 where location on adjecencyMatrix[node1, node2]
  //adjacencyMatrix;
  adjacencyMatrix[vertexIndexes[node1]][vertexIndexes[node2]] = 1; // insert one where indexes of node1 and node2 two meet
  adjacencyMatrix[vertexIndexes[node2]][vertexIndexes[node1]] = 1; // and vice versa for an undirected graph
};

//note that teh above inline function couldn't be used before the function description
addEdges("A", "B");
addEdges("A", "D");
addEdges("B", "C");
addEdges("C", "D");
addEdges("C", "E");
addEdges("D", "E");

// find nodes connected to the given node
const findAdjacentNodes = (node) => {
  const adjacentNodes = [];

  // get the row of the current node
  // loop through the row
  // return index where value = 1 and push that node to the adjacentNodes list
  // or skip where value is not = 1
  for (let i = 0; i < vertices.length; i++) {
    nodeVertex = vertexIndexes[node];
    if (adjacencyMatrix[nodeVertex][i] === 1) {
      adjacentNodes.push(vertices[i]);
    }
  }

  return adjacentNodes;
};

// check if two nodes are adjacent/connected
const isConnected = (node1, node2) => {
  // in this case check the adjacencyMatrix using the indexes of the two nodes to determine if there is a value of 1 where they meet
  const node1Index = vertexIndexes[node1];
  const node2Index = vertexIndexes[node2];

  return adjacencyMatrix[node1Index][node2Index] === 1 ? true : false;
};

console.log(findAdjacentNodes("A"));
console.log(findAdjacentNodes("B"));
console.log(findAdjacentNodes("C"));
console.log(findAdjacentNodes("D"));
console.log(findAdjacentNodes("E"));

console.log(isConnected("B", "C"));
console.log(isConnected("A", "E"));
console.log(isConnected("B", "C"));
