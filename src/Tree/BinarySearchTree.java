package Tree;

import java.util.HashMap;

public class BinarySearchTree {
	Node root;
	
	//method to check if the node is leaf node or not
	private boolean isLeafNode(Node currentNode){
		return (currentNode.getLeft() == null && currentNode.getRight()==null);
	}
	
	//insert data into Tree
	public void insert(int data){
		Node newNode = new Node(data);
		if(root==null){
			root = newNode;
			return;
		}
		insertHelper(root,newNode);
	}
	
	private void insertHelper(Node currentNode,Node newNode){
		//check if data is smaller than current Node's data
		//if this is true than new node belongs to left of 
		//this node
		if(newNode.getData() < currentNode.getData()){
			//if the current node does not have left child
			//then set new node to be its left child
			if(currentNode.getLeft() == null){
				currentNode.setLeft(newNode);
			} else{
				//else we should keep looking for right place 
				//for our new node. Since we have determined new
				//node belongs to left sub tree we will call this 
				//method recursively this time passing left node.
				currentNode = currentNode.getLeft();
				insertHelper(currentNode, newNode);
			}
		} else {
			//if the node data is greater than current node's data
			//we will look for right side of the tree
			//if the node does not have right node then just 
			//set its right to be new node
			if(currentNode.getRight() == null){
				currentNode.setRight(newNode);
			} else{
				//if that is not the case then recursively call again
				//with current node as right child 
				currentNode = currentNode.getRight();
				insertHelper(currentNode, newNode);
			}
		}
	}
	
	//Remove the node from the tree
	public void remove(int data){
		Node currentNode,replacementNode;
		if(root.data==data){
			if(root.getRight() == null){
				currentNode = root.getLeft();
				root.setLeft(null);
				root = currentNode;
				return;
			}
			replacementNode = getReplacementNode(root);
			replacementNode.setLeft(root.left);
			replacementNode.setRight(root.right);
			root = replacementNode;
			return;
		}
		
		
		Node parent=root;
		currentNode = root;
		boolean isLeftChild = false;
		while(currentNode.data != data){
			parent = currentNode;
			if(data > currentNode.data) {
				currentNode = currentNode.getRight();
				isLeftChild = false;
			}else{
				currentNode = currentNode.getLeft();
				isLeftChild = true;
			}
			
			if(currentNode == null){
				System.out.println("Node does not exist");
				return;
			}
		}
		
		System.out.println("current" +currentNode.data+"  isleft"+isLeftChild);
		
		if(isLeafNode(currentNode)){
			if(isLeftChild) parent.setLeft(null);
			else parent.setRight(null);
			return;
		}
		
		replacementNode = getReplacementNode(currentNode);
		System.out.println("replacement "+replacementNode.data);
		if(isLeftChild) parent.setLeft(replacementNode);
		else parent.setRight(replacementNode);
		
		replacementNode.setLeft(currentNode.left);
		replacementNode.setRight(currentNode.right);
		
	}
	
	private Node getReplacementNode(Node node){
		Node currentNode = node, parent = node;
		if(currentNode.getRight()!= null){
			currentNode = currentNode.getRight();
		}
		if(currentNode.getLeft() == null){
			parent.setRight(null);
			return currentNode;
		}
		while(currentNode.getLeft() != null){
			parent = currentNode;
			currentNode = currentNode.getLeft();
		}
		parent.setLeft(currentNode.right);
		return currentNode;
	}
	
	//Inoder Traversal of the tree. 
	//Remark: It gives tree data in sorted order always.
	public void inOrderTraversal(){
		inOrderTraversalHelper(root);
	}
	
	private void inOrderTraversalHelper(Node currentNode){
		if(currentNode !=null){
			inOrderTraversalHelper(currentNode.getLeft());
			System.out.print(currentNode.getData()+" ");
			inOrderTraversalHelper(currentNode.getRight());
		}
	}
	
	//PreOrder traversal of the tree
	public void preOrderTraversal(){
		preOrderTraversalHelper(root);
	}
	
	private void preOrderTraversalHelper(Node currentNode){
		if(currentNode != null){
			System.out.print(currentNode.getData()+" ");
			preOrderTraversalHelper(currentNode.getLeft());
			preOrderTraversalHelper(currentNode.getRight());
		}
	}
	
	//Method to find min value from the tree.
	//it is value that resides in the left most leaf node.
	public int findmin(){
		int min = findmin(root);
		return min;
	}
	private int findmin(Node node){
		if(node.getLeft()==null){
			return node.getData();
		}
		else{
			return findmin(node.getLeft());
		}
		
	}
	
	//Method to find the max value from the tree 
	//it is the data of the right most leaf node
	public int findmax(){
		int max = findmax(root);
		return max;
	}
	
	private int findmax(Node node){
		if(node.getRight()==null){
			return node.getData();
		}else{
			return findmax(node.getRight());
		}
	}
	
	//Method to get the height of the tree
	public int getHeight(){
		return getHeighthelper(root);
	}
	
	private int getHeighthelper(Node node){
		if(node == null){
			return 0;
		}
		return Math.max(getHeighthelper(node.getLeft()), getHeighthelper(node.getRight()))+ 1;
	
	}
	

}
