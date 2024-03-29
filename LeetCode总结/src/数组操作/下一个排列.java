package 数组操作;

public class 下一个排列 {
	/*实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。

	如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。

	必须原地修改，只允许使用额外常数空间。

	以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
	1,2,3 → 1,3,2
	3,2,1 → 1,2,3
	1,1,5 → 1,5,1*/
	/*
	若从尾到头都是递增的，则无下一个排列。
	先找到不是第一个不是递增的数则是要交换的数。
	从后部递增的序列中找到第一个大于交换的数，（若小于交换了变小了）
	因为交换后后部仍是递增数，因为交换的位，位数比较大，已经比原数大。
	尾部递增序列要变递减序列，小数在前大数在后才是最小的。
	*/
	  public void nextPermutation(int[] nums) {
	        int i = nums.length - 2;
	        while (i >= 0 && nums[i + 1] <= nums[i]) {
	            i--;
	        }
	        if (i >= 0) {
	            int j = nums.length - 1;
	            while (j >= 0 && nums[j] <= nums[i]) {
	                j--;
	            }
	            swap(nums, i, j);
	        }
	        reverse(nums, i + 1);
	    }

	    private void reverse(int[] nums, int start) {
	        int i = start, j = nums.length - 1;
	        while (i < j) {
	            swap(nums, i, j);
	            i++;
	            j--;
	        }
	    }

	    private void swap(int[] nums, int i, int j) {
	        int temp = nums[i];
	        nums[i] = nums[j];
	        nums[j] = temp;
	    }
}
