package study2;

public class Offer15 {
//	输入一个整数，输出该数二进制表示中 1 的个数。
//	位运算
	public int NumberOf1(int n) {
	    int cnt = 0;
	    while (n != 0) {
	        cnt++;
	        n &= (n - 1);
	    }
	    return cnt;
	}
}
