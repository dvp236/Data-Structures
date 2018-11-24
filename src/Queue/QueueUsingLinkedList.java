package Queue;

import java.util.NoSuchElementException;

public class QueueUsingLinkedList {
	
	static class Node {
		int data;
		Node next;
		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	private Node head, tail;
	private int size;
	
	public QueueUsingLinkedList() {
		head = null;
		tail = null;
		size = 0;
	}

	public void enqueue(int data) {
		if(head == null) {
			head = new Node(data);
			tail = head;
			size++;
			return;
		}
		tail.next = new Node(data);
		tail = tail.next;
		size++;
	}
	
	public int dequeue() {
		if (head == null) throw new NoSuchElementException("queue empty");
		int data = head.data;
		head = head.next;
		size--;
		return data;
	}
	
	public int size() {
		return this.size;
	}
	
	public static void main(String[] args) {

		System.out.println("Jay Swaminarayan!!");
		QueueUsingLinkedList q = new QueueUsingLinkedList();
		q.enqueue(3);
		q.enqueue(4);
		q.enqueue(1);
		q.enqueue(2);
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println("sixe: "+q.size());
	}

}

