package ÅÅĞòËã·¨;

public class BubbleSort {
	
	public void bubbleSort(int[] nums) {
		int len=nums.length;
		for(int i=0;i<len-1;i++) {
			boolean change=false;
			for(int j=i;j<len-1-i;j++) {
				if(nums[j+1]<nums[j]) {
					int temp=nums[j];
					nums[j]=nums[j+1];
					nums[j+1]=temp;
					change=true;
				}
				if(change==false)
					break;
			}
		}
	}
}
