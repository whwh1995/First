package 位运算;

public class 比特位计数 {
	/*给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。

	示例 1:

	输入: 2
	输出: [0,1,1]
	示例 2:

	输入: 5
	输出: [0,1,1,2,1,2]*/
	    public int[] countBits(int num) {
	        int[] res=new int[num+1];
	        for(int i = 1; i <= num; ++ i) {
	            res[i] = res[i&(i-1)] + 1;
	        }
	        return res;
	    }
	    
	
	public int[] countBits1(int num) {
		int[] result=new int[num+1];
		for(int i = 1; i <= num; i++){
			if(i % 2 == 1)
				result[i] = result[i-1] + 1;
			else
				result[i] = result[i/2];
		}
    
    return result;
}


}
