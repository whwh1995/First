package ÅÅĞòËã·¨;

public class ShellSort {
	public static void shellSort(int[] nums) {
		for(int gap=nums.length/2;gap>0;gap/=2) {
			for(int i=gap;i<nums.length;i++) {
				if(nums[i]<nums[i-gap]) {
					int tmp=nums[i];
					nums[i]=nums[i-gap];
					nums[i-gap]=tmp;
				}
			}
		}
		
	}
}
