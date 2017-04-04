package Queue;

import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.Stack;

/**
 * 
 * @author dharmik
 * Implement Queue using Two Stack
 */

public class QueueWithTwoStack<Item> {
	//One stach will be used to enque and one for dequeue
	private Stack<Item> in = new Stack();
	private Stack<Item> out = new Stack();
	
	public void enqueue(Item n){
		in.push(n);
	}
	
	public Item dequeue(){
		if(out.isEmpty()) refill();
		if(out.isEmpty()) throw new NoSuchElementException();
		return out.pop();
	}

	//here the stack will be reversed to have least recent items at top for other stack
	private void refill(){
		while(!in.isEmpty()) 
			out.push(in.pop());
	}
	
	public static void main(String[] args) {
		QueueWithTwoStack<Integer> q = new QueueWithTwoStack<Integer>();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
	}

}
