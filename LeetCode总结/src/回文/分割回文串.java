package 回文;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 分割回文串 {
	/*给定一个个字符串 s，将 s 分割成一些子串，使每个子串都是回文串?

	返回 s有可能的分割方案?

	示例:

	输入: "aab"
	输出:
	[
	  ["aa","b"],
	  ["a","a","b"]
	]
*/
	 List<List<String>> list=new ArrayList<List<String>>();
	    public List<List<String>> partition(String s) {  
	        if(s==null||s.length()==0)
	            return list;
	        backtracking(s,0,new LinkedList<String>());
	        return list;
	    }
	    private void backtracking(String s,int begin,List<String> tlist){
	        if(begin==s.length()){
	            list.add(new ArrayList<String>(tlist));
	            return;
	        }
	        for(int i=begin;i<s.length();i++){
	            if(isMatch(s,begin,i)){
	                tlist.add(s.substring(begin,i+1));
	                backtracking(s,i+1,tlist);
	                ((LinkedList) tlist).removeLast();
	            }
	            
	        }
	    }
	    private boolean isMatch(String s, int lo, int hi) {
	        while (lo < hi)
	            if (s.charAt(lo++) != s.charAt(hi--)) 
	            	return false;
	        return true;
	}
}
