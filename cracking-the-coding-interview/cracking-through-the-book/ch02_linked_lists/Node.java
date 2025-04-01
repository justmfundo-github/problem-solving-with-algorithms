package ch02_linked_lists;

public class Node {
  int data;
  Node next;
  
  public Node(int data){
    this.data = data;
    this.next = null;
  }

  public void add(Node currentNode, int data){
    Node newNode = new Node(data);
    currentNode.next = newNode;
  }
}
