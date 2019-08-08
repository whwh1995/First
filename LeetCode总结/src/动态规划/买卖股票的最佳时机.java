package 动态规划;

public class 买卖股票的最佳时机 {
	class Solution {
	    public int maxProfit(int[] prices) {
	        if(prices.length<=1)
	            return 0;
	        int min =prices[0];
	        int sum=0;
	        for(int i=1;i<prices.length;i++){
	            sum=Math.max(prices[i]-min,sum);
	            min=Math.min(prices[i],min);
	        }
	        return sum;
	    }
	}
}
