package study2;

public class Offer16 {
//给定一个 double 类型的浮点数 base 和 int 类型的整数 exponent，求 base 的 exponent 次方。
//	应该考虑 次方是正数还是负数。同时负数时还要考虑底数是否为0；因为0的负次方为意义；
	
/*	因为X^n=x^n/2+x*n/2 n%2=0
	    X^n=x^n/2+x*n/2*x n%2=1	
	    所以可以考虑递归
*/	public double Power(double base, int exponent) {
	    if (exponent == 0)
	        return 1;
	    if (exponent == 1)
	        return base;
	    boolean isNegative = false;
	    if (exponent < 0) {
	        exponent = -exponent;
	        isNegative = true;
	    }
	    double pow = Power(base * base, exponent / 2);
	    if (exponent % 2 != 0)
	        pow = pow * base;
	    return isNegative ? 1 / pow : pow;
	}
}
