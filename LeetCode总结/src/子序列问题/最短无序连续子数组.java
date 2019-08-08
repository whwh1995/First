package 子序列问题;

public class 最短无序连续子数组 {
	/*给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。

	你找到的子数组应是最短的，请输出它的长度。

	示例 1:

	输入: [2, 6, 4, 8, 10, 9, 15]
	输出: 5
	解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。*/
	class Solution {
	    public int findUnsortedSubarray(int[] nums) {
	       int length = nums.length;
	        int i=0; int j=length-1;
	        while(i<j){
	            if(nums[i+1] >= nums[i]){
	                i++;
	            }else{
	                break;
	            }

	        }
	        while(i<j){
	            if(nums[j-1] <= nums[j]){
	                j--;
	            }else{
	                break;
	            }

	        }
	        if(i==j) return 0;
	        int min = nums[i];
	        int max = nums[i];
	        for(int k=i+1; k<=j; k++){
	            min = Math.min(nums[k], min);
	            max = Math.max(nums[k], max);
	        }

	        while(--i>=0){
	            if(nums[i]<=min)
	                break;
	        }
	        while(++j<=length-1){
	            if(nums[j]>=max)
	                break;
	        }

	        return j-i-1;
	    }
	}
}
