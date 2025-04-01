package dinesh_varyani.binary_trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
  private TreeNode root;

  private class TreeNode{
    private int data;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(int data){
      this.data = data;
    }
  }
  
  public void createBinaryTree(){
    // first we create the nodes
    TreeNode first = new TreeNode(1);
    TreeNode second = new TreeNode(2);
    TreeNode third = new TreeNode(3);
    TreeNode fourth = new TreeNode(4);
    TreeNode fifth = new TreeNode(5);

    // then we assign each node with it's branches to other nodes
    root = first;       // root ---> first
    first.left = second;
    first.right = third;// second <--- first ---> third

    second.left = fourth;
    second.right = fifth; // 

    /*
     *            1
     *          /   \
     *         2     3
     *        / \    
     *      4    5
     */


  }
  // // In order binary tree iterative traversal
  // public void inOrderStackTreeTraversal(TreeNode root){
  //   Stack<TreeNode> inOrderNodeStack = new Stack<>();
  //   inOrderNodeStack.push(root);
  //   while(inOrderNodeStack.size() != 0){
  //     TreeNode currNode = inOrderNodeStack.pop();

  //     if(currNode.right != null){
  //       inOrderNodeStack.push(currNode.right);
  //     }
      
  //     if(currNode.left != null){
  //       inOrderNodeStack.push(currNode.left);
  //     }

  //     System.out.print(currNode.data + " "); //Printing out the node value after the left node but before the right node
  //   }
  // }

  // In order binary tree recursive traversal
  public void inOrderRecursiveTraversal(TreeNode root){
    if(root == null){
      return;
    }
    
    inOrderRecursiveTraversal(root.left);
    System.out.println(root.data);
    inOrderRecursiveTraversal(root.right);
    
  }

  // Pre order traversal Using recursion
  public void preOrderTreeTraversal(TreeNode root){ // recursive traversal
    if(root == null){
      return;
    }
    System.out.print(root.data + " ");
    preOrderTreeTraversal(root.left);
    preOrderTreeTraversal(root.right);
  }

  // Iterative approach using a stack
  /* Remember that in a stack you push the values you don't want to use immediately into the stack first
   * What goes in first comes out last. So, in each push to the stack, start with the right node because it must be processed
   * last in preOrder traversal
   */
  public void preOrderStackTreeTraversal(TreeNode root){ // iterative traversal
    if(root == null){
      return;
    }
    // create the stack
    Stack<TreeNode> treeNodeStack = new Stack<>();
    // insert the first/root node into the stack
    treeNodeStack.push(root);

    while(!treeNodeStack.isEmpty()){
      // pop the node at the top of the stack
      TreeNode currNode = treeNodeStack.pop();
      System.out.print(currNode.data + " ");
      if(currNode.right != null){// remember we start with the right side so that it can be handled last
        treeNodeStack.push(currNode.right);
      }
      if(currNode.left != null){
        treeNodeStack.push(currNode.left);
      }
    }
  }
  public void breadthFirstTraversal(TreeNode root){
    Queue<TreeNode> nodeQueue = new LinkedList<>();
    nodeQueue.add(root);

    while( nodeQueue.size() > 0 ){
      TreeNode currNode = nodeQueue.poll();
      System.out.print(currNode.data + " ");

      if(currNode.left != null){
        nodeQueue.add(currNode.left);
      }
      if(currNode.right != null){
        nodeQueue.add(currNode.right);
      }
    }
  }

  public static void main(String[] args) {
    BinaryTree binaryTree = new BinaryTree();
    System.out.println("Creating binary tree...");
    binaryTree.createBinaryTree();
    
    // System.out.println("PreOrder tree traversal using recursion");
    // binaryTree.preOrderTreeTraversal(binaryTree.root);

    // System.out.println("\nIterative PreOrder tree traversal using a stack data structure");
    // binaryTree.preOrderStackTreeTraversal(binaryTree.root);
    
    // System.out.println("\nBreadth first tree traversal iteratively using a queue");    
    // binaryTree.breadthFirstTraversal(binaryTree.root);

    // System.out.println("\nIn Order tree traversal iteratively using a stack");    
    // binaryTree.inOrderStackTreeTraversal(binaryTree.root);

    System.out.println("\nIn Order tree traversal recursively");    
    binaryTree.inOrderRecursiveTraversal(binaryTree.root);
  }
}
