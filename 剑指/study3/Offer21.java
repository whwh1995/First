package study3;

public class Offer21 {
//输入一个整数数组，通过函数使所有奇数都在偶数前面。
	
	
	public void reOrderArray(int[] nums) {
		int mid=0;
		if(nums==null||nums.length==1)
			return;
		int begin=0;
		int last=nums.length-1;
		for(;;) {
			while(nums[begin]%2!=0) {  //此处的判断条件可以用一个函数抽取出来，来应对相似问题的不同条件
				begin++;
			}
			while(nums[last]%2==0) {
				last--;
			}
			if(begin<last) {
			   mid =nums[begin];
			   nums[begin]=nums[last];
			   nums[last]=mid;
			}else {
				return;
						}
			
		    	  
	}
}
}
