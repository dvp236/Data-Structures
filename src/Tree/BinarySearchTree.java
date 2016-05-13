package Tree;


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
