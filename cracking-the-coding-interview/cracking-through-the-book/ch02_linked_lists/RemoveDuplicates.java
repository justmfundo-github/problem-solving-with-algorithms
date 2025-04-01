package ch02_linked_lists;

public class RemoveDuplicates{
  public static void main(String[] args) {
    LinkedListNode linkedList = new LinkedListNode();

    //adding values to the tail of the list
    linkedList.addAtTail(3);
    linkedList.addAtTail(5);
    linkedList.addAtTail(7);
    linkedList.addAtTail(9);
    linkedList.addAtTail(9);
    linkedList.addAtTail(11);
    linkedList.addAtTail(24);
    linkedList.addAtTail(17);
    linkedList.addAtTail(19);

    //adding values to the front/head of the list
    linkedList.addAtHead(1);
    linkedList.addAtHead(5);
    linkedList.addAtHead(4);
    linkedList.addAtHead(17);

    //linkedList.removeNodeAtIndex(2);

    System.out.println("With Duplicates..." + linkedList);

    //linkedList.removeNodeAtIndex(2);

    linkedList.removeDuplicates(linkedList);

    System.out.println("WithOut!! Duplicates..." + linkedList);
  }

}