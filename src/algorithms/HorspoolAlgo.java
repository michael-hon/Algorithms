package algorithms;
import java.util.HashMap;
import java.util.Map;
public class HorspoolAlgo {
	
	
	public void Hospool(String T, String P){
		//生成转移表
		Map<Character, Integer> shift = new HashMap<Character, Integer>();
		shift = ShiftTable(P);
		int P_len = P.length();
		int i = P_len - 1; //文本中与模式最后一个字符匹配的位置
		int T_len = T.length();
		while(i < T_len){
			int m = 0; //成功匹配的个数
			int k = i; 
			int j = P_len - 1;
			//匹配,注意边界条件
			while(m < P_len && T.charAt(k) == P.charAt(j)){
				m++;
				k--;
				j--;
			}
			//匹配成功
			if(m == P_len && T.charAt(k + 1) == P.charAt(j + 1)){
				System.out.println("匹配到的位置是位置   " + "(" + (i - P_len + 2) + "," + (i + 1) +")");
				return;
			}
			//匹配不成功，转移
			i = i + shift.get(T.charAt(i));
		}
	}
	
	//生成转移表
	public Map<Character, Integer> ShiftTable(String P){
		String str = "abcdefghijklmnopqrstuvwxyz";
		Map<Character, Integer> shiftTable = new HashMap<Character, Integer>();
		//初始化转移表
		for(int i = 0; i < 26; i++)
			shiftTable.put(str.charAt(i), P.length());
		for(int i = 0; i < P.length() - 1; i++)
			shiftTable.put(str.charAt(i), P.length() - i - 1);
		return shiftTable;
	}
}
