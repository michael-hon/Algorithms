package algorithms;
import java.util.*;

import Data.*;
public class GraphAlgo {
	
	/*
	 * Prim算法生成图的最小生成树：该算法利用贪婪的思想，不断扩展当前的最小生成树。
	 * 该算法首先随机选择一个节点作为生成树，然后每个阶段都贪婪地选择（从不在树中的节点集合选择，防止形成回路）与当前树中节点相连权重最小的节点，
	 * 并将其加入生成树中，最终会形成最小生成树。至于证明可见《算法设计与分析基础》，证明该算法一定可以生成最小生成树
	 */
	/*
	 * 输入:一张图
	 * 
	 * 输出:最小生成树边的集合
	 */
	public GraphNode[] Prim(Graph graph) {
		int n = graph.getNumVertex();//图中节点的数量
		GraphNode[] v_tree = new GraphNode[n]; //使用链表存储生成树节点
		GraphNode[] v = new GraphNode[n];  //存储余下节点
		//初始化生成树，选一个节点
		GraphNode node = new GraphNode(0, -1, 'a', -1);
		v_tree[0] = node;
		int[][]matrix = graph.getMatrix();
		//初始化
		int j = 0; //记录v的元素个数
		int k = 1; //记录v_tree元素个数
		for(int i = 1; i < n; i++) {
			//与a有连接
			int neighbor = -1;
			int minWt = Integer.MAX_VALUE;
			//节点与0点直接连接
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
		//迭代贪婪生成最小生成树,每次从v中选择权重最小的节点
		for(int i = 1; i < n; i++) {
			//取权重最小的节点
			GraphNode gn = v[0];
			int nodeNum = gn.getNodeNum();
			v[0] = v[j - 1]; //使用最后的元素代替第一个元素，即删除第一个元素
			//加入到v_tree中
			v_tree[k] = gn;
			//更新两个数组的元素个数
			j--;
			k++;
			//更新v中的节点，并且重新排序
			for(int z = 0; z < j; z++) {
				//更新
				if(matrix[nodeNum][v[z].getNodeNum()] > 0 && matrix[nodeNum][v[z].getNodeNum()] < v[z].getMinWt()) {
					v[z].setNeighborNode(nodeNum);
					v[z].setMinWt(matrix[nodeNum][v[z].getNodeNum()]);
				}
			}
			QuickSortAnother(v, 0, j - 1);
		}
		return v_tree;
	}
	
	

	
	
	//快速排序另一个版本
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
			//对左子数组快速排序
			QuickSortAnother(A, left, s - 1);
			//对右子数组快速排序
			QuickSortAnother(A, s + 1, right);
		}
	}
	
	
	
	
	//Kruskal算法：
	public void Kruskal(Graph graph) {
		
	}
}
