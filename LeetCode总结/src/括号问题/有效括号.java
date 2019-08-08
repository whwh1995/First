package 括号问题;

import java.util.Stack;

public class 有效括号 {
	/*给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

	有效字符串需满足：

	左括号必须用相同类型的右括号闭合。
	左括号必须以正确的顺序闭合。
	注意空字符串可被认为是有效字符串。

	示例 1:

	输入: "()"
	输出: true
	示例 2:

	输入: "()[]{}"
	输出: true
	示例 3:

	输入: "(]"
	输出: false
	示例 4:

	输入: "([)]"
	输出: false*/
	class Solution {
	    public boolean isValid(String s) {
	        Stack<Character> stack =new Stack<Character>();
	        char[] ch =s.toCharArray();
	        for(int i=0;i<ch.length;i++){
	            if(stack.size()==0){
	                stack.push(ch[i]);
	            }else if(isComb(stack.peek(),ch[i])){
	                stack.pop();
	            }else{
	                stack.push(ch[i]);
	            }
	        }
	        return stack.size()==0;
	    }
	    public boolean isComb(char a,char b){
	        return (a=='['&&b==']')||(a=='{'&&b=='}')||(a=='('&&b==')');
	    }
	}
}
