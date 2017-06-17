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
	
	private class BSTNode{
		BSTNode left, right;
		Key key;
		Value val;
		int size;
		
		public BSTNode(Key key, Value val, int size){
			key = this.key;
			val = this.val;
			size = this.size;
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
		return get(root, key);
	}
	
	private Value get(BSTNode node, Key key) {
		if (node == null) return null;
		int cmp = node.key.compareTo(key);
		if (cmp > 0)      return get(node.left, key);
		else if (cmp < 0) return get(node.right, key);
		else              return node.val;
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
	
	public Iterable<Key> printOrder() {
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
	

}
