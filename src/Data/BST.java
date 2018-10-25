package Data;

//���������
public class BST {
	private BSTNode root; //���ڵ�
	private int count; //�ڵ�����
	
	public BST(BSTNode root, int count) {
		this.root = root;
		this.count = count;
	}
	
	public BSTNode getRoot() {
		return root;
	}
	public void setRoot(BSTNode root) {
		this.root = root;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	//������key��value�Ľڵ���뵽��rootΪ���ڵ�����У����ҷ��ظ��ڵ�
	public BSTNode insert(BSTNode root, int key, String value) {
		//���ڵ�Ϊ�գ�����Ϊ��
		if(root == null) {
			return new BSTNode(key, value, null, null);
		}
		else {
			//����������
			if (key < root.getKey()) {
				//�ݹ�
				BSTNode leftRoot = insert(root.getLeftChild(), key, value);
				root.setLeftChild(leftRoot);
			}
			else {
				BSTNode rightRoot = insert(root.getRightChild(), key, value);
				root.setRightChild(rightRoot);
			}
		}
		return root;
	}
	
	//ɾ�������������Сֵ
	public BSTNode deleteMin(BSTNode root) {
		
		//�ҵ���Сֵ,������Сֵ�ڵ���������ĸ��ڵ�
		if(root.getLeftChild() == null) {
			return root.getRightChild();
		}
		
		BSTNode leftroot = deleteMin(root.getLeftChild()); //���ظ��ڵ㣬��������
		root.setLeftChild(leftroot);
		return root;
	}
	
	//��ȡ��Сֵ
	public BSTNode getMin(BSTNode root) {
		if(root.getLeftChild() == null) {
			return root;
		}
		return getMin(root.getLeftChild());
	}
	
	//ɾ���������������ڵ�
	public BSTNode remove(BSTNode root, int key) {
		//��Ϊ��
		if(root == null)
			return null;
		else {
			//����������
			if(key < root.getKey()) {
				BSTNode leftNode = remove(root.getLeftChild(), key);
				root.setLeftChild(leftNode);
			}
			else {
				//����������
				if(key > root.getKey()) {
					BSTNode rightNode = remove(root.getRightChild(), key);
					root.setRightChild(rightNode);
				}
				//�ҵ�,���ڵ�Ϊ��Ҫ���ҵĽڵ�
				else {
					if(root.getLeftChild() == null) 
						root = root.getRightChild();
					else {
						if(root.getRightChild() == null)
							root = root.getLeftChild();
						else {
							BSTNode rightNode = getMin(root.getRightChild());
							root.setElement(rightNode.getElement());
							root.setKey(rightNode.getKey());
							root.setRightChild(deleteMin(root.getRightChild()));
						}
					}
				}
			}
		}
		
		return root;
	}
	
	//����������нڵ�,�������
	public void print(BSTNode root) {
		if(root == null)
			return;
		print(root.getLeftChild());
		System.out.print(root.getElement()+ "  ");
		print(root.getRightChild());
	}
	
	
	
}
