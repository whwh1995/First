package 字符串问题;

public class 是否包含字符串 {
	/*字符串的排列
	给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。

	换句话说，第一个字符串的排列之一是第二个字符串的子串。

	示例1:

	输入: s1 = "ab" s2 = "eidbaooo"
	输出: True
	解释: s2 包含 s1 的排列之一 ("ba").
	 

	示例2:

	输入: s1= "ab" s2 = "eidboaoo"
	输出: False*/
	class Solution {
	    public boolean checkInclusion(String s1, String s2) {
	       if(s1 == null || s2 == null || s1.length()>s2.length()) 
	           return false;
	        int [] dif = new int[26];
	        for(int i = 0;i<s1.length();i++){
	            dif[s1.charAt(i)-'a'] --;
	            dif[s2.charAt(i)-'a'] ++;
	        }
	        for(int j = s1.length();j<s2.length();j++){
	            if(isSame(dif)){
	              return true;  
	            }
	            dif[s2.charAt(j-s1.length())-'a'] --;
	            dif[s2.charAt(j) - 'a']++;
	        }
	        return isSame(dif);
	    }
	    
	    public boolean isSame(int []dif){
	        for(int i = 0;i<dif.length;i++){
	            if(dif[i]!=0){
	                return false;
	            }
	        }
	        return true;
	    }
	}
}
