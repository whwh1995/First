package 动态规划;

public class 分割等和子集动归 {
	/*给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。

	注意:

	每个数组中的元素不会超过 100
	数组的大小不会超过 200
	示例 1:

	输入: [1, 5, 11, 5]

	输出: true

	解释: 数组可以分割成 [1, 5, 5] 和 [11].
	 

	示例 2:

	输入: [1, 2, 3, 5]

	输出: false

	解释: 数组不能分割成两个元素和相等的子集.*/
	 public boolean canPartition(int[] nums) {
         //动态规划，背包问题，从nums中选择一部分数字组合，填满容量为sum/2的背包 
       int n=nums.length;
       if(n == 0){
           return false;
       }
       
       //确定背包c的大小
       int sum = 0;
       for(int i=0; i<n; i++){
           sum+=nums[i];
       }
       int c = sum/2; 
       
       //两个相等的整数的和一定为偶数
       if(sum%2==1){
           return false;
       }
       
       //动态规划
       //明确状态：dp[m][n] 考虑是否将第m个数字放入容量为n的背包 
       boolean[][] dp = new  boolean[n][c+1];
       
       //状态初始化
       for(int i=0; i<=c; i++){
           if(i!=nums[0]){
               dp[0][i] = false;
           }else{
               dp[0][i] = true;
           }
       }
       
       //状态转移方程：dp[m][n] = dp[m-1][n] || dp[m-1][n-nums[m]]
       for(int i=1; i<n; i++){
           for(int j=0; j<=c; j++){
               dp[i][j] = dp[i-1][j];
               if(nums[i]<=j){
                   dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]];                    
               }
               
           }
       }
       
       return dp[n-1][c];       
   
   }
}
