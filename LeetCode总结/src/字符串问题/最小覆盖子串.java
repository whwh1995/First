package 字符串问题;
/*给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。

示例：

输入: S = "ADOBECODEBANC", T = "ABC"
输出: "BANC"
说明：

如果 S 中不存这样的子串，则返回空字符串 ""。
如果 S 中存在这样的子串，我们保证它是唯一的答案。
*/
public class 最小覆盖子串 {
	class Solution {
	    public String minWindow(String s, String t) {
	        char[] sChars = s.toCharArray();
	        char[] pChars = t.toCharArray();
	        int[] pMap = new int[128];
	        int i = 0, j = 0; // 考察窗口[i,j-1]
	        int count = pChars.length;
	        int minLen = s.length() + 1,l = 0,r = 0;
	        for (char pChar : pChars)
	            pMap[pChar]++;
	        while (j < sChars.length) {
	            //减小计数
	            if (pMap[sChars[j]] > 0)
	                count--;
	            pMap[sChars[j]]--;
	            j++;
	            //计数为 0说明区间[i,j-1] 包含 p
	            while (count == 0) {
	                //求得一个解
	                if (j - i < minLen) {
	                    minLen = j - i;
	                    l = i;
	                    r = j;
	                }
	                pMap[sChars[i]]++;
	                // 增加计数
	                if (pMap[sChars[i]] > 0)
	                    count++;
	                i++;
	            }
	        }
	        return minLen == s.length() + 1 ? "" : s.substring(l, r);
	    }

	}
}
