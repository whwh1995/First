import java.util.Stack;

public class 计算器 {
	public static int calculate(String s) {
	    int res = 0, d = 0;
		char sign = '+';
		Stack<Integer> nums=new Stack<>();
		for (int i = 0; i < s.length(); ++i) {
		   if (s.charAt(i) >= '0') {//加减乘除和空格ASCII码都小于'0'
		       d = d * 10 - '0' + s.charAt(i);//进位(先减法)
		   }
		   if ((s.charAt(i)< '0' && s.charAt(i) != ' ') || i == s.length() - 1) {
		       if (sign == '+') {
		           nums.push(d);
		       } else if (sign == '-') {
		           nums.push(-d);
		       } else if (sign == '*' || sign == '/') {
		           int tmp = sign == '*' ? nums.peek() * d : nums.peek() / d;
		           nums.pop();
		           nums.push(tmp);
		       }
		       sign = s.charAt(i); //保存当前符号
		       d = 0;
		   }
		}
		for (; !nums.empty(); nums.pop()) {
		   res += nums.peek();
		}
		return res;
	}
}
