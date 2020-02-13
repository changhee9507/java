package dataStructure.binarytree;

public class BinaryTreeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int size = 10;
		BinaryTree bt = new BinaryTree(10);
		
		for(int i=0; i<size;i++) {
			bt.add((char)('A'+i));
		}
		bt.printPreorder();
		bt.printInorder();
		bt.printPostorder();
		bt.printTreeByLevelOrder();
	}

}
