class Node {
  constructor(value) {
    this.value = value;
    this.left = null;
    this.right = null;
  }
}

const nodeA = new Node("A");
const nodeB = new Node("B");
const nodeC = new Node("C");
const nodeD = new Node("D");
const nodeE = new Node("E");
const nodeF = new Node("F");

// Tree structure
/*          A
          /   \
         B     C
       /   \     \
      D     E     F
*/

nodeA.left = nodeB;
nodeA.right = nodeC;

nodeB.left = nodeD;
nodeB.right = nodeE;

nodeC.right = nodeF;

// breadth first search traverses the tree by level. Starts from the top going left to right. I.e. A...B,C...D,E,F
// we accomplish this traversal using a queue. I.e.
// starting with nodeA in the queue (the root node)
// visit nodeA or take it from the queue, print the value of nodeA
// check if nodeA has a left node. If yes, add that node to the queue.
// check if nodeA has a left node. If yes, add that node to the queue.
// return to the queue and grab the next node in line and repeat the above process

const breadthFirstSearch = (root) => {
  const queue = [root];
  while (queue.length > 0) {
    const curr = queue.shift();
    console.log(curr.value);
    if (curr.left !== null) {
      queue.push(curr.left);
    }
    if (curr.right !== null) {
      queue.push(curr.right);
    }
  }
};

breadthFirstSearch(nodeA);

/* Exercise: Write a function bfs(root, target) that takes in the root of a tree and the target value as arguments
   The tree should return a boolean value indicating whether or not the tree contains the target value
*/

// Traverse the tree using breadth first search principles and indicate when the target value is found.
// I.e. return true as soon as value == target or return false.

const bfs = (root, target) => {
  const queue = [root];
  while (queue.length > 0) {
    const curr = queue.shift();
    if (curr.value === target) {
      return true;
    }

    if (curr.left !== null) {
      queue.push(curr.left);
    }
    if (curr.right !== null) {
      queue.push(curr.right);
    }
  }
  return false;
};

console.log(bfs(nodeB, "F"));
