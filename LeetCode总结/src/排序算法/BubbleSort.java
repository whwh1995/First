package ≈≈–ÚÀ„∑®;

public class BubbleSort {
	public static void main(String[] args) {
		int[] nums= {6,7,1,2,3};
		bubbleSort(nums);
		for(int i:nums) {
			System.out.println(i);
		}
	}
	public static void bubbleSort(int[] nums) {
		int len=nums.length;
		for(int i=0;i<len-1;i++) {
			boolean change=false;
			for(int j=0;j<len-1-i;j++) {
				if(nums[j+1]<nums[j]) {
					int temp=nums[j];
					nums[j]=nums[j+1];
					nums[j+1]=temp;
					change=true;
				}
			}
			if(change==false)
				break;
		}
	}
}
