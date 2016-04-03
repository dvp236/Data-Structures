package LinkedList;


/**
 * 
 * @author dharmik
 *	Implement Doubly Linked List
 */
public class DbLinkedList {
	Node head,tail;
	private int lenOfList = 0;
	
	private class Node {
		//pointer to next node
		Node right,left;
		int data;
		
		public Node(int data){
			this.data = data;
			this.right = null;
			this.left = null;
		}
		
		public void setData(int data){
			this.data = data;
		}
		
		public int getData(){
			return this.data;
		}
		
		public void setLeft(Node newNode){
			this.left = newNode;
		}
		
		public void setRight(Node newNode){
			this.right = newNode;
		}
		
		public Node getLeft(){
			return this.left;
		}
		
		public Node getRight(){
			return this.right;
		}
		
	}
	
	public void insert(int n){
		Node newNode = new Node(n);
		if(head == null){
			head = newNode;
			tail = newNode;
			lenOfList++;
			return;
		}
		
		tail.setLeft(newNode);
		tail = newNode;
		lenOfList++;
		
	}
	
	public void printList(){
		Node curr = head;
		while(curr != null){
			System.out.println(curr.getData());
			curr = curr.getLeft();
		}
	}
	
	
}
