class Node {
  constructor(value) {
    this.value = value;
    this.left = null;
    this.right = null;
  }
}

/* Constructing a tree with the following structure
          3
        /   \
       2     7
     /   \    \
    4     -2   5

*/

// First create the nodes with above values
const node3 = new Node(3);
const node2 = new Node(2);
const node7 = new Node(7);
const node4 = new Node(4);
const nodeNeg2 = new Node(-2);
const node5 = new Node(5);

// Link each node to it's children

node3.left = node2;
node3.right = node7;

node2.left = node4;
node2.right = nodeNeg2;

node7.right = node5;

// Now traverse the entire tree using breadth first and sum each node.value as you go

// Remember that breadth first uses a queue
// Initialise the queue by putting in the root node
// Initiate a while loop that will continue until there is nothing to loop through in the queue array
// Start the breadth first search by extracting the first node from the queue
// Add the node's value to the total sum
// Check the current node's left and add it to the queue
// Check the current node's right and add it to the queue

const sumTree = (root) => {
  let totalSumTree = 0;
  const queue = [root];
  while (queue.length > 0) {
    const curr = queue.shift();
    totalSumTree += curr.value;
    if (curr.left !== null) {
      queue.push(curr.left);
    }
    if (curr.right !== null) {
      queue.push(curr.right);
    }
  }
  return totalSumTree;
};

console.log(sumTree(node3));
