package 图形问题;

import java.util.Arrays;

public class 最大矩形 {
	/*给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。

	示例:

	输入:
	[
	  ["1","0","1","0","0"],
	  ["1","0","1","1","1"],
	  ["1","1","1","1","1"],
	  ["1","0","0","1","0"]
	]
	输出: 6
	*/
//解法1：变为柱状图
	/*class Solution {
	    public int leetcode84(int[] heights) {
	        Stack < Integer > stack = new Stack < > ();
	        stack.push(-1);
	        int maxarea = 0;
	        for (int i = 0; i < heights.length; ++i) {
	            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i])
	                maxarea = Math.max(maxarea, heights[stack.pop()] * (i - stack.peek() - 1));
	            stack.push(i);
	        }
	        while (stack.peek() != -1)
	            maxarea = Math.max(maxarea, heights[stack.pop()] * (heights.length - stack.peek() -1));
	        return maxarea;
	    }

	    public int maximalRectangle(char[][] matrix) {

	        if (matrix.length == 0) 
	        	return 0;
	        int maxarea = 0;
	        int[] dp = new int[matrix[0].length];

	        for(int i = 0; i < matrix.length; i++) {
	            for(int j = 0; j < matrix[0].length; j++) {
	                // update the state of this row's histogram using the last row's histogram
	                // by keeping track of the number of consecutive ones
	                dp[j] = matrix[i][j] == '1' ? dp[j] + 1 : 0;
	            }
	            // update maxarea with the maximum area from this row's histogram
	            maxarea = Math.max(maxarea, leetcode84(dp));
	        } 
	        return maxarea;
	    }
	}*/
	
	
	/*解法2：想象一个算法，对于每个点我们会通过以下步骤计算一个矩形：

不断向上方遍历，直到遇到“0”，以此找到矩形的最大高度。

向左右两边扩展，直到无法容纳矩形最大高度。*/


	class Solution {

	    public int maximalRectangle(char[][] matrix) {
	        if(matrix.length == 0) return 0;
	        int m = matrix.length;
	        int n = matrix[0].length;

	        int[] left = new int[n]; // initialize left as the leftmost boundary possible
	        int[] right = new int[n];
	        int[] height = new int[n];

	        Arrays.fill(right, n); // initialize right as the rightmost boundary possible

	        int maxarea = 0;
	        for(int i = 0; i < m; i++) {
	            int cur_left = 0, cur_right = n;
	            // update height
	            for(int j = 0; j < n; j++) {
	                if(matrix[i][j] == '1') height[j]++;
	                else height[j] = 0;
	            }
	            // update left
	            for(int j=0; j<n; j++) {
	                if(matrix[i][j]=='1') left[j]=Math.max(left[j],cur_left);
	                else {left[j]=0; cur_left=j+1;}
	            }
	            // update right
	            for(int j = n - 1; j >= 0; j--) {
	                if(matrix[i][j] == '1') right[j] = Math.min(right[j], cur_right);
	                else {right[j] = n; cur_right = j;}    
	            }
	            // update area
	            for(int j = 0; j < n; j++) {
	                maxarea = Math.max(maxarea, (right[j] - left[j]) * height[j]);
	            }
	        }
	        return maxarea;
	    }
	}

	
}
