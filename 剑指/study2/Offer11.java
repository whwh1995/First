package study2;

public class Offer11 {
	/*把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。

	例如数组 {3, 4, 5, 1, 2} 为 {1, 2, 3, 4, 5} 的一个旋转，该数组的最小值为 1。
	*/
	public int findMin(int[] nums) throws Exception {
		if (nums==null)
			throw new Exception("invalid array");
		int index1=0;
		int index2=nums.length-1;
		int mid=index1;
		while(nums[index1]>=nums[index2]) {
			if(index2-index1==1) {
				mid=index2;
				break;
			}
			mid =(index1+index2)/2;
			if(nums[mid]>=nums[index1]) {
				index1=mid;
			}else {
				index2=mid;
			}
			/*如果数组元素允许重复的话，那么就会出现一个特殊的情况：nums[l] == nums[m] == nums[h]，
			   那么此时无法确定解在哪个区间，需要切换到顺序查找。
			  例如对于数组 {1,1,1,0,1}，l、m 和 h 指向的数都为 1，此时无法知道最小数字 0 在哪个区间。*/
			if(nums[index1]==nums[mid]&&nums[index2]==nums[mid]){
				return MinInOrder(nums,index1,index2);
			}
		}
		return nums[mid];	
	}
	public int MinInOrder(int[] nums,int index1,int index2) {
		int result=nums[index1];
		for(int i=index1;i<=index2;i++) {
			if(nums[i]<result) {
				result=nums[i];
			}
		}
		return result;
	}
}
