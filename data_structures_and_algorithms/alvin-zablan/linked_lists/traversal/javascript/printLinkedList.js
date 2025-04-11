// Function to print the linked list
const printLinkedList = (head) => {
  let current = head;

  while (current !== null) {
    console.log(current.val);
    current = current.next;
  }
};

// We need a node object/class to work with
class Node {
  constructor(val) {
    this.val = val;
    this.next = null;
  }
}

// Creating some nodes
const a = new Node("A");
const b = new Node("B");
const c = new Node("C");
const d = new Node("D");

// Linking the nodes
a.next = b;
b.next = c;
c.next = d;

printLinkedList(a);
