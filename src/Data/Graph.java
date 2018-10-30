package Data;

public class Graph {
	private int numVertex;
	private int numEdge;
	private int[][] matrix = new int[numVertex][numVertex]; //ʹ���ڽӾ����ʾͼ
	private int[]mark = new int[numVertex]; //����ʹ�ã���ǽڵ��Ƿ񱻷��ʹ�
	
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
	
	public void Init(int n) {
		int i;
		numVertex = n;
		numEdge = 0;
		for(i = 0; i < numVertex; i++) {
			mark[i] = UNVISITED;
		}
		for(i = 0; i < numVertex; i++)
			for(int j = 0; j < numVertex; j++)
				matrix[i][j] = 0;
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
