package algorithms;

import java.util.HashMap;

public class LengthOfLongestSubstring_Solution {

	/*
	 * 目的:
	 * 	找出字符串s中不含重复字符的子字符串的长度
	 * 分析:
	 * 	要得到最长不含重复字符的子字符串,则以重复的字符作为间隔
	 * 例:
	 * 	字符串: pwwkew
	 * 		从第一个字符开始遍历,得子字符串"pw", 此时若从第二个字符"w"开始继续遍历,
	 * 则仅得到子字符串"w",然后继续向后走,这样不仅费事,且毫无意义
	 * 		在得到第一个子字符串时,若从重复的字符开始遍历,将得到子字符串"wke",此后继续
	 * 按重复的字符开始遍历,这样避免了重复,更加方便,快捷
	 * 
	 * 方法:
	 * 	i	当前字符在字符串中的索引
	 * 	j	重复字符在字符串中的位置
	 * 	i-j+1	子字符串长度 
	 */
	public int lengthOfLongestSubstring(String s) {
		if (s.length()==0) return 0;

		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int max=0;
		
		for (int i=0, j=0; i<s.length(); ++i){
			if (map.containsKey(s.charAt(i))){
				//j 重复字符在原字符串中的索引位置
				j = Math.max(j,map.get(s.charAt(i))+1);
			}
			map.put(s.charAt(i),i);
			//i-j+1 不重复字符串长度
			max = Math.max(max,i-j+1);
//			System.out.println("i-" + i + ";j-" + j + ";max-" + max);
//			System.out.println(map);
		}
		return max;
	}
}
