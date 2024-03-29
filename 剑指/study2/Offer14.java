package study2;

public class Offer14 {
	/*把一根绳子剪成多段，并且使得每段的长度乘积最大。

	n = 2
	return 1 (2 = 1 + 1)

	n = 10
	return 36 (10 = 3 + 3 + 4)*/
	
	/*贪心
	尽可能多剪长度为 3 的绳子，并且不允许有长度为 1 的绳子出现。
	如果出现了，就从已经切好长度为 3 的绳子中拿出一段与长度为 1 的绳子重新组合，把它们切成两段长度为 2 的绳子。

	证明：当 n >= 5 时，3(n - 3) - n = 2n - 9 > 0，且 2(n - 2) - n = n - 4 > 0。
	因此在 n >= 5 的情况下，将绳子剪成一段为 2 或者 3，得到的乘积会更大。
	又因为 3(n - 3) - 2(n - 2) = n - 5 >= 0，所以剪成一段长度为 3 比长度为 2 得到的乘积更大。*/
	public int integerBreak(int n) {
	    if (n < 2)
	        return 0;
	    if (n == 2)
	        return 1;
	    if (n == 3)
	        return 2;
	    int timesOf3 = n / 3;
	    if (n - timesOf3 * 3 == 1)
	        timesOf3--;
	    int timesOf2 = (n - timesOf3 * 3) / 2;
	    return (int) (Math.pow(3, timesOf3)) * (int) (Math.pow(2, timesOf2));
	}
	
//	动态规划
	public int breakMax(int n) {
		if(n<2)
			return 0;
		if(n==2)
			return 1;
		if(n==3)
			return 2;
		int[] value=new int[n+1];
		value[0]=0;
		value[1]=0;
		value[2]=1;
		value[3]=2;
		int max=0;
		for(int i=4;i<=n;i++) {
			for(int j=1;j<=i;j++) {
				n=value[j]*value[i-j];
				if(n>max)
					max=n;
				value[i]=max;
			}
		}		
		return value[n]; 		
	}
	
}
