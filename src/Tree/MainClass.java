package Tree;

public class MainClass {
	public static void main(String[] args){
		BinarySearchTree bt= new BinarySearchTree();
		bt.insert(3);
		bt.insert(2);
		bt.insert(1);
		bt.insert(5);
		bt.insert(7);
		ValidateBinarySearchTree vt = new ValidateBinarySearchTree();
		System.out.println(vt.isBinarySearchTree(bt.root));
	}

}
