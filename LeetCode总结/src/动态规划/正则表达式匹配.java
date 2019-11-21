package 动态规划;

public class 正则表达式匹配 {
/*	给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。

	'.' 匹配任意单个字符
	'*' 匹配零个或多个前面的那一个元素
	所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。

	说明:

	s 可能为空，且只包含从 a-z 的小写字母。
	p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
	*/
	
	/*如果 p.charAt(j) == s.charAt(i) : dp[i][j] = dp[i-1][j-1]；
			如果 p.charAt(j) == '.' : dp[i][j] = dp[i-1][j-1]；
			如果 p.charAt(j) == '*'：
			如果 p.charAt(j-1) != s.charAt(i) : dp[i][j] = dp[i][j-2] //in this case, a* only counts as empty
			如果 p.charAt(i-1) == s.charAt(i) or p.charAt(i-1) == '.'：
			dp[i][j] = dp[i-1][j] //in this case, a* counts as multiple a
			or dp[i][j] = dp[i][j-1] // in this case, a* counts as single a
			or dp[i][j] = dp[i][j-2] // in this case, a* counts as empty
*/

//	class Solution {
		public static void main(String[] args) {
			String string="";
			String pat=".*";
			System.out.println(isMatch(string, pat));
			
		}
		   public  static boolean isMatch(String s,String p){
		            if (s == null || p == null) {
		                return false;
		            }
		            boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
		            dp[0][0] = true;//dp[i][j] 表示 s 的前 i 个是否能被 p 的前 j 个匹配
		            for(int i = 0; i < p.length(); i++) { // here's the p's length, not s's
		                if(p.charAt(i) == '*' && dp[0][i - 1]) {
		                    dp[0][i + 1] = true; // here's y axis should be i+1
		                }
		            }
		            for(int i = 0; i < s.length(); i++) {
		                for(int j = 0; j < p.length(); j++) {
		                    if(p.charAt(j) == '.' || p.charAt(j) == s.charAt(i)) {//如果是任意元素 或者是对于元素匹配
		                        dp[i + 1][j + 1] = dp[i][j];
		                    }
		                    if(p.charAt(j) == '*') {
		                        if(p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') {//如果前一个元素不匹配 且不为任意元素
		                            dp[i + 1][j + 1] = dp[i + 1][j - 1];
		                        }else{
		                            dp[i + 1][j + 1] = (dp[i + 1][j] || dp[i][j + 1] || dp[i + 1][j - 1]);
		                            /*
		                            dp[i][j] = dp[i-1][j] // 多个字符匹配的情况	
		                            or dp[i][j] = dp[i][j-1] // 单个字符匹配的情况
		                            or dp[i][j] = dp[i][j-2] // 没有匹配的情况
		                             */
		                            
		                        }
		                    }
		                }
		            }
		            return dp[s.length()][p.length()];
		        }
		}
//}
