package Study6;

public class Offer53 {
	/*Input:
		nums = 1, 2, 3, 3, 3, 3, 4, 6
		K = 3

		Output:
		4*/
	//ดํมห
	public int GetNumberOfK(int[] nums, int K) {
	    int first = binarySearch(nums, K);
	    int last = binarySearch(nums, K + 1);
	    return (first == nums.length || nums[first] != K) ? 0 : last - first;
	}

	private int binarySearch(int[] nums, int K) {
	    int l = 0, h = nums.length;
	    while (l < h) {
	        int m = l + (h - l) / 2;
	        if (nums[m] >= K)
	            h = m;
	        else
	            l = m + 1;
	    }
	    return l;
	}
	
	
	class Solution {
	    // returns leftmost (or rightmost) index at which `target` should be
	    // inserted in sorted array `nums` via binary search.
	    private int extremeInsertionIndex(int[] nums, int target, boolean left) {
	        int lo = 0;
	        int hi = nums.length;

	        while (lo < hi) {
	            int mid = (lo + hi) / 2;
	            if (nums[mid] > target || (left && target == nums[mid])) {
	                hi = mid;
	            }
	            else {
	                lo = mid+1;
	            }
	        }

	        return lo;
	    }

	    public int[] searchRange(int[] nums, int target) {
	        int[] targetRange = {-1, -1};

	        int leftIdx = extremeInsertionIndex(nums, target, true);

	        // assert that `leftIdx` is within the array bounds and that `target`
	        // is actually in `nums`.
	        if (leftIdx == nums.length || nums[leftIdx] != target) {
	            return targetRange;
	        }

	        targetRange[0] = leftIdx;
	        targetRange[1] = extremeInsertionIndex(nums, target, false)-1;

	        return targetRange;
	    }
	}

	
}
