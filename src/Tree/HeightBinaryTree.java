package Tree;

public class HeightBinaryTree {
	
	private int getHeight(Node node){
		if(node == null){
			return -1;
		}
		return Math.max(getHeight(node.getLeft()), getHeight(node.getRight()))+ 1;
	}
}
