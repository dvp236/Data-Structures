package Tree;


public class BinarySearchTree {
	Node root;
	
	//method to check if the node is leaf node or not
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
