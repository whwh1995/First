package 滑动窗口;

public class 滑动窗口最大值 {
	/*给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
	你只可以看到在滑动窗口 k 内的数字。滑动窗口每次只向右移动一位。

	返回滑动窗口最大值。*/
	
}
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
   if (nums == null || nums.length == 0 || nums.length < k) {
           return new int[0];
       }

       int[] ret = new int[nums.length - k + 1];
       int max = Integer.MIN_VALUE, m = 0, left = 0, right = 0;
       for ( ; right < k; right++) {
           if (nums[right] >= max) {
               max = nums[right];
               m = right;
           }
       }
       ret[0] = max;

       for ( ; right < nums.length; right++) {
           if (nums[right] >= max) {
               max = nums[right];
               m = right;
           }
           if (m < right - k + 1) {
               max = Integer.MIN_VALUE;
               for (left = right - k + 1; left <= right; left++) {
                   if (nums[left] >= max) {
                       max = nums[left];
                       m = left;
                   }
               }
           }
           ret[right - k + 1] = max;
       }

       return ret;
}
}