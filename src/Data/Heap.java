package Data;

import java.math.*;
public class Heap {
	//�Ե����Ϸ���������
	public void HeapBottom(int H[]) {
		int n = H.length;
		int internalNodeNum = (int)Math.floor(n / 2.0);
		for(int i = 0; i < internalNodeNum; i++) {
			int v = H[i];
			boolean heap = false;
			int k = i;
			while(!heap) {
				int j = 2 * k;
				//�������ӽ��
				if(j < n - 1) {
					if(H[j] < H[j + 1])
						j = j + 1;
				}
					
			}
		}
	}
}
