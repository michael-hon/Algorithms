package Data;

//哈夫曼树节点
public class HuffmanNode {
	private double prob;//节点的概率
	private char element;//节点携带的字符，主要针对叶子节点，内部节点该属性为空
	private HuffmanNode left; //左子节点
	private HuffmanNode right; //右子节点
	
	public HuffmanNode(double prob, char element, HuffmanNode left, HuffmanNode right) {
		this.setProb(prob);
		this.setElement(element);
		this.setLeft(left);
		this.setRight(right);
	}
	
	public HuffmanNode() {
		
	}

	public double getProb() {
		return prob;
	}

	public void setProb(double prob) {
		this.prob = prob;
	}

	public char getElement() {
		return element;
	}

	public void setElement(char element) {
		this.element = element;
	}

	public HuffmanNode getLeft() {
		return left;
	}

	public void setLeft(HuffmanNode left) {
		this.left = left;
	}

	public HuffmanNode getRight() {
		return right;
	}

	public void setRight(HuffmanNode right) {
		this.right = right;
	}
	
}
