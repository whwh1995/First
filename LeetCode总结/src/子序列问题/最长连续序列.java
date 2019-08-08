package 子序列问题;

import java.util.HashSet;
import java.util.Set;

public class 最长连续序列 {
	/*给定一个个未排序的整数数组，找出最长连续序列的长度

	要求算法的时间复杂度为 O(n)?

	示例:

	输入: [100, 4, 200, 1, 3, 2]
	输出: 4
	解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4?
*/
	public int longestConsecutive(int[] nums) {
        Set<Integer> set= new HashSet<Integer>();
        for(int num:nums){
            set.add(num);
        }
        int max=0;
        for(int num:set){
            if(!set.contains(num-1)){
                int start=num;
                int current=1;
                while(set.contains(++start)){
                    current++;
                }
                max=Math.max(current,max);
            }
        }
        return max;
    }
}
