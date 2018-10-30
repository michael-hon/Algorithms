package algorithms;

import java.util.HashMap;
import java.util.Map;

public class BoyerMoore {
	
	
	//实现boyer-moore算法
	public void Boyer_Moore(String T, String P) {
		int T_len = T.length();
		int P_len = P.length();
		int i = P_len - 1; //文本中当前匹配的字符指针,从右到左匹配
		int j = P_len - 1; //模式中当前匹配的字符指针
		
		Map<Character, Integer> badsymbolshift = BadSymbolShift(P);
		Map<Integer, Integer> goodsuffixshift = GoodSuffixShift(P);
		while(i < T_len) {
			int k = 0; //匹配字符的个数
			while(j >= 0) {
				if(T.charAt(i) != P.charAt(j))
					break;
				i--;
				j--;
				k++;
			}
			//当匹配的时候，i = -1,所以才要加2
			if(k == P_len) {
				System.out.println("在第" + (i + 2) + "处匹配");
				i = i + P_len - 1;
				j = P_len - 1;
				continue;
			}
			int d = 0; //移动距离
			int d1 = Math.max(badsymbolshift.get(T.charAt(i)) - k, 1);
			int d2 = goodsuffixshift.get(k);
			d = Math.max(d1, d2);
			//重新定位匹配指针
			j = P_len - 1;
			i = i + k + d;
		}
	}
	
	
	
	
	//构造坏字符串移动表
	public Map<Character, Integer> BadSymbolShift(String P){
		String str = "abcdefghijklmnopqrstuvwxyz";
		Map<Character, Integer> shiftTable = new HashMap<Character, Integer>();
		//初始化转移表
		for(int i = 0; i < 26; i++)
			shiftTable.put(str.charAt(i), P.length());
		for(int i = 0; i < P.length() - 1; i++)
			shiftTable.put(str.charAt(i), P.length() - i - 1);
		return shiftTable;
	}
	
	
	//构造好后缀移动表
	public Map<Integer, Integer> GoodSuffixShift(String P){
		 Map<Integer, Integer> shiftTable = new HashMap<Integer, Integer>();
		 shiftTable.put(0, 0);
		 int p_len = P.length();
		 //初始化
		 for(int k = 1; k < p_len; k++)
			 shiftTable.put(k, p_len);
		 String p_temp = P.substring(0, p_len - 1);
		 //注意，这里从1开始，因为当k=0时，表示无好后缀，直接取坏字符串移动距离
		 for(int k = 1; k < p_len; k++) {
			 String suffix = P.substring(p_len - k);
			 int index = p_temp.lastIndexOf(suffix); //返回最右缀的索引，注意是以0开始
			 if(index >= 0) {
				 index = p_len - k - index;
				 shiftTable.put(k, index);
			 }
			 //不存在最右缀
			 else {
				 //寻找最长前缀
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
					//找到最长前缀
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