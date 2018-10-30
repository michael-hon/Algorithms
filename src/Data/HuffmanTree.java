package Data;

import java.util.Map;

public class HuffmanTree {
	private HuffmanNode root; //�����������ڵ�
	private int count; //�ڵ�����
	public HuffmanNode getRoot() {
		return root;
	}
	public void setRoot(HuffmanNode root) {
		this.root = root;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	//�������ӽڵ�ϲ�,���ҷ��������ĸ��ڵ�
	private HuffmanNode union(HuffmanNode n1, HuffmanNode n2) {
		double n1_prob = n1.getProb();
		double n2_prob = n2.getProb();
		double prob_sum = n1_prob + n2_prob;
		//������С�ķ��������������ʴ�ķ���������
		HuffmanNode root = new HuffmanNode();
		root.setElement(' ');
		root.setProb(prob_sum);
		if(n1_prob < n2_prob) {
			root.setLeft(n1);
			root.setRight(n2);
		}
		else {
			root.setLeft(n2);
			root.setRight(n1);
		}
		return root;
	}
}
