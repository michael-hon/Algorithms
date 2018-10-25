package Data;

import java.math.*;
public class Heap {
	//自底向上方法构建堆
	public void HeapBottom(int H[]) {
		int n = H.length;
		int internalNodeNum = (int)Math.floor(n / 2.0);
		for(int i = 0; i < internalNodeNum; i++) {
			int v = H[i];
			boolean heap = false;
			int k = i;
			while(!heap) {
				int j = 2 * k;
				//有两个子结点
				if(j < n - 1) {
					if(H[j] < H[j + 1])
						j = j + 1;
				}
					
			}
		}
	}
}
