package Data;


//二叉检索树的节点
public class BSTNode {
	private int key;     //节点的key值
	private String element;   //节点的value值
	private BSTNode leftChild; //左子节点
	private BSTNode rightChild; //右子节点
	
	public BSTNode() {
		
	}
	
	public BSTNode(int key, String element, BSTNode leftChild, BSTNode rightChild) {
		this.key = key;
		this.element = element;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}
	
	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	public String getElement() {
		return element;
	}
	public void setElement(String element) {
		this.element = element;
	}
	public BSTNode getLeftChild() {
		return leftChild;
	}
	public void setLeftChild(BSTNode leftChild) {
		this.leftChild = leftChild;
	}
	public BSTNode getRightChild() {
		return rightChild;
	}
	public void setRightChild(BSTNode rightChild) {
		this.rightChild = rightChild;
	}
	boolean isLeaf() {
		return (leftChild == null) && (rightChild == null);
	}
	
}
