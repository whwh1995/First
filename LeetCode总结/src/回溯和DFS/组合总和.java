package 回溯和DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 组合总和 {
/*	给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合�??

	candidates 中的数字可以无限制重复被选取?

	说明：

	�?有数字（包括 target）都是正整数?
	解集不能包含重复的组合?
*/
	class Solution {
	    public List<List<Integer>> combinationSum(int[] candidates, int target) {
	        List<List<Integer>> res = new ArrayList<>();
	        Arrays.sort(candidates);
	        //System.out.println(candidates);
	        backtrack(candidates, target, res, 0, new ArrayList<Integer>());
	        return res;
	    }

	    private void backtrack(int[] candidates, int target, List<List<Integer>> res, int i, ArrayList<Integer> tmp_list) {
	        if (target < 0) return;
	        if (target == 0) {
	            res.add(new ArrayList<>(tmp_list));
	            return;
	        }
	        for (int start = i; start < candidates.length; start++) {
	            if (target < 0) break;
	            //System.out.println(start);
	            tmp_list.add(candidates[start]);
	            //System.out.println(tmp_list);
	            backtrack(candidates, target - candidates[start], res, start, tmp_list);
	            tmp_list.remove(tmp_list.size() - 1);
	        }
	    }
	}
	
}
