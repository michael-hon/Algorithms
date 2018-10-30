package algorithms;
import java.util.*;

import Data.*;
public class GraphAlgo {
	
	/*
	 * Prim�㷨����ͼ����С�����������㷨����̰����˼�룬������չ��ǰ����С��������
	 * ���㷨�������ѡ��һ���ڵ���Ϊ��������Ȼ��ÿ���׶ζ�̰����ѡ�񣨴Ӳ������еĽڵ㼯��ѡ�񣬷�ֹ�γɻ�·���뵱ǰ���нڵ�����Ȩ����С�Ľڵ㣬
	 * ����������������У����ջ��γ���С������������֤���ɼ����㷨����������������֤�����㷨һ������������С������
	 */
	/*
	 * ����:һ��ͼ
	 * 
	 * ���:��С�������ߵļ���
	 */
	public GraphNode[] Prim(Graph graph) {
		int n = graph.getNumVertex();//ͼ�нڵ������
		GraphNode[] v_tree = new GraphNode[n]; //ʹ������洢�������ڵ�
		GraphNode[] v = new GraphNode[n];  //�洢���½ڵ�
		//��ʼ����������ѡһ���ڵ�
		GraphNode node = new GraphNode(0, -1, 'a', -1);
		v_tree[0] = node;
		int[][]matrix = graph.getMatrix();
		//��ʼ��
		int j = 0; //��¼v��Ԫ�ظ���
		int k = 1; //��¼v_treeԪ�ظ���
		for(int i = 1; i < n; i++) {
			//��a������
			int neighbor = -1;
			int minWt = Integer.MAX_VALUE;
			//�ڵ���0��ֱ������
			if(matrix[0][i] > 0) {
				neighbor = 0;
				minWt = matrix[0][i];
			}
			char element = graph.getElment(i);
			GraphNode gnode = new GraphNode(i, neighbor, element, minWt);
			v[j] = gnode;
			j++;
		}
		QuickSortAnother(v, 0, j - 1);
		//����̰��������С������,ÿ�δ�v��ѡ��Ȩ����С�Ľڵ�
		for(int i = 1; i < n; i++) {
			//ȡȨ����С�Ľڵ�
			GraphNode gn = v[0];
			int nodeNum = gn.getNodeNum();
			v[0] = v[j - 1]; //ʹ������Ԫ�ش����һ��Ԫ�أ���ɾ����һ��Ԫ��
			//���뵽v_tree��
			v_tree[k] = gn;
			//�������������Ԫ�ظ���
			j--;
			k++;
			//����v�еĽڵ㣬������������
			for(int z = 0; z < j; z++) {
				//����
				if(matrix[nodeNum][v[z].getNodeNum()] > 0 && matrix[nodeNum][v[z].getNodeNum()] < v[z].getMinWt()) {
					v[z].setNeighborNode(nodeNum);
					v[z].setMinWt(matrix[nodeNum][v[z].getNodeNum()]);
				}
			}
			QuickSortAnother(v, 0, j - 1);
		}
		return v_tree;
	}
	
	

	
	
	//����������һ���汾
	public void QuickSortAnother(GraphNode[]A, int left, int right) {
		if(left < right) {
			GraphNode p = A[left];
			int s = left;
			for(int i = left + 1; i <= right; i++) {
				if(A[i].getMinWt() <= p.getMinWt()) {
					s++;
					GraphNode temp = A[i];
					A[i] = A[s];
					A[s] = temp; 
				}
			}
			GraphNode temp = A[s];
			A[s] =  A[left];
			A[left] = temp;
			//�����������������
			QuickSortAnother(A, left, s - 1);
			//�����������������
			QuickSortAnother(A, s + 1, right);
		}
	}
	
	
	
	
	//Kruskal�㷨��
	public void Kruskal(Graph graph) {
		
	}
}
