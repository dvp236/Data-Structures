package Tree;

public class SerializeBinarySearchTree {
	public String serialize(BinarySearchTree bst){
		StringBuilder sb = new StringBuilder("");
		serializeHelper(bst.root,sb);
		return sb.toString();
	}
	private void serializeHelper(Node node, StringBuilder sb){
		if(node != null){
			sb.append(node.getData()+" ");
			serializeHelper(node.getLeft(),sb);
			serializeHelper(node.getRight(),sb);
		}
		
	}

}
