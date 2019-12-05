package 二分分治;

public class 旋转排序数组的最小值 {
	/*
	 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。

	( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。

	请找出其中最小的元素。

	注意数组中可能存在重复的元素。

	示例 1：

	输入: [1,3,5]
	输出: 1
	*/

	class Solution {
	    public int findMin(int[] nums) {
	        int lo = 0, hi = nums.length-1;
	        while(lo < hi) {
	            int mid = lo+(hi-lo)/2;
	            if(nums[mid] > nums[hi])
	                lo = mid+1;
	            else if(nums[mid] < nums[hi])
	                hi = mid;
	            else
	                hi--;
	        }
	        return nums[lo];
	    }
	}
}
