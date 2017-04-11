package Stack;

import java.util.NoSuchElementException;

public class StackWithMax extends Stack {
	//Maintain two stacks, one for min and one for max
	
	Stack minstack = new Stack();
	Stack maxstack = new Stack();
	
	
	public void push(int n) {
		if (super.isEmpty()) {
			super.push(n);
			minstack.push(n);
			maxstack.push(n);
			return;
		}
		//push only if it is max
		if ( n >= maxstack.peek()) {
			maxstack.push(n);
		}
		//push only if it is min then current
		if ( n <= minstack.peek() ) {
			minstack.push(n);
		}
		super.push(n);
	}
	
	public int pop(){
		if (super.isEmpty()) {
			throw new NoSuchElementException();
		}
		
		int result = super.pop();
		
		if ( result == maxstack.peek()) {
			maxstack.pop();
		}
		if ( result == minstack.peek() ) {
			minstack.pop();
		}
		
		return result;
	}
	
	public int getMax(){
		return maxstack.peek();
	}
	
	public int getMin(){
		return minstack.peek();
	}
	
	public static void main(String[] args) {
	// TODO Auto-generated method stub
	StackWithMax s = new StackWithMax();
	s.push(1);
	s.push(3);
	s.push(5);
	s.push(2);
	s.push(6);
	s.push(4);
	s.push(10);

	
	System.out.println(s.getMax());
	System.out.println(s.getMin());
	System.out.println(s.pop());
	System.out.println("-----");
	System.out.println(s.getMax());
	System.out.println(s.getMin());
	
		
	}

}
