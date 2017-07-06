package bag;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 
 * @author dharmik
 * Inspiration: princeton algorithms.
 *
 */
public class Bag<Item> implements Iterable<Item>{
	private Node first;
	private int size;

	private static class Node<Item> {
		Node next ;
		Item item;	
	}
	
	public Bag(){
		first = null;
		size = 0;
	}
	
	//add item to bag
	public void add(Item item) {
		Node<Item> tempfirst = first;
		first = new Node<Item>();
		first.item = item;
		first.next = tempfirst;
		size++;
	}
	
	//check if bag is empty
	public boolean isEmpty() {
		return first == null;
	}
	
	//returns size of bag
	public int size() {
		return this.size;
	}
	
	//iterator of bag
	public Iterator<Item> iterator() {
		return new ListIteratorForBag<Item>(first);
	}
	
	private class ListIteratorForBag<Item> implements Iterator<Item> {
		Node<Item> current;
		
		public ListIteratorForBag(Node first) {
			current = first;
		}
		
		public boolean hasNext() {
			return current != null;
		}
		
		public void remove() { throw new UnsupportedOperationException(); }
		
		public Item next() {
			if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next; 
            return item;
		}
		
		
	}
	

	public static void main(String[] args) {
		
		Bag<String> sbag = new Bag<String>();
		System.out.println(sbag.isEmpty());
		sbag.add("dharmik");
		sbag.add("patel");
		sbag.add("family");
		sbag.add("bhumi");
		
		System.out.println(sbag.size());
//		Iterator<String> i = sbag.iterator();
//		while(i.hasNext()) {
//			System.out.println(i.next());
//		}
		System.out.println("------");
		for(String item : sbag) 
			System.out.println(item);
		
		
		

	}

}
