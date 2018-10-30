package Data;

public class Graph {
	private int numVertex;
	private int numEdge;
	private int[][] matrix; //ʹ���ڽӾ����ʾͼ
	private int[]mark; //����ʹ�ã���ǽڵ��Ƿ񱻷��ʹ�
	private char[]element; //�ڵ�洢��ֵ
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
		matrix = new int[numVertex][numVertex]; //ʹ���ڽӾ����ʾͼ
		mark = new int[numVertex]; //����ʹ�ã���ǽڵ��Ƿ񱻷��ʹ�
		element = new char[numVertex]; //�ڵ�洢��ֵ
		for(i = 0; i < numVertex; i++) {
			mark[i] = UNVISITED;
		}
		for(i = 0; i < numVertex; i++)
			for(int j = 0; j < numVertex; j++)
				matrix[i][j] = 0;
	}
	
	
	//���ڵ�v���ýڵ�Ԫ��ֵ
	public void setElement(int v, char ele) {
		element[v] = ele;
	}
	
	//��ȡ�ڵ�v��Ԫ��ֵ
	public char getElment(int v) {
		return element[v];
	}
	
	//���ؽڵ�����
	public int n() {
		return numVertex;
	}
	
	//���ر�����
	public int e() {
		return numEdge;
	}
	
	//���ص�һ����
	public int first(int v) {
		for(int i = 0; i < numVertex; i++)
			if(matrix[v][i] != 0)
				return i;
		return numVertex; //����ýڵ�Ϊ��Ⱥ�ڵ㣬�򷵻ؽڵ�����
	}
	
	//����v��w�ߵ��ڽӱ�
	public int next(int v, int w) {
		for(int i = w + 1; i < numVertex; i++)
			if(matrix[v][i] != 0)
				return i;
		return numVertex;
	}
	
	//v1,v2�ڵ�����������һ����,Ҳ���������޸ıߵ�Ȩ��
	public void setEdge(int v1, int v2, int wt) {
		if(matrix[v1][v2] == 0)
			numEdge++;
		matrix[v1][v2] = wt;
	}
	
	//ɾ����(v1,v2)
	public void delEdge(int v1, int v2) {
		if(matrix[v1][v2] != 0)
			numEdge--;
		matrix[v1][v2] = 0;
	}
	
	//�ж�(v1,v2)�Ƿ񹹳ɱ�
	public boolean isEdge(int v1, int v2) {
		return matrix[v1][v2] != 0;
	}
	
	//��ȡ��(v1, v2)��Ȩ��
	public int weight(int v1, int v2) {
		return matrix[v1][v2];
	}
	
	//��ȡ�ڵ�v�ı��
	public int getMark(int v) {
		return mark[v];
	}
	public void setMark(int v, int val) {
		mark[v] = val;
	}


}
