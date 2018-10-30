package algorithms;

import java.util.HashMap;
import java.util.Map;

public class BoyerMoore {
	
	
	//ʵ��boyer-moore�㷨
	public void Boyer_Moore(String T, String P) {
		int T_len = T.length();
		int P_len = P.length();
		int i = P_len - 1; //�ı��е�ǰƥ����ַ�ָ��,���ҵ���ƥ��
		int j = P_len - 1; //ģʽ�е�ǰƥ����ַ�ָ��
		
		Map<Character, Integer> badsymbolshift = BadSymbolShift(P);
		Map<Integer, Integer> goodsuffixshift = GoodSuffixShift(P);
		while(i < T_len) {
			int k = 0; //ƥ���ַ��ĸ���
			while(j >= 0) {
				if(T.charAt(i) != P.charAt(j))
					break;
				i--;
				j--;
				k++;
			}
			//��ƥ���ʱ��i = -1,���Բ�Ҫ��2
			if(k == P_len) {
				System.out.println("�ڵ�" + (i + 2) + "��ƥ��");
				i = i + P_len - 1;
				j = P_len - 1;
				continue;
			}
			int d = 0; //�ƶ�����
			int d1 = Math.max(badsymbolshift.get(T.charAt(i)) - k, 1);
			int d2 = goodsuffixshift.get(k);
			d = Math.max(d1, d2);
			//���¶�λƥ��ָ��
			j = P_len - 1;
			i = i + k + d;
		}
	}
	
	
	
	
	//���컵�ַ����ƶ���
	public Map<Character, Integer> BadSymbolShift(String P){
		String str = "abcdefghijklmnopqrstuvwxyz";
		Map<Character, Integer> shiftTable = new HashMap<Character, Integer>();
		//��ʼ��ת�Ʊ�
		for(int i = 0; i < 26; i++)
			shiftTable.put(str.charAt(i), P.length());
		for(int i = 0; i < P.length() - 1; i++)
			shiftTable.put(str.charAt(i), P.length() - i - 1);
		return shiftTable;
	}
	
	
	//����ú�׺�ƶ���
	public Map<Integer, Integer> GoodSuffixShift(String P){
		 Map<Integer, Integer> shiftTable = new HashMap<Integer, Integer>();
		 shiftTable.put(0, 0);
		 int p_len = P.length();
		 //��ʼ��
		 for(int k = 1; k < p_len; k++)
			 shiftTable.put(k, p_len);
		 String p_temp = P.substring(0, p_len - 1);
		 //ע�⣬�����1��ʼ����Ϊ��k=0ʱ����ʾ�޺ú�׺��ֱ��ȡ���ַ����ƶ�����
		 for(int k = 1; k < p_len; k++) {
			 String suffix = P.substring(p_len - k);
			 int index = p_temp.lastIndexOf(suffix); //��������׺��������ע������0��ʼ
			 if(index >= 0) {
				 index = p_len - k - index;
				 shiftTable.put(k, index);
			 }
			 //����������׺
			 else {
				 //Ѱ���ǰ׺
				int l = k - 1;
				while(l > 0) {
					boolean isMatch = true;
					int i = p_len - l;
					int j = 0;
					while(j < l) {
						if(P.charAt(j) != P.charAt(i)) {
							isMatch = false;
							break;
						}
						i++;
						j++;
					}
					//�ҵ��ǰ׺
					if(isMatch) {
						shiftTable.put(k, p_len - l);
						break;
					}
					l--;
				}
			}
			 
			 
		 }
		return shiftTable;
		
	}
	
	
}