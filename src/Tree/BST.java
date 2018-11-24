package Tree;


import edu.princeton.cs.algs4.Queue;

/**
 * 
 * @author dharmik
 * An improved implementation.
 * Inspiration from Robert Sedgewick. 
 *
 */

public class BST<Key extends Comparable<Key>, Value> {
	BSTNode root;
	
	//Node
	private class BSTNode{
		BSTNode left, right;
		Key key;
		Value val;
		//Number of children of the node
		int size;
		
		public BSTNode(Key key, Value val, int size){
			this.key = key;
			this.val = val;
			this.size = size;
		}
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}
	public int size() {
		return size(root);
	}
	
	private int size(BSTNode node) {
		if (node == null) return 0;
		else return node.size;
	}
	
	public boolean contains(Key key) {
		if (key == null) throw new IllegalArgumentException("argument to contains() cant be null");
		return get(key) != null;
	}
	
	public Value get(Key key) {
		return get(root, key).val;
	}
	
	private BSTNode get(BSTNode node, Key key) {
		if (node == null) return null;
		int cmp = node.key.compareTo(key);
		if (cmp > 0)      return get(node.left, key);
		else if (cmp < 0) return get(node.right, key);
		else              return node;
	}
	
	public void put(Key key, Value val) {
		if (key == null) throw new IllegalArgumentException("first argument to put i.e key cant be null");
		root = put(root, key, val);
	}
	
	private BSTNode put(BSTNode node, Key key, Value val) {
		if(node == null) return new BSTNode(key, val, 1);
		
		int cmp = node.key.compareTo(key);
		if (cmp > 0) 	  node.left = put(node.left, key, val);
		else if (cmp < 0) node.right = put(node.right, key, val);
		else              node.val = val;
		node.size = 1 + size(node.left) + size(node.right);
		
		return node;
		
	}

	
	public Key min() {
		return min(root).key;
		
	}
	
	private BSTNode min(BSTNode node) {
		if(node.left == null) return node;
		else {
			return min(node.left);
		}
	}
	
	public void deleteMin() {
		root = deleteMin(root);
	}
	
	private BSTNode deleteMin(BSTNode node) {
		if (node.left == null) return node.right;
		node.left = deleteMin(node.left);
		
		return node;
	}
	
	public void deleteMax() {
		root = deleteMax(root);
	}
	
	private BSTNode deleteMax(BSTNode node) {
		if (node.right == null) return node.left;
		node.right = deleteMax(node.right);
		return node;
	}
	
	public void delete(Key key) {
		root = delete(root, key);
	}
	
	private BSTNode delete(BSTNode node, Key key) {
		if (node == null) return null;
		else {
			int cmp = node.key.compareTo(key);
			if (cmp > 0) node.left = delete(node.left, key);
			else if (cmp < 0) node.right = delete(node.right, key);
			else {
				if (node.left == null) return node.right;
				if (node.right == null) return node.left;
				BSTNode temp = node;
				node = min(temp.right);
				node.right = deleteMin(temp.right);
				node.left = temp.left;
				
			}
		}
		return node;
	}
	
//	 private BSTNode delete(BSTNode x, Key key) {
//	        if (x == null) return null;
//
//	        int cmp = key.compareTo(x.key);
//	        if      (cmp < 0) x.left  = delete(x.left,  key);
//	        else if (cmp > 0) x.right = delete(x.right, key);
//	        else { 
//	            if (x.right == null) return x.left;
//	            if (x.left  == null) return x.right;
//	            BSTNode t = x;
//	            x = min(t.right);
//	            x.right = deleteMin(t.right);
//	            x.left = t.left;
//	        } 
//	        x.size = size(x.left) + size(x.right) + 1;
//	        return x;
//	    } 
	
	public void printInOrder() {
	
		printh(root);
	}
	
	private void printh(BSTNode node) {
		if(node == null) return;
		printh(node.left);
		System.out.print(node.key+" ");
		printh(node.right);
	}
	public Iterable<Key> printLevelOrder() {
		Queue<Key> keys = new Queue<Key>();
        Queue<BSTNode> queue = new Queue<BSTNode>();
        queue.enqueue(root);
        while (!queue.isEmpty()) {
            BSTNode x = queue.dequeue();
            if (x == null) continue;
            keys.enqueue(x.key);
            queue.enqueue(x.left);
            queue.enqueue(x.right);
        }
        return keys;
		
	}
	
	public static void main(String[] args) {
		BST<Integer, String> tree = new BST<Integer, String>();
		tree.put(5, "dharam");
		tree.put(2, "dhardam");

		tree.put(4, "dharsdfam");

		tree.put(3, "dharsfadam");
		tree.put(8, "dharsfadsfam");
		tree.put(1, "dharsfaam");
		tree.put(11, "dhaadfsram");
		tree.put(10, "adfas");
		tree.printInOrder();
		tree.delete(5);
		tree.printInOrder();


	}
	

}
