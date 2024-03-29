package 动态规划;

public class 目标和 {
/*	给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。

	返回可以使最终数组和为目标数 S 的所有添加符号的方法数。

	示例 1:

	输入: nums: [1, 1, 1, 1, 1], S: 3
	输出: 5
	解释: 

	-1+1+1+1+1 = 3
	+1-1+1+1+1 = 3
	+1+1-1+1+1 = 3
	+1+1+1-1+1 = 3
	+1+1+1+1-1 = 3

	一共有5种方法让最终目标和为3。
	*/

	// 在某个解中正数和为x，负数和的绝对值为y，则x+y=sum，x-y=S，解得x=(sum+S)/2
    public int findTargetSumWays(int[] nums, int S) {
        int sum=0;
        for(int n:nums)
            sum+=n;
        return sum<S||(S+sum)%2>0?0:subsetSum(nums,(S+sum)>>1);
    }
    public int subsetSum(int[] nums,int s){
        int[] dp=new int[s+1];
        dp[0]=1;
        for(int n:nums){
            for(int i=s;i>=n;i--){
                dp[i]+=dp[i-n];
            }
        }
        return dp[s];
    }
}
