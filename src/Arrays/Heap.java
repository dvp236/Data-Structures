package Arrays;

import java.util.Arrays;

/**
 * 
 * @author dharmik
 * Implementation of Heap Data structure
 *
 */
public class Heap {
	private static final int CAPACITY = 2;
	
	private int size;
	private int[] heap;
	
	public Heap(){
		this.size = 0;
		heap= new int[CAPACITY];
	}
	
	public void doubleSize(){
		int[] old = heap;
	    heap = new int[heap.length * 2];
	    System.arraycopy(old, 1, heap, 1, size);
	}
	
	public void insert(int x){
	      if(size == heap.length - 1) doubleSize();

	      //Insert a new item to the end of the array
	      int pos = ++size;

	      //percolating up
	     while(pos > 1 && x < getParent(pos)){
	    	  heap[pos] = getParent(pos);
	    	  pos = pos/2;
	      }
	      
	      heap[pos] = x;
	      
	    
	 }
	 
	 public void percolateDown(int pos){

	 }
	 
	 public int deleteMin(){
		 int min = heap[1];
		 heap[1] = heap[size--];
		 percolateDown(1);
		 return min;
	 }
	
	 public int getParent(int pos){
		 return heap[pos/2];
	 }
	
	public void printHeap(){
		System.out.println(Arrays.toString(heap));
	}
	
	
	
	public static void main(String[] args){
		Heap h = new Heap();
		h.insert(5);
		h.insert(4);
		h.insert(1);
		h.insert(6);
		h.insert(0);
		h.printHeap();
	}
}
