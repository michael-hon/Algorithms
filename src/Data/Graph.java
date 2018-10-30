package Data;

public class Graph {
	private int numVertex;
	private int numEdge;
	private int[][] matrix; //使用邻接矩阵表示图
	private int[]mark; //遍历使用，标记节点是否被访问过
	private char[]element; //节点存储的值
	private final int UNVISITED = 0;
	private final int VISITED = 1;
	
	public int getNumVertex() {
		return numVertex;
	}
	
	public void setNumVertex(int numVertex) {
		this.numVertex = numVertex;
	}
	
	public int getNumEdge() {
		return numEdge;
	}
	public void setNumEdge(int numEdge) {
		this.numEdge = numEdge;
	}
	public int[][] getMatrix() {
		return matrix;
	}
	public void setMatrix(int[][] matrix) {
		this.matrix = matrix;
	}
	public int[] getMark() {
		return mark;
	}
	public void setMark(int[] mark) {
		this.mark = mark;
	}
	
	public char[] getElement() {
		return element;
	}

	public void setElement(char[] element) {
		this.element = element;
	}
	
	
	public Graph(int numVertex) {
		this.numVertex = numVertex;
		numEdge = 0;
		int i;
		matrix = new int[numVertex][numVertex]; //使用邻接矩阵表示图
		mark = new int[numVertex]; //遍历使用，标记节点是否被访问过
		element = new char[numVertex]; //节点存储的值
		for(i = 0; i < numVertex; i++) {
			mark[i] = UNVISITED;
		}
		for(i = 0; i < numVertex; i++)
			for(int j = 0; j < numVertex; j++)
				matrix[i][j] = 0;
	}
	
	
	//给节点v设置节点元素值
	public void setElement(int v, char ele) {
		element[v] = ele;
	}
	
	//获取节点v的元素值
	public char getElment(int v) {
		return element[v];
	}
	
	//返回节点数量
	public int n() {
		return numVertex;
	}
	
	//返回边数量
	public int e() {
		return numEdge;
	}
	
	//返回第一条边
	public int first(int v) {
		for(int i = 0; i < numVertex; i++)
			if(matrix[v][i] != 0)
				return i;
		return numVertex; //假如该节点为离群节点，则返回节点数量
	}
	
	//返回v与w边的邻接边
	public int next(int v, int w) {
		for(int i = w + 1; i < numVertex; i++)
			if(matrix[v][i] != 0)
				return i;
		return numVertex;
	}
	
	//v1,v2节点相连，增加一条边,也可以用于修改边的权重
	public void setEdge(int v1, int v2, int wt) {
		if(matrix[v1][v2] == 0)
			numEdge++;
		matrix[v1][v2] = wt;
	}
	
	//删除边(v1,v2)
	public void delEdge(int v1, int v2) {
		if(matrix[v1][v2] != 0)
			numEdge--;
		matrix[v1][v2] = 0;
	}
	
	//判断(v1,v2)是否构成边
	public boolean isEdge(int v1, int v2) {
		return matrix[v1][v2] != 0;
	}
	
	//获取边(v1, v2)的权重
	public int weight(int v1, int v2) {
		return matrix[v1][v2];
	}
	
	//获取节点v的标记
	public int getMark(int v) {
		return mark[v];
	}
	public void setMark(int v, int val) {
		mark[v] = val;
	}


}
