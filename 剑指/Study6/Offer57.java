package Study6;

import java.util.ArrayList;
import java.util.Arrays;

public class Offer57 {
//	输入一个递增排序的数组和一个数字 S，在数组中查找两个数，使得他们的和正好是 S。如果有多对数字的和等于 S，输出两个数的乘积最小的。
	public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
	    int i = 0, j = array.length - 1;
	    while (i < j) {
	        int cur = array[i] + array[j];
	        if (cur == sum)
	            return new ArrayList<>(Arrays.asList(array[i], array[j]));
	        if (cur < sum)
	            i++;
	        else
	            j--;
	    }
	    return new ArrayList<>();
	}
	
	
//	和为 S 的连续正数序列
	public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
	    ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
	    int start = 1, end = 2;
	    int curSum = 3;
	    while (end < sum) {
	        if (curSum > sum) {
	            curSum -= start;
	            start++;
	        } else if (curSum < sum) {
	            end++;
	            curSum += end;
	        } else {
	            ArrayList<Integer> list = new ArrayList<>();
	            for (int i = start; i <= end; i++)
	                list.add(i);
	            ret.add(list);
	            curSum -= start;
	            start++;
	            end++;
	            curSum += end;
	        }
	    }
	    return ret;
	}
}
