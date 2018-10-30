package algorithms;
import java.util.HashMap;
import java.util.Map;
public class HorspoolAlgo {
	
	
	public void Hospool(String T, String P){
		//����ת�Ʊ�
		Map<Character, Integer> shift = new HashMap<Character, Integer>();
		shift = ShiftTable(P);
		int P_len = P.length();
		int i = P_len - 1; //�ı�����ģʽ���һ���ַ�ƥ���λ��
		int T_len = T.length();
		while(i < T_len){
			int m = 0; //�ɹ�ƥ��ĸ���
			int k = i; 
			int j = P_len - 1;
			//ƥ��,ע��߽�����
			while(m < P_len && T.charAt(k) == P.charAt(j)){
				m++;
				k--;
				j--;
			}
			//ƥ��ɹ�
			if(m == P_len && T.charAt(k + 1) == P.charAt(j + 1)){
				System.out.println("ƥ�䵽��λ����λ��   " + "(" + (i - P_len + 2) + "," + (i + 1) +")");
				return;
			}
			//ƥ�䲻�ɹ���ת��
			i = i + shift.get(T.charAt(i));
		}
	}
	
	//����ת�Ʊ�
	public Map<Character, Integer> ShiftTable(String P){
		String str = "abcdefghijklmnopqrstuvwxyz";
		Map<Character, Integer> shiftTable = new HashMap<Character, Integer>();
		//��ʼ��ת�Ʊ�
		for(int i = 0; i < 26; i++)
			shiftTable.put(str.charAt(i), P.length());
		for(int i = 0; i < P.length() - 1; i++)
			shiftTable.put(str.charAt(i), P.length() - i - 1);
		return shiftTable;
	}
}
