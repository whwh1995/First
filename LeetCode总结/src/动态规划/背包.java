package 动态规划;

public class 背包 {
	
	/* 0-1背包
    * @param val 价值
    * @param weight 重量
    * @param W 背包容量
    * @return 最优解
    */
   public static int knapsack(int[] val, int[] weight, int W) {
       int N = weight.length;   //记录所有的物品数
       int[][] V = new int[N + 1][W + 1];  //创建背包矩阵
       for (int col = 0; col <= W; col++) { //列，背包容量为0
           V[0][col] = 0;
       }
       for (int row = 0; row <= N; row++) {
           V[row][0] = 0;
       }
       for (int item = 1; item <= N; item++) {  //一行一行填充值
           for (int wt = 1; wt <= W; wt++) {  //一列一列填充值
               if (weight[item - 1] <= wt) {  //如果当前物品重量小于等于背包中的当前重量 item为1是，weight[0]是第一个物品的重量
                   //比较不加入该物品时该重量的最大价值（前一行）与当前物品的价值+可以容纳的剩余重量的价值
                   V[item][wt] = Math.max(val[item-1] + V[item-1][wt - weight[item-1]],V[item-1][wt]);
               } else { //如果当前物品重量大于背包中的当前重量
                   V[item][wt]=V[item-1][wt];  //直接使用前一行的最优解
               }
           }
       }
       return V[N][W];

	}
   
   
   //0-1背包 （必须装满）
   public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] weight = {3,5,2,6,4}; //物品重量
		int[] val = {4,4,3,5,3}; //物品价值
		int m = 12; //背包容量
		int n = val.length; //物品个数
		
		int[] f = new int[m+1];
		for(int i=1;i<f.length;i++){ 	//必装满则f[0]=0,f[1...m]都初始化为无穷小
			f[i] = Integer.MIN_VALUE;
		}
		for(int i=0;i<n;i++){
			for(int j=f.length-1;j>=weight[i];j--){
				f[j] = Math.max(f[j], f[j-weight[i]]+val[i]);
			}
		}
		for(int i=0;i<f.length;i++){
			System.out.print(f[i]+" ");
		}
		System.out.println();
		System.out.println("最大价值为"+f[f.length-1]);
	}

   //完全背包
   public static void main1(String[] args){
	   int[] weight = {3,4,6,2,5};
	   int[] val = {6,8,7,5,9};
	   int maxw = 10;
	   int[] f = new int[maxw+1];
	   for(int i=0;i<f.length;i++){
		   f[i] = 0;
	   }
	   for(int i=0;i<val.length;i++){
		   for(int j=weight[i];j<f.length;j++){
			   f[j] = Math.max(f[j], f[j-weight[i]]+val[i]);
		   }
	   }
	   System.out.println(f[maxw]);
  }

}
