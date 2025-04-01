class Node {
  constructor(value) {
    this.value = value;
    this.edgesList = [];
  }

  connect(node) {
    this.edgesList.push(node);
    node.edgesList.push(this);
  }

  getAdjacentNodes() {
    return this.edgesList.map((edge) => edge.value);
  }

  isConnected(node) {
    return this.edgesList.map((edge) => edge.value).indexOf(node.value) > -1;
  }
}

class Graph {
  constructor(nodes) {
    this.nodes = nodes;
  }

  addToGraph(node) {
    this.nodes.push(node);
  }
}

const nodeA = new Node("A");
const nodeB = new Node("B");
const nodeC = new Node("C");
const nodeD = new Node("D");
const nodeE = new Node("E");

const nodesList = [];
nodesList.push(nodeA);
nodesList.push(nodeB);
nodesList.push(nodeC);
nodesList.push(nodeD);
nodesList.push(nodeE);

const graph = new Graph(nodesList);

// console.log("nodeA", nodeA);
// console.log("nodeB", nodeB);

// console.log(graph);

// connecting the vertices or nodes I.e. adding list of connected nodes to each node
nodeA.connect(nodeB);
nodeA.connect(nodeD);
nodeB.connect(nodeC);
nodeC.connect(nodeD);
nodeC.connect(nodeE);
nodeD.connect(nodeE);

// for (let node of graph.nodes) {
//   console.log(`Node ${node.value}`);
//   for (let connectedNode of node.edgesList) {
//     console.log(`Node ${node.value} is connected to ${connectedNode.value}`);
//   }
// }

console.log(nodeA.getAdjacentNodes());
console.log(nodeC.getAdjacentNodes());

console.log(nodeA.isConnected(nodeB));
console.log(nodeC.isConnected(nodeE));
console.log(nodeB.isConnected(nodeE));
