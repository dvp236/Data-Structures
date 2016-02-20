package Tree;

public class ValidateBinarySearchTree {
	public boolean isBinarySearchTree(Node root){
		return isBSTHelper(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
				
	}
	private boolean isBSTHelper(Node node,int minVal,int maxVal){
		if(node == null){
			return true;
		}
		if (node.data <= minVal && node.data >= maxVal){
			return false;
		}else{
			return isBSTHelper(node.left,minVal,node.data) & isBSTHelper(node.right,node.data,maxVal);
		}
		
	}
}
