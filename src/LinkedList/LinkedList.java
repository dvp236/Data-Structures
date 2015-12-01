package LinkedList;

public class LinkedList {

	Node head;
	Node tail;
	int len = 0;

	private class Node {
		Node next;
		int data;
		
		public Node(int data){
			this.data = data;
		}
		
		public void setData(int data){
			this.data = data;
		}
		
		public int getData(){
			return this.data;
		}
		
		public void setNext(Node newNode){
			this.next = newNode;
		}
		
		public Node getNext(){
			return this.next;
		}
	
	}
	public void add(int data){
		Node newNode =new Node(data);
		if(isEmpty()){
			head = newNode;
			tail = newNode;
			len++;
			return;
		}
		tail.setNext(newNode);
		tail = newNode;	
		len++;
	}
	
	public int get(int index){
		if(isEmpty()){
			return 0;
		}
		if(index < 0 || index > (len-1)){
			System.out.println("Not supported");
			return 0;
		}
		Node currentNode = getNode(index);
		return currentNode.getData();
		
	}
	
	private Node getNode(int index){
		if(index < 0 || index > (len-1)){
			System.out.println("Not supported");
			return null;
		}
		Node currentNode = head;
		int cnt = 0;
		while(cnt != index){
			currentNode = currentNode.getNext();
			cnt++;
		}
		return currentNode;
	}
	
	
	public void remove(int index){
		if(isEmpty()){
			System.out.println("No elements to remove");
		}
		if(index < 0 || index >= len){
			System.out.println("Not supported");
			return;
		}
		if(index == 0){
			Node currentNode = head.getNext();
			head = currentNode;
			len--;
			return;
		}
		Node prevNode = getNode(index-1);
		Node currentNode = prevNode.getNext();
		Node nextNode = currentNode.getNext();
		
		prevNode.setNext(nextNode);
		len--;
		
	}
	
	public void addAtIndex(int data, int index){
		if(index < 0 || index > len){
			System.out.println("Not supported");
			return;
		}
		if(index==len){
			add(data);
			return;
		}
		len++;
		if(index == 0){
			Node newNode= new Node(data);
			newNode.setNext(head);
			head = newNode;
			return;
		}
		Node newNode = new Node(data);
		Node prevNode = getNode(index-1);
		Node nextNode = prevNode.getNext();
		prevNode.setNext(newNode);
		newNode.setNext(nextNode);
		
	}
	
	private boolean isEmpty(){
		return (head==null);
	}
	
	public void printList(){
		Node currentNode = head;
		System.out.println("Length of list: "+len);
		while(currentNode != null){
			System.out.println(currentNode.getData());
			currentNode = currentNode.getNext();
		}
	}
	
}
