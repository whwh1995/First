package 子序列问题;

public class 最大子序列和 {
	boolean isInvalid=false;
	public int FindGreatestSumOfSubArray(int[] nums) {
	    if (nums == null || nums.length == 0) {
	    	isInvalid=true;
	        return 0;  	
	        }
	    int greatestSum = Integer.MIN_VALUE;
	    int sum = 0;
	    for (int val : nums) {
	        sum = sum <= 0 ? val : sum + val;
	        greatestSum = Math.max(greatestSum, sum);
	    }
	    return greatestSum;
	}
}
