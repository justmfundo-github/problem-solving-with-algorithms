/*
  Preorder, inorder, and postorder are all tree traversal algorithms that differ in the order in which they 
  visit each node in a tree:

  Inorder
    Visits the left subtree, then the root node, and finally the right subtree. This algorithm is useful for sorting values.
  Preorder
    Visits the root node, then the left subtree, and finally the right subtree. This algorithm is useful for copying trees.
  Postorder
    Visits the left subtree, then the right subtree, and finally the root node. This algorithm is useful for deleting trees. 
  
  All three algorithms are depth-first search (DFS) strategies that explore down a path fully. 
  The only difference between them is the order in which they use the current node's data.
*/

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

// Depth first search starts by choosing a side, either left or right. Then traverse the tree going down a side
// as deeply as the tree allows. A-->B-->D
// Then do the same on the other side. I.e. if you started left, then go right after going as far as you can go on the left

const depthFirstIterativePrint = (root) => {
  const stack = [root];

  while (stack.length > 0) {
    const curr = stack.pop();
    console.log(curr.value);

    if (curr.right !== null) {
      stack.push(curr.right);
    }
    if (curr.left !== null) {
      stack.push(curr.left);
    }
  }
};

// console.log("Depth First ITERATIVE printing: ");
// depthFirstIterativePrint(nodeA);

/* ----------------------------------------------------------function--------------------------------------------------- */
// The above depthFirstIterativePrint can also be accomplished recursively. By their nature, recursive calls
// happen in a stack way.
const depthFirstRecursivePrint = (root) => {
  // if the tree is empty just return
  if (root === null) {
    return;
  }

  console.log(root.value);

  depthFirstRecursivePrint(root.left); // keep processing left until there aren't any more left nodes
  depthFirstRecursivePrint(root.right); // then process right
};

// console.log("Depth First RECURSIVE printing: ");
// depthFirstRecursivePrint(nodeA);

/* ----------------------------------------------------------function--------------------------------------------------- */
// Pre order traversal is essentially depth first traversal while taking care to print the value of
// node before it's childrend:
// parent node <---and then---> left child node <---and then---> right child node
// self --> left --> right

const preOrderDepthFirstRecursivePrint = (root) => {
  // if the tree is empty just return
  if (root === null) {
    return;
  }

  console.log(root.value);

  preOrderDepthFirstRecursivePrint(root.left); // keep processing left until there aren't any more left
  preOrderDepthFirstRecursivePrint(root.right); // then process right
};

console.log("PRE ORDER depth First recursive printing: ");
preOrderDepthFirstRecursivePrint(nodeA);

/* ----------------------------------------------------------function--------------------------------------------------- */
// Post order traversal is essentially depth first traversal while taking care to print the value of
// children nodes before the parents. I.e bottom up
// left child node <---and then---> right child node <---and then---> parent node
// left ---> right ---> self
const postOrderDepthFirstRecursivePrint = (root) => {
  // if the tree is empty just return
  if (root === null) {
    return;
  }

  postOrderDepthFirstRecursivePrint(root.left);
  postOrderDepthFirstRecursivePrint(root.right);
  // Mind where you put the print out log because it determines post order printing
  console.log(root.value);
};

console.log("POST ORDER depth First recursive printing: ");
postOrderDepthFirstRecursivePrint(nodeA);

/* ----------------------------------------------------------function--------------------------------------------------- */
// In order traversal is essentially depth first traversal while taking care to print the value of
// left child node <---and then---> parent node <---and then---> right child node
// left ---> self ---> right
const inOrderDepthFirstRecursivePrint = (root) => {
  // if the tree is empty just return
  if (root === null) {
    return;
  }

  inOrderDepthFirstRecursivePrint(root.left);
  // Mind where you put the print out log because it determines in order printing
  console.log(root.value);
  inOrderDepthFirstRecursivePrint(root.right);
};

console.log("IN ORDER depth First recursive printing: ");
inOrderDepthFirstRecursivePrint(nodeA);
