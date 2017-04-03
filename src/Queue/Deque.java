package Queue;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
	private Node head;
	private Node tail;
	private int size;
	public Deque()  {
	    // construct an empty deque
		head = null;
		tail = null;
		size = 0;
		
		
    }
	
	private class Node {
		private Node prev;
		private Node next;
		private Item item;
		
		public Node(Item item) {
			this.item = item;
			prev = null;
			next = null;
		}
			
	}
	
	private class ListIterator implements Iterator<Item> {
		
		private Node current = head;
		
		public boolean hasNext() {
			return current != null;
		}

		public Item next() {
			if (!hasNext()) throw new NoSuchElementException();
			Item item = current.item;
			current = current.next;
			return item;
		}
		
	}
	
	
	
	
    public boolean isEmpty()  {
	    // is the deque empty?
    	if (size == 0) {
    		return true;
    	}
    	
	    return false;
    }
    
    public int size()  {
	    // return the number of items on the deque
	    return size;
    }
    
    public void addFirst(Item item)  {
    	if (item == null) throw new NullPointerException();
    	Node newNode = new Node(item);
    	
	    // add the item to the front
    	if (isEmpty()) {
    		head = newNode;
    		tail = newNode;
    		size++;
    		return;
    	}
    	
        newNode.next = head;
    	head.prev = newNode;
    	head = newNode;
    	size++;
    	
    }
    
    public void addLast(Item item)   {

        if (item == null) throw new NullPointerException();
 	    // add the item to the end
    	Node newNode = new Node(item);
    	if (isEmpty()) {
    		head = newNode;
    		tail = newNode;
    		size++;
    		return;
    	}
    	
    	tail.next= newNode;
    	newNode.prev = tail;
    	tail = newNode;
    	size++;
    	
    }
    
    public Item removeFirst()   {
    	
	    // remove and return the item from the front
    	if (isEmpty()) {
    		throw new NoSuchElementException();
    	}
    	
    	Item item = head.item;
    	head = head.next;
    	if (head != null) {
            head.prev = null;
        } else {
            tail = null;
        }
    	size--;
	    return item;
    }
    
    public Item removeLast() {
	    // remove and return the item from the end
    	if (isEmpty()) {
    		throw new NoSuchElementException();
    	}
    	
    	Item item = tail.item;
    	tail = tail.prev;
    	if (tail != null) {
            tail.next = null;
        } else {
            head = null; 
        }
    	
    	size--;
	    return item;
	   
    }
    
    public Iterator<Item> iterator() {
    	return new ListIterator();
   	
    }
   

}
