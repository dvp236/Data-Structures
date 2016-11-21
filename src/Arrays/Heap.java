package Arrays;

import java.util.Arrays;

/**
 * 
 * @author dharmik
 * Implementation of Heap Data structure
 *
 */
public class Heap {
	private static final int CAPACITY = 4;
	
	private int size;
	private int[] heap;
	
	public Heap(){
		this.size = CAPACITY;
		heap= new int[this.size];
	}
	
	public void doubleSize(){
		int[] old = heap;
	    heap = new int[heap.length * 2];
	    System.arraycopy(old, 1, heap, 1, size);
	}
	
	private void percolatingDown(int k){
	      int tmp = heap[k];
	      int child;

	      for(; 2*k <= size; k = child)
	      {
	         child = 2*k;

	         if(child != size &&
	            heap[child]>heap[child + 1]) child++;

	         if(tmp > heap[child])  heap[k] = heap[child];
	         else
	                break;
	      } 
	      heap[k] = tmp;
	   }

	 public void insert(int x){
	      if(size == heap.length - 1) doubleSize();

	      //Insert a new item to the end of the array
	      int pos = ++size;

	      //Percolate up
	      for(; pos > 1 && x < heap[pos/2] ; pos = pos/2 )
	         heap[pos] = heap[pos/2];

	      heap[pos] = x;
	   }
	
	
	public void printHeap(int[] a){
		System.out.println(Arrays.toString(a));
	}
	
	
	
	public static void main(String[] args){
		
	}
}
