package 二分分治;

public class 两数相除 {
	class Solution {
	    public int divide(int dividend, int divisor) {
	        boolean sign = (dividend > 0) ^ (divisor > 0);
	        int result = 0;
	        if(dividend>0) {
	            dividend = -dividend;
	        }
	        if(divisor>0) 
	            divisor = -divisor;
	        while(dividend <= divisor) {
	            int temp_result = -1;
	            int temp_divisor = divisor;
	            while(dividend <= (temp_divisor << 1)) {
	                if(temp_divisor <= (Integer.MIN_VALUE >> 1))//考虑-2147483648 -1
	                    break;
	                temp_result = temp_result << 1;
	                temp_divisor = temp_divisor << 1;
	            }
	            dividend = dividend - temp_divisor;
	            result += temp_result;
	        }
	        if(!sign) {
	            if(result <= Integer.MIN_VALUE) 
	            	return Integer.MAX_VALUE; //考虑-2147483648 -1
	            result = - result;
	        }
	        return result;
	    }
	}
}
