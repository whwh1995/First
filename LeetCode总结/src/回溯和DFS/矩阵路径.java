package 回溯和DFS;

public class 矩阵路径 {
	/*请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一个格子开始，
	每一步可以在矩阵中向左，向右，向上，向下移动一个格子。如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
	例如下面的矩阵包含了一条 bfce 路径。*/
	private final static int[][] next = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
	private int rows;
	private int cols;

	public boolean hasPath(char[] array, int rows, int cols, char[] str) {
		if(rows==0||cols==0) {
			return false;
		}
		this.rows=rows;
		this.cols=cols;
		boolean marked[][]=new boolean[rows][cols];
		char[][] matrix=buildMatrix(array);
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				if(backtracking(matrix,str,marked,0,i,j)) {
					return true;
				}
			}
		}
		return false;		
	}
	private boolean backtracking(char[][] matrix,char[] str,boolean[][] marked,int pathLen,int r ,int c) {
		if (pathLen==str.length)
		   	return true;
		if(r<0||r>=rows||c<0||c>=cols||matrix[r][c]!=str[pathLen]||marked[r][c]) //注意越界错误；
			return false;
		marked[r][c]=true;
		for(int[] n:next) 
			if(backtracking(matrix,str,marked,pathLen+1,r+n[0],c+n[1]))
				return true;
		
		marked[r][c]=false;
		return false;
		
		
	}
	public char[][] buildMatrix(char[] array){
		char[][] matrix=new char[rows][cols];
		int index=0;
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				matrix[i][j]=array[index++];
			}
		}
		return matrix;
	}
}
