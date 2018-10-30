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
	
	
	
	//������,�����ֵ���������һ��Ԫ�ص��������¹����
	public void sortByHeap(int[]H){
		int n = H.length;
		int num = n; //ʣ������Ԫ�ظ���
		while(num != 1){
			int temp = H[0];
			H[0] = H[num - 1];
			H[num - 1] = temp;
			num--;
			heapCon(H, num);
		}
	}
	
	//���¶ѻ���nΪ����Ԫ�ظ���
	public void heapCon(int[]H, int n){
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
	
}
