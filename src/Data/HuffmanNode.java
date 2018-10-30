package Data;

//���������ڵ�
public class HuffmanNode {
	private double prob;//�ڵ�ĸ���
	private char element;//�ڵ�Я�����ַ�����Ҫ���Ҷ�ӽڵ㣬�ڲ��ڵ������Ϊ��
	private HuffmanNode left; //���ӽڵ�
	private HuffmanNode right; //���ӽڵ�
	
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
