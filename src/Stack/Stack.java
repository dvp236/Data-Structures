/**
 * This is a class that implements the stack API
 * 
 * @author dharmik
 *
 */
package Stack;

public class Stack {
	int top = -1;
	int[] arr;
	int size;
	// constructor to initialize the stack
	public Stack(int size) {
		this.size = size;
		arr = new int[this.size];
	}
	// resize stack;
	private void resize(int newSize) {
		this.size = newSize;
		int[] temp = new int[this.size];
		for (int i = 0; i <= top; i++) {
			temp[i] = arr[i];
		}
		this.arr = temp;
	}
	/**
	 * peek
	 * 
	 * @return
	 */
	public int peek() {
		if (!isEmpty())
			return arr[top];
		else
			return -1;
	}
	public boolean isEmpty() {
		return this.top == -1;
	}
	// Push an item
	public void push(int n) {
		/*
		 * if (top == (size - 1)) { System.out.println("Stack OverFlow :P");
		 * return; }
		 */
		if (top == this.size / 2) {
			resize(this.size * 2);
		}
		arr[++top] = n;
	}
	// pop an item
	/**
	 * 
	 * @return {@link Integer}
	 */
	public int pop() {
		if (top == -1) {
			System.out.println("Stack UnderFlow :P");
			return 0;
		}
		if (top == this.size / 4)
			this.resize(this.size / 2);
		return arr[top--];
	}
	// prints whole stack
	public void printStack() {
		if (top < 0) {
			return;
		}
		for (int i = 0; i <= top; i++) {
			System.out.println(arr[i]);
		}
	}
	// give current size of stack
	public void stackSize() {
		System.out.println("size:" + (top + 1));
	}
	// gives capacity of stack.
	public void capacity() {
		System.out.println("capacity: " + size);
	}
}

