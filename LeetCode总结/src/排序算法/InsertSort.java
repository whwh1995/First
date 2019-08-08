package ÅÅĞòËã·¨;

public class InsertSort {
	public void insertSort(int[] nums) {
		int j;
		for(int i=1;i<nums.length;i++) {
			int num=nums[i];
			for(j=i;j>0&&num<nums[j-1];j--) {
				nums[j]=nums[j-1];
			}
			nums[j]=num;
		}
}
}
