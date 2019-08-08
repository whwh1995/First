package 子序列问题;

import java.util.HashMap;

public class 和为K的子数组 {
/*	给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。

	示例 1 :

	输入:nums = [1,1,1], k = 2
	输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
	*/
	class Solution {
	    public int subarraySum(int[] nums, int k) {
	        HashMap<Integer,Integer> map=new HashMap<>();
	        int sum=0;
	        int count=0;
	        map.put(0,1);
	        for(int num:nums){
	            sum+=num;
	            int tmp=sum-k;
	            if(map.containsKey(tmp)){
	                count+=map.get(tmp);
	            }
	            map.put(sum,map.getOrDefault(sum,0)+1);
	        }
	        return count;
	    }
	}
}
