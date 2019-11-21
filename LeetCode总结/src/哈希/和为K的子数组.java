package 哈希;

import java.util.HashMap;


//  进一步扩展相同的想法，如果累计总和，在索引 i 和 j 处相差 k，
//  即 sum[i] - sum[j] = k位于索引 i 和 j 之间的元素之和是 k.
public class 和为K的子数组 {
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
