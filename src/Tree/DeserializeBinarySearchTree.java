package Tree;

import java.util.StringTokenizer;

public class DeserializeBinarySearchTree {
	public Node deserialize(String st){
		StringTokenizer s = new StringTokenizer(st," ");
		
		return deserializeHelper(s);
	}
	
	
	private Node deserializeHelper(StringTokenizer st){
	    if (!st.hasMoreTokens())
	        return null;
	    String val = st.nextToken();
	    Node  root = new Node(Integer.parseInt(val));
	    root.setLeft(deserializeHelper(st));
	    root.setRight(deserializeHelper(st));
	    return root;
	}
}

