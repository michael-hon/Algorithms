package Data;

import java.math.*;
public class Heap {
	//�Ե����Ϸ���������
	public void HeapBottom(int H[]) {
		int n = H.length;
		int internalNodeNum = (int)Math.floor(n / 2.0);
		for(int i = internalNodeNum - 1; i >= 0; i--) {
			int v = H[i];
			boolean heap = false;
			int k = i; //��¼���ڵ㣬���Ըø��ڵ������������
			//�ڶ����ж��������ж��Ƿ񵽴�Ҷ�ӽڵ㣬��k��Ҷ�ӽڵ�ʱ��������������
			while(!heap && (2 * k + 1) < n ) {
				int j = 2 * k + 1;
				//�������ӽ��
				if(j < n - 1) {
					//ȡ����ֵ
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
	
	
	
	//������
	public void insert(int []H, int element) {
		int []H_temp = new int[H.length + 1];
		System.arraycopy(H, 0, H_temp, 0, H.length);
		//���뵽�����
		H_temp[H.length] = element;
		int k = H.length;
		boolean heap = false;
		while(!heap) {
			
		}
	}
	
}
