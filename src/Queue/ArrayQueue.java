package Queue;
/**
 * 
 * @author dharmik
 *	implement Circular Queue
 */
public class ArrayQueue {
	private int front;
	private int rear;
	private int[] arr;
	private int size;
	
	public ArrayQueue(int size){
		this.size = size;
		arr = new int[this.size];
		front = rear = -1;
	}
	
	public boolean isEmpty(){
		if(front == -1 && front == rear){
			return true;
		}
		return false;
	}
	
	public boolean isFull(){
		if((rear+1)%size == front){
			return true;
		}
		return false;
	}
	
	public void enQueue(int data){
		if(isFull()){
			System.out.println("Queue full");
			return;
		}
		
		rear = (rear+1)%size;
		arr[rear] = data;
		if(front == -1){
			front = rear ;
		}
		
	}
	
	public int deQueue(){
		if(isEmpty()){
			System.out.println("empty queue");
			return -1;
		}
		int data = arr[front];
		
		if(front == rear){
			front = rear = -1;

		}else{
			front = (front+1)%size;
		}
		
		return data;
	}
	
	public static void main(String[] args){
		ArrayQueue q = new ArrayQueue(5);
		q.enQueue(1);
		q.enQueue(2);
		System.out.println(q.deQueue());
		
		
	}
}
