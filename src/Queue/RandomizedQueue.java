package Queue;

import java.util.Iterator;
import java.util.NoSuchElementException;


import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {
	private Item[] items;
	private int size;
	private int N = 2;
	
	public RandomizedQueue()   {
		// construct an empty randomized queue
		items = (Item[]) new Object[N];
		size = 0;

	}
	
	private class ArrayIterator<Item> implements Iterator<Item> {
		RandomizedQueue<Item> q = new RandomizedQueue<Item>();
		private int count;
		public ArrayIterator() {
			for(int i = 0; i < size; i++)
				q.enqueue((Item) items[i]);
			count = 0;
		}
		
		public boolean hasNext() {
			
			return count < size;
		}

		public Item next() {
			if(!hasNext()) throw new NoSuchElementException();
			count++;
			return q.dequeue();
		}
        
    	
		
	}
	
	public boolean isEmpty() {
		if (size == 0) {
			return true;
		}
		return false;
	}
	
	public int size() {
		// return the number of items on the queue
		return size;
	}
	
	public void enqueue(Item item)  {
		if (item == null) throw new NullPointerException();
		
		if ( size == N ) {
			resize(N*2);
		}
		
		items[size] = item;
		size++;
	}
	
	public Item dequeue()  {
		// remove and return a random item
		if (isEmpty()){
			throw new NoSuchElementException();	
		}
	
		int index = StdRandom.uniform(0, size);
			
		Item item = items[index];
		items[index] = null;
		swap(items,index,size-1);
		size--;
		
		if (size > 0 && size <= N/4) resize(N/2);
		
		return item;
	}
	
	private void swap(Item[] a, int i, int j) {
		Item temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public Item sample() {
		if (isEmpty()) throw new NoSuchElementException();
		// return (but do not remove) a random item
		int index = StdRandom.uniform(0, size);
		return items[index];
		
	}
	
	public Iterator<Item> iterator()  {
		// return an independent iterator over items in random order
		return new ArrayIterator<Item>();
	}
	
	private void resize(int newSize) {
			
		Item[] temp = (Item[]) new Object[newSize];
		for(int i = 0 ; i < size; i++) {
			temp[i] = items[i];	
		}
		
		items = temp;
		N = newSize;	
	}

	public static void main(String[] args) {
		RandomizedQueue<Integer> 	q = new RandomizedQueue<Integer>();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		q.enqueue(5);
		System.out.println("dq"+q.dequeue());

		System.out.println("dq"+q.dequeue());
		System.out.println("dq"+q.dequeue());
		System.out.println("dq"+q.dequeue());
	}
	
}