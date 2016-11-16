package Stack;

//Stack LIFO
public class StackLList {
	Node top;
	
	private class Node{
		int data;
		Node next;
		
		public Node(int data){
			this.data = data;
		}
		
		public int getData() {
			return data;
		}
		public void setData(int data) {
			this.data = data;
		}
		public Node getNext() {
			return next;
		}
		public void setNext(Node next) {
			this.next = next;
		}
		
	}
	
	public void push(int data){
		Node newNode = new Node(data);
		newNode.setNext(top);
		top = newNode;
	}
	
	public void pop(){
		if(top != null && top.getNext() == null){
			top = null;
		}
		top = top.getNext();
	}
	
	public int peek(){
		if(top != null){
			return top.getData();
		}
		return 0;
	}
	
	public void printStack(){
		printHelp(top);		 
	}
	
	private void printHelp(Node currentNode){
		if (currentNode.getNext() == null ){
			 System.out.println(currentNode.getData());
		 }
		 else{
			 printHelp(currentNode.getNext());
			 System.out.println(currentNode.getData());
		 }
	}
	

}
