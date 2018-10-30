package Data;

//该类存储了最小生成树中的节点
public class GraphNode {
	private int nodeNum;
	private int neighborNode;
	private char element;
	private int minWt;
	
	public GraphNode() {
		
	}
	
	public GraphNode(int nodeNum, int neighborNode, char element, int minWt) {
		this.nodeNum = nodeNum;
		this.neighborNode = neighborNode;
		this.element = element;
		this.minWt = minWt;
	}
	
	public int getNodeNum() {
		return nodeNum;
	}
	public void setNodeNum(int nodeNum) {
		this.nodeNum = nodeNum;
	}
	public int getNeighborNode() {
		return neighborNode;
	}
	public void setNeighborNode(int neighborNode) {
		this.neighborNode = neighborNode;
	}
	public char getElement() {
		return element;
	}
	public void setElement(char element) {
		this.element = element;
	}
	public int getMinWt() {
		return minWt;
	}
	public void setMinWt(int minWt) {
		this.minWt = minWt;
	}
	
}
