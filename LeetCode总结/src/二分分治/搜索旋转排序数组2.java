package 二分分治;

public class 搜索旋转排序数组2 {
/*	假设按照升序排序的数组在预先未知的某个点上进行了旋转。

	( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。

	编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。

	示例 1:

	输入: nums = [2,5,6,0,0,1,2], target = 0
	输出: true
	示例 2:

	输入: nums = [2,5,6,0,0,1,2], target = 3
	输出: false
	*/
	class Solution {
	    public boolean search(int[] nums, int target) {
	    	int left = 0;
	        int right = nums.length - 1;
	        while (left <= right) {
	            int mid = left + (right - left) / 2;
	            if (nums[mid] == target) 
	            	return true;
	            if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
	                left++;
	                right--;     //[1,3,1,1,1]
	            } else if (nums[left] <= nums[mid]) {
	                if (nums[left] <= target && target < nums[mid]) 
	                    right = mid - 1;
	                else 
	                    left = mid + 1;
	            } else {
	                if (nums[mid] < target && target <= nums[right]) 
	                    left = mid + 1;
	                else 
	                    right = mid - 1;
	            }
	        }
	        return false;  
	    }
	}

}
