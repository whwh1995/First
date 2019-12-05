package study5;

public class Offer46_____ {
//	把数字翻译成字符串
	/*给定一个数字，按照如下规则翻译成字符串：1 翻译成“a”，2 翻译成“b”... 26 翻译成“z”。
	一个数字有多种翻译可能，例如 12258 一共有 5 种，分别是 abbeh，lbeh，aveh，abyh，lyh。
	实现一个函数，用来计算一个数字有多少种不同的翻译方法。 
	 原题目为0开始。
	*/
	//此处f(i)为前i位有f(i)种方法。f(i)=f(i-1)+g(i,i-1)f(i-2);
	public int numDecodings(String s) {
		if (s == null || s.length() == 0)
	        return 0;
	    int n = s.length();
	    int[] dp = new int[n + 1];
	    dp[0] = 1; //  赋值为1 ，因为第2位 f(2)=f(1)+g(1,2)f(0);
	    dp[1] = s.charAt(0) == '0' ? 0 : 1;
	    for (int i = 2; i <= n; i++) {
	        int one = Integer.valueOf(s.substring(i - 1, i));
	        if (one != 0)
	            dp[i] += dp[i - 1];
	        if (s.charAt(i - 2) == '0')
	            continue;
	        int two = Integer.valueOf(s.substring(i - 2, i));
	        if (two <= 26)
	            dp[i] += dp[i - 2];
	    }
	    return dp[n];
	}
	//f(i)=f(i+1)+g(i,i+1)f(i+2)  动态规划  ，从前往后 会重复计算。f(i)为从第i位开始有f(i)种
	public int getTranslationCount(int number) {
        if(number<0)
            return 0;
        String sNumber=String.valueOf(number);
        int len=sNumber.length();
        int[] counts=new int[len];
        for(int i=len-1;i>=0;i--) {
            if(i==len-1) {
                counts[i]=1;
            }else {
                counts[i]=counts[i+1];
                if(canBeTrans(sNumber,i)) {
                    if(i==len-2)
                        counts[i]+=1;
                    else
                        counts[i]+=counts[i+2];
                }
            }
        }
        return counts[0];
    }
 
    private boolean canBeTrans(String sNumber, int i) {
        int a=sNumber.charAt(i)-'0';
        int b=sNumber.charAt(i+1)-'0';
        int convert=a*10+b;
        if(convert>=10 && convert<=25)
            return true;
        return false;
    }
	
	
}
