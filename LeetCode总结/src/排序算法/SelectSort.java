package ÅÅĞòËã·¨;

public class SelectSort {
	public void selectSort(int[] nums) {
		int len=nums.length;
		for(int i=0;i<len-1;i++) {
			for(int j=i+1;j<len;j++) {
				if(nums[j]<nums[i]) {
					int temp=nums[i];
					nums[i]=nums[j];
					nums[j]=temp;
				}
			}
		}
	}
}
