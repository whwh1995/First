package 回溯和DFS;

public class 类似于围棋吃子 {
	public static void main(String[] args) {
		//DFS 类似于围棋被吃
		String[][] tmp= {{"o","x","x","x"},{"o","x","o","x"},{"x","o","o","x"},{"o","x","x","x"}};
		solution(tmp);
		for(int i=0;i<tmp.length;i++) {
			for(int j=0;j<tmp.length;j++)
				System.out.print(tmp[i][j]);
			System.out.println();
		}
	}
	static int[][] dir= {{0,1},{0,-1},{1,0},{-1,0}};
	public static void solution(String[][] tmp){
		if(tmp==null||tmp.length==0)
			return;
		boolean[][] flag=new boolean[tmp.length][tmp[0].length];
		for(int i=0;i<tmp.length;i++) {
			for(int j=0;j<tmp[0].length;j++) {
				if(tmp[i][j]=="o"&&(i==tmp.length-1||i==0||j==tmp[0].length-1||j==0)) {
					backtracking(i, j, flag, tmp);
				}
				}
			}
		for(int i=0;i<tmp.length;i++) {
			for(int j=0;j<tmp[0].length;j++) {
				if(!flag[i][j])
					tmp[i][j]="x";
			}
		}
		}
	public static void backtracking(int i,int j,boolean[][] flag,String[][] tmp) {
		if(i<0||i>=tmp.length||j<0||j>=tmp[0].length)
			return;
		if(flag[i][j]==true)
			return;
		if(tmp[i][j]=="x")
			return;
		flag[i][j]=true;
		for(int[] d:dir) {
				backtracking(i+d[0], j+d[1], flag, tmp);
			}
		}
		
}
