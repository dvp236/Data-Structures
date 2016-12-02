package Tree;

public class MainClass {
	public static void main(String[] args){
		BinarySearchTree bt= new BinarySearchTree();
		bt.insert(5);
		bt.insert(3);
		bt.insert(4);
		bt.insert(1);
		bt.insert(9);
		bt.insert(6);
		bt.insert(13);

		bt.insert(14);
		bt.insert(10);
		bt.insert(11);
		
		
		bt.inOrderTraversal();
	//	System.out.println("----");
		//System.out.println(bt.findmin());
		//System.out.println(bt.findmax());
		
		//System.out.println("---height----");
		//System.out.println(bt.getHeight()); 
		
		System.out.println();
		System.out.println("--------");
		
		bt.remove(9);
		bt.inOrderTraversal();
	}

}
