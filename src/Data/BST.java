package Data;

//二叉检索树
public class BST {
	private BSTNode root; //根节点
	private int count; //节点数量
	
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
	
	//将包含key和value的节点插入到以root为根节点的树中，并且返回根节点
	public BSTNode insert(BSTNode root, int key, String value) {
		//根节点为空，即树为空
		if(root == null) {
			return new BSTNode(key, value, null, null);
		}
		else {
			//插入左子树
			if (key < root.getKey()) {
				//递归
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
	
	//删除二叉检索树最小值
	public BSTNode deleteMin(BSTNode root) {
		
		//找到最小值,返回最小值节点的右子树的根节点
		if(root.getLeftChild() == null) {
			return root.getRightChild();
		}
		
		BSTNode leftroot = deleteMin(root.getLeftChild()); //返回根节点，便于连接
		root.setLeftChild(leftroot);
		return root;
	}
	
	//获取最小值
	public BSTNode getMin(BSTNode root) {
		if(root.getLeftChild() == null) {
			return root;
		}
		return getMin(root.getLeftChild());
	}
	
	//删除二叉检索树任意节点
	public BSTNode remove(BSTNode root, int key) {
		//树为空
		if(root == null)
			return null;
		else {
			//左子树查找
			if(key < root.getKey()) {
				BSTNode leftNode = remove(root.getLeftChild(), key);
				root.setLeftChild(leftNode);
			}
			else {
				//右子树查找
				if(key > root.getKey()) {
					BSTNode rightNode = remove(root.getRightChild(), key);
					root.setRightChild(rightNode);
				}
				//找到,根节点为需要查找的节点
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
	
	//输出树中所有节点,中序遍历
	public void print(BSTNode root) {
		if(root == null)
			return;
		print(root.getLeftChild());
		System.out.print(root.getElement()+ "  ");
		print(root.getRightChild());
	}
	
	
	
}
