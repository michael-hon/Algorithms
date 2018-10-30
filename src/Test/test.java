package Test;

import java.util.Map;

import Data.BST;
import Data.BSTNode;
import Data.Graph;
import Data.GraphNode;
import Data.Heap;
import Data.HuffmanTree;
import algorithms.GraphAlgo;

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
//		Heap heap = new Heap();
//		int []H = new int[] {1, 2, 3, 4, 5, 6, 7};
//		heap.HeapBottom(H);
//		for(int i = 0; i < H.length; i++)
//			System.out.print(H[i] + " ");
//		int numVertex = 6;
//		Graph graph = t.creatGraph(numVertex);
//		int[][] matrix = graph.getMatrix();
//		for(int i = 0; i < numVertex; i++) {
//			System.out.println();
//			for(int j = 0; j < numVertex; j++)
//				System.out.print(matrix[i][j] + "  ");
//		}
//		GraphAlgo ga = new GraphAlgo();
//		GraphNode[] nodes = ga.Prim(graph);
//		for(int i = 0; i < nodes.length; i++) {
//			int w = nodes[i].getNeighborNode();
//			if(w == -1)
//				w++;
//			System.out.println(nodes[i].getElement() + ", " + graph.getElment(w) + " ," + nodes[i].getMinWt());
//		}
		
		HuffmanTree huffmanTree = new HuffmanTree();
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
	
	
	public Graph creatGraph(int n) {
		Graph graph = new Graph(n);
		graph.setElement(0, 'a');
		graph.setElement(1, 'b');
		graph.setElement(2, 'c');
		graph.setElement(3, 'd');
		graph.setElement(4, 'e');
		graph.setElement(5, 'f');
		graph.setEdge(0, 1, 3);
		graph.setEdge(1, 0, 3);
		graph.setEdge(0, 4, 6);
		graph.setEdge(4, 0, 6);
		graph.setEdge(0, 5, 5);
		graph.setEdge(5, 0, 5);
		graph.setEdge(1, 2, 1);
		graph.setEdge(2, 1, 1);
		graph.setEdge(1, 5, 4);
		graph.setEdge(5, 1, 4);
		graph.setEdge(2, 3, 6);
		graph.setEdge(3, 2, 6);
		graph.setEdge(2, 5, 4);
		graph.setEdge(5, 2, 4);
		graph.setEdge(3, 5, 5);
		graph.setEdge(5, 3, 5);
		graph.setEdge(3, 4, 8);
		graph.setEdge(4, 3, 8);
		graph.setEdge(4, 5, 2);
		graph.setEdge(5, 4, 2);
		return graph;
	}
	
	
	/*
	 * 构建哈夫曼树
	 * 输入：字典,已经排好序
	 */
	public HuffmanTree createHuffmanTree(Map<Character, Double> alphabet) {
		HuffmanTree huffmanTree = new HuffmanTree();
		for(Map.Entry<Character, Double> m : alphabet.entrySet()) {
			
		}
		return null;
	}
}
