package Data;

import java.math.*;
public class Heap {
	//自底向上方法构建堆
	public void HeapBottom(int H[]) {
		int n = H.length;
		int internalNodeNum = (int)Math.floor(n / 2.0);
		for(int i = internalNodeNum - 1; i >= 0; i--) {
			int v = H[i];
			boolean heap = false;
			int k = i; //记录根节点，对以该根节点的子树构建堆
			//第二个判断条件是判断是否到达叶子节点，当k是叶子节点时，则表明构建完成
			while(!heap && (2 * k + 1) < n ) {
				int j = 2 * k + 1;
				//有两个子结点
				if(j < n - 1) {
					//取最大的值
					if(H[j] < H[j + 1])
						j = j + 1;
				}
				if(v < H[j]) {
					H[k] = H[j];
					k = j;
				}
				else {
					heap = true;
				}
			}
			H[k] = v;
		}
	}
	
	
	
	//堆排序,将最大值与数组最后一个元素调换，重新构造堆
	public void sortByHeap(int[]H){
		int n = H.length;
		int num = n; //剩余数组元素个数
		while(num != 1){
			int temp = H[0];
			H[0] = H[num - 1];
			H[num - 1] = temp;
			num--;
			heapCon(H, num);
		}
	}
	
	//重新堆化，n为数组元素个数
	public void heapCon(int[]H, int n){
		int internalNodeNum = (int)Math.floor(n / 2.0);
		for(int i = internalNodeNum - 1; i >= 0; i--) {
			int v = H[i];
			boolean heap = false;
			int k = i; //记录根节点，对以该根节点的子树构建堆
			//第二个判断条件是判断是否到达叶子节点，当k是叶子节点时，则表明构建完成
			while(!heap && (2 * k + 1) < n ) {
				int j = 2 * k + 1;
				//有两个子结点
				if(j < n - 1) {
					//取最大的值
					if(H[j] < H[j + 1])
						j = j + 1;
				}
				if(v < H[j]) {
					H[k] = H[j];
					k = j;
				}
				else {
					heap = true;
				}
			}
			H[k] = v;
		}
	}
	
}
