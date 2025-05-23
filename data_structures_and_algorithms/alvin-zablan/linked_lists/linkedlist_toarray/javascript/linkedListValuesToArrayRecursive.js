// Function that traverses through the linked list and returns an array of all the linked list values
const linkedListToArrayRecursive = (head, nodeArray = []) => {
  if (head === null) return nodeArray;
  nodeArray = [...nodeArray, head.val];
  nodeArray = linkedListToArrayRecursive(head.next, nodeArray);
  return nodeArray;
};

class Node {
  constructor(val) {
    this.val = val;
    this.next = null;
  }
}

const a = new Node("A");
const b = new Node("B");
const c = new Node("C");
const d = new Node("D");

a.next = b;
b.next = c;
c.next = d;

console.log(linkedListToArrayRecursive(a));
