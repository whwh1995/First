package 数组操作;

public class 删除排序数组中的重复项2 {
//	给定一个排序数组，你需要在原地删除重复出现的元素，
//	使得每个元素最多出现两次，返回移除后数组的新长度。
//	不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
	class Solution {
	    public int removeDuplicates(int[] nums) {
	        if(nums.length <= 2) 
	            return nums.length;
	        
	        int index = 1;
	        for(int i = 2; i < nums.length; i++){
	            if(nums[i] != nums[index-1])
	                nums[++index] = nums[i];
	        }
	        
	        return index+1;
	    }
	}
	
	//一个重复项
	class Solution1{
	    public int removeDuplicates(int[] nums) {
	        int index=1;
	        for(int i=1;i<nums.length;i++){
	            if(nums[i]!=nums[i-1])
	            {
	                nums[index]=nums[i];
	                index++;
	            }
	        }
	        return index;
	    }
	}
}
