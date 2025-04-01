package ch02_linked_lists;

import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

public class LinkedListNode {
  private Node head;
  private int size;

  public LinkedListNode() {
      this.head = null;
      size = 0;
  }

  public void removeDuplicates(LinkedListNode linkedList){
    HashSet<Integer> nodeHashset = new HashSet<Integer>();
    // Let's iterate through this list. Everytime a duplicate is found. We delete the node. 
    // Duplicates are identified by adding each item to a Hashset. If item is already in the set then delete from linkedlist
    
    Node curr = linkedList.head; 
    Node prev = null;

    List<Integer> removalList = new ArrayList<Integer>();

    while(curr.next != null){ //let's traverse the list of nodes
      if(nodeHashset.contains(curr.data)){ //if node already exists in the Hashset then remove the duplicate node from the list
        // remove node
        System.out.println("Already have: " + curr.data);
        prev.next = curr.next;
        curr = curr.next;
        size--;
        
      }else{
        nodeHashset.add(curr.data);
        prev =  curr;
        curr = curr.next;
      }  
      
    }
    // System.out.println(removalList); 
  }

  /*
   *if the index can't possibly point to anything in the linkedlist then return -1
   *set node to the head node
   *traverse the nodes in the list for the count of the specified index
   *return the data of the node at the specified index
  */
  public int get(int index){
    if(index > size || index < 0) return -1;
    Node node = head; 
    for(int i=0; i<index; i++) node = node.next;

    return node == null? -1 : node.data;
  }

  //method to add to the beginning of the linked list
  public void addAtHead(int data){
    Node node = new Node(data);         //create the new node
    node.next = head;                   //add the head node as the next element of the new node
    head = node;                        //assign the head pointer to the new node
    size++;
  }

  //method to add to the end of the linked list
  public void addAtTail(int data){ 
    //if the list is still empty then simply create a new node at the head node position
    if(isEmpty()){
      head = new Node(data);
      size++;
      return;
    }

    /*
     *create a temp or dummy node and assign it to the beginning of the linked list
     *traverse the linked list starting from the dummy. Stop when you reach a node with a next of null. I.e. the last node
     *now that temp points to the last node we can add a new node to that last node
     *don't forget to increment the size of linkedlist
    */
    Node temp = head;
    while(temp.next != null) temp = temp.next;
    temp.next = new Node(data);
   
    size++;
  }

  public void removeNodeAtIndex(int index){
    if(index < size || index > 0){
      Node node = head;
      // Node temp = null; 
      for(int i=0; i<index-1; i++){ 
        node = node.next;
      }
      System.out.println("Deleting node...: " + node.next.data);
      node.next = node.next.next;
      size--;
    }
  }

  public boolean isEmpty(){
    return head == null;
  }

  @Override
  public String toString() {
    Node temp = head;
    String fullList = "";
    while(temp != null){
      fullList += temp.data + " ";
      temp = temp.next;
    }

    return fullList  + "....and the size of the list is: " + this.size;
  }

  
}
