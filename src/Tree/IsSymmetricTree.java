package Tree;

class TreeNode{
	int value;
	TreeNode left;
	TreeNode right;
}

public class IsSymmetricTree {
	public static boolean isSym(TreeNode root) {
		return isSymHelper(root.left , root.right);
	}
	
	private static boolean isSymHelper(TreeNode left, TreeNode right) {
		//if both null then they are symmetric
		if(left == null && right == null) return true;
		//if either is null then its not symmetric
		if(left == null || right == null) return false;
		
		//finally check value and recursive call
		return left.value == right.value
				&& isSymHelper(left.left , right.right) 
				&& isSymHelper(left.right, right.left);
	}
	

}
