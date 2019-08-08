package Study7;

public class Offer63 {
//	可以有一次买入和一次卖出，那么买入必须在前。求最大收益。
	public int maxProfit(int[] prices) {
	    if (prices == null || prices.length == 0)
	        return 0;
	    int soFarMin = prices[0];
	    int maxProfit = 0;
	    for (int i = 1; i < prices.length; i++) {
	        soFarMin = Math.min(soFarMin, prices[i]);
	        maxProfit = Math.max(maxProfit, prices[i] - soFarMin);
	    }
	    return maxProfit;
	}
}
