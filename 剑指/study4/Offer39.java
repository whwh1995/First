package study4;

public class Offer39 {
//	数组中出现次数超过一半的数字
	public int MoreThanHalfNum_Solution(int[] nums) {
	int majority = nums[0];
    for (int i = 1, cnt = 1; i < nums.length; i++) {
        cnt = nums[i] == majority ? cnt + 1 : cnt - 1;
        if (cnt == 0) {
            majority = nums[i];
            cnt = 1;
        }
    }
    int cnt = 0;                          //判断数组中是否有出现次数超过一半的数字。
    for (int val : nums)
        if (val == majority)
            cnt++;
    return cnt > nums.length / 2 ? majority : 0;
}
	
//	还有一种解法可以通过快速查找 时间复杂度同为O（N)
}
