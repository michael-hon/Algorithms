package Test;

import Data.BST;
import Data.BSTNode;
import Data.Heap;

public class test {
	public static void main(String[]args) {
		test t = new test();
//		BST bst = t.createBST();
//		BSTNode root = bst.getRoot();
//		bst.print(root);
//		BSTNode node = bst.getMin(root);
//		System.out.println(node.getElement());
//		bst.insert(root, 3, "C");
//		bst.print(root);
//		bst.remove(root, 2);
//		bst.print(root);
		Heap heap = new Heap();
		int []H = new int[] {1, 2, 3, 4, 5, 6, 7};
		heap.HeapBottom(H);
		for(int i = 0; i < H.length; i++)
			System.out.print(H[i] + " ");
	}
	
	
	public BST createBST() {
		BSTNode leafA = new BSTNode(1, "A", null, null);
		BSTNode leafB = new BSTNode(4, "D", null, null);
		BSTNode leafK = new BSTNode(11, "K", null, null);
		BSTNode B = new BSTNode(2, "B", leafA, leafB);
		BSTNode H = new BSTNode(8, "H", null, leafK);
		BSTNode root = new BSTNode(6, "F", B, H);
		BST bst = new BST(root, 6);
		return bst;
	}
}
