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
	
	
	
	//堆排序
	public void insert(int []H, int element) {
		int []H_temp = new int[H.length + 1];
		System.arraycopy(H, 0, H_temp, 0, H.length);
		//插入到堆最后
		H_temp[H.length] = element;
		int k = H.length;
		boolean heap = false;
		while(!heap) {
			
		}
	}
	
}
