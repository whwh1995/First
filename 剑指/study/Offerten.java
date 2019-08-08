package study;

import java.util.Arrays;

public class Offerten {
//	求斐波那契数列的第 n 项，n <= 39。
	public static void main(String[] args) {
		int x =findFibonacci(4);
		System.out.println(x);
	}
	public static int findFibonacci(int n) {
		if(n<=1) {
			return n;
		}
		int start=0;
		int last=1;
		int fibo=0;
		for(int i=2;i<=n;i++){
			fibo=start+last;
			start=last;
			last=fibo;
		}
		return fibo;
	}

//青蛙跳台阶和小矩形覆盖大矩形都是斐波那契数列

//我们可以用 2*1 的小矩形横着或者竖着去覆盖更大的矩形。请问用 n 个 2*1 的小矩形无重叠地覆盖一个 2*n 的大矩形，总共有多少种方法？
public int RectCover(int n) {
    if (n <= 2)
        return n;
    int pre2 = 1, pre1 = 2;
    int result = 0;
    for (int i = 3; i <= n; i++) {
        result = pre2 + pre1;
        pre2 = pre1;
        pre1 = result;
    }
    return result;
}
//一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级。求该青蛙跳上一个 n 级的台阶总共有多少种跳法
public int JumpFloor(int n) {
    if (n <= 2)
        return n;
    int pre2 = 1, pre1 = 2;
    int result = 1;

    for (int i = 2; i < n; i++) {
        result = pre2 + pre1;
        pre2 = pre1;
        pre1 = result;
    }
    return result;
}
//只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级... 它也可以跳上 n 级。求该青蛙跳上一个 n 级的台阶总共有多少种跳法
//动态规划
public int JumpFloorII(int target) {
    int[] dp = new int[target];
    Arrays.fill(dp, 1);
    for (int i = 1; i < target; i++)
        for (int j = 0; j < i; j++)
            dp[i] += dp[j];
    return dp[target - 1];
}
/*跳上 n-1 级台阶，可以从 n-2 级跳 1 级上去，也可以从 n-3 级跳 2 级上去...，那么

f(n-1) = f(n-2) + f(n-3) + ... + f(0)
同样，跳上 n 级台阶，可以从 n-1 级跳 1 级上去，也可以从 n-2 级跳 2 级上去... ，那么

f(n) = f(n-1) + f(n-2) + ... + f(0)
综上可得

f(n) - f(n-1) = f(n-1)
即

f(n) = 2*f(n-1)
所以 f(n) 是一个等比数列*/

public int JumpFloorII2(int target) {
    return (int) Math.pow(2, target - 1);
}






















}