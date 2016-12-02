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
	
	private void buildHeap(){
		for(int k=size/2; k>0; k--){
			percolateDown(k);
		}
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

	      //percolate up
	     while(pos > 1 && x < getParent(pos)){
	    	  heap[pos] = getParent(pos);
	    	  pos = pos/2;
	      }
	      
	      heap[pos] = x;
	      
	    
	 }
	
	 private void percolateDown(int pos){
		 int tmp = heap[pos];
		 int child;
		 while(2*pos < size ){
			 child = 2*pos;
			 if(heap[child] > heap[child+1]) child++;
			 
			 if(tmp > heap[child]) heap[pos] = heap[child];
			 else break;
			 
			 pos = child;
		 }
		 
		 heap[pos] = tmp;
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
		for(int i=1; i<=size; i++){
			System.out.print(heap[i]+" ");
		}
		System.out.println();
	}
	
	
	
	public static void main(String[] args){
		Heap h = new Heap();
	}
}
