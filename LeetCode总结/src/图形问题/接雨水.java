package 图形问题;

public class 接雨水 {
	/*给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。



	上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。


	链接：https://leetcode-cn.com/problems/trapping-rain-water
	*/
	class Solution {
	    public int trap(int[] height) {
	         int num =0;
	        int max=0;
	        int index=0;
	        //1 找到最高的那个
	        for (int i = 0; i <height.length ; i++) {
	            if(max<height[i]){
	                max=height[i];
	                index=i;
	            }
	        }
	        //2.从左往右接水
	        int left=0;
	        for (int i = 0; i < index; i++) {
	            if(left>height[i]){
	                num=num+left-height[i];
	            }else {
	                left=height[i];
	            }
	        }
	        //3.从右往左接水
	        int right=0;
	        for (int i = height.length-1; i >index ; i--) {
	            if(right>height[i]){
	                num= num+right-height[i];
	            }else {
	                right=height[i];
	            }
	        }
	        return num;
	    }
	}

}
