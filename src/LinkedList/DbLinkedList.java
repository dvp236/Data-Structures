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
		
		tail.setRight(newNode);
		newNode.setLeft(tail);
		tail = newNode;
		lenOfList++;
		
	}
	
	public void addAtIndex(int data, int index){
		Node next = getNode(index);
		Node prev = next.getLeft();
		Node newNode = new Node(data);
		prev.setRight(newNode);
		newNode.setLeft(prev);
		newNode.setRight(next);
		
	}
	
	private Node getNode(int index){
		int cnt= 0;
		Node curr = head;
		while(cnt != index){
			curr = curr.getRight();
			cnt++;
		}
		return curr;
	}
	
	public void printList(){
		Node curr = head;
		while(curr != null){
			System.out.println(curr.getData());
			curr = curr.getRight();
		}
	}
	
	
}
