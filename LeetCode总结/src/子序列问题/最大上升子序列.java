package 子序列问题;

public class 最大上升子序列 {
	/*给定一个无序的整数数组，找到其中最长上升子序列的长度

	示例:

	输入: [10,9,2,5,3,7,101,18]
	输出: 4 
	解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4?
	*/
	 public int lengthOfLIS(int[] nums) {
	        if(nums==null||nums.length==0)
	            return 0;
	        int len=nums.length;
	        int[] dp=new int[len];
	        dp[0]=nums[0];
	        int end=0;
	        for(int i=1;i<len;i++){
	            if(nums[i]>dp[end]){
	                end++;
	                dp[end]=nums[i];
	            }else{
	                int left=0;
	                int right=end;
	                while(left<right){
	                    int mid=(left+right)/2;
	                    if(dp[mid]<nums[i]){
	                        left=mid+1;
	                    }else{
	                        right=mid;
	                    }
	                }
	                dp[right]=nums[i];
	            }
	        }
	        return end+1;
	    }
}
