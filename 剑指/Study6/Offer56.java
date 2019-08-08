package Study6;

public class Offer56 {
//	给定整数数组，除了两个元素之外，每个元素都出现二次。 找到那两个只出现一次的数
	public void FindNumsAppearOnce(int[] nums, int num1[], int num2[]) {
	    int diff = 0;
	    for (int num : nums)
	        diff ^= num;
	    diff &= -diff;
	    for (int num : nums) {
	        if ((num & diff) == 0)
	            num1[0] ^= num;
	        else
	            num2[0] ^= num;
	    }
	}
//	给定整数数组，除了一个元素之外，每个元素都出现三次。 找到那个只出现一次的数
	 public int singleNumber(int[] nums) {
	        // 对每一位单独统计出现1的次数, 如果出现的次数不能整除3说明唯一存在的数在这一位上为1, 时间复杂度O(32N)
	        int ret = 0;
	        for(int i = 0; i < 32; ++i) {
	            int bitnums = 0;
	            int bit = 1 << i;
	            for(int num : nums) {
	                if((num&bit) != 0)
	                    bitnums++;
	            }
	            if(bitnums % 3 != 0)
	                ret |= bit;
	        }
	        return ret;
	    }
}
