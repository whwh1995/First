package 二分分治;

public class 平方根 {
	public class Solution {

	    public int mySqrt(int x) {
	        long left = 0;
	        long right = Integer.MAX_VALUE;
	        while (left < right) {
	            // 这种取中位数的方法又快又好，是我刚学会的，原因在下面这篇文章的评论区
	            // https://www.liwei.party/2019/06/17/leetcode-solution-new/search-insert-position/
	            // 注意：这里得用无符号右移
	            long mid = (left + right + 1) >>> 1;
	            long square = mid * mid;
	            if (square > x) {
	                right = mid - 1;
	            } else {
	                left = mid;
	            }
	        }
	        return (int) left;
	    }
	}
//牛顿法
	
	public class niudun {

	    public int mySqrt(int a) {
	        long x = a;
	        while (x * x > a) {
	            x = (x + a / x) / 2;
	        }
	        return (int) x;
	    }
	}
}
