package 二分分治;

import java.util.ArrayList;

public class 最小的K个数 {
//	最小的 K 个数
/*	快速选择
	复杂度：O(N) + O(1)
	只有当允许修改数组元素时才可以使用*/
	public ArrayList<Integer> GetLeastNumbers_Solution(int[] nums, int k) {
	    ArrayList<Integer> ret = new ArrayList<>();
	    if (k > nums.length || k <= 0)
	        return ret;
	    findKthSmallest(nums, k - 1);
	    /* findKthSmallest 会改变数组，使得前 k 个数都是最小的 k 个数 */
	    for (int i = 0; i < k; i++)
	        ret.add(nums[i]);
	    return ret;
	}

	public void findKthSmallest(int[] nums, int k) {
	    int l = 0, h = nums.length - 1;
	    while (l < h) {
	        int j = partition(nums, l, h);
	        if (j == k)
	            break;
	        if (j > k)
	            h = j - 1;
	        else
	            l = j + 1;
	    }
	}

	private int partition(int[] nums, int l, int h) {
	    int p = nums[l];     /* 切分元素 */
	    int i = l, j = h + 1;
	    while (true) {
	        while (i != h && nums[++i] < p) ;
	        while (j != l && nums[--j] > p) ;
	        if (i >= j)
	            break;
	        swap(nums, i, j);
	    }
	    swap(nums, l, j);
	    return j;
	}

	private void swap(int[] nums, int i, int j) {
	    int t = nums[i];
	    nums[i] = nums[j];
	    nums[j] = t;
	}
}
