package Tree;


public class BinarySearchTree {
Node root;
	
	private class Node{
		int data;
		Node left;
		Node right;
		
		public Node(int data){
			this.data=data;
		}
		public int getData() {
			return data;
		}
		
		public Node getLeft() {
			return left;
		}
		public void setLeft(Node left) {
			this.left = left;
		}
		public Node getRight() {
			return right;
		}
		public void setRight(Node right) {
			this.right = right;
		}
		
	}
	private boolean isLeafNode(Node currentNode){
		return (currentNode.getLeft() == null && currentNode.getRight()==null);
	}
	public void insert(int data){
		Node newNode = new Node(data);
		if(root==null){
			root = newNode;
			return;
		}
		insertHelper(root,newNode);
	}
	
	private void insertHelper(Node currentNode,Node newNode){
		if(newNode.getData() < currentNode.getData()){
			
			if(currentNode.getLeft() == null){
				currentNode.setLeft(newNode);
			} else{
				currentNode = currentNode.getLeft();
				insertHelper(currentNode, newNode);
			}
		} else {
			
			if(currentNode.getRight() == null){
				currentNode.setRight(newNode);
			} else{
				currentNode = currentNode.getRight();
				insertHelper(currentNode, newNode);
			}
		}
	}
	
	public void inOrderTraversal(){
		inOrderTraversalHelper(root);
	}
	
	private void inOrderTraversalHelper(Node currentNode){
		if(currentNode !=null){
			inOrderTraversalHelper(currentNode.getLeft());
			System.out.println(currentNode.getData());
			inOrderTraversalHelper(currentNode.getRight());
		}
	}
	
	public void preOrderTraversal(){
		preOrderTraversalHelper(root);
	}
	
	private void preOrderTraversalHelper(Node currentNode){
		if(currentNode != null){
			System.out.println(currentNode.getData());
			preOrderTraversalHelper(currentNode.getLeft());
			preOrderTraversalHelper(currentNode.getRight());
		}
	}

}
