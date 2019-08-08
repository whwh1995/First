package 图论;

import java.util.LinkedList;
import java.util.Queue;

public class 完全平方数 {
	/*给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。

	示例 1:

	输入: n = 12
	输出: 3 
	解释: 12 = 4 + 4 + 4.
	示例 2:

	输入: n = 13
	输出: 2
	解释: 13 = 4 + 9.*/

	  private class Node {
	        int val;
	        int step;

	        public Node(int val, int step) {
	            this.val = val;
	            this.step = step;
	        }
	    }
	    public int numSquares(int n) {
	       Queue<Node> queue = new LinkedList<>();
	        queue.add(new Node(n, 0));
	        // 其实一个真正的图的 BSF 是一定会加上 visited 数组来过滤元素的
	        boolean[] visited = new boolean[n+1];
	        while (!queue.isEmpty()) {
	            int num = queue.peek().val;
	            int step = queue.peek().step;
	            queue.remove();
	            for (int i = 1; ; i++) {
	                int a = num - i * i;
	                if (a < 0) {
	                    break;
	                }
	                // 若 a 已经计算到 0 了，就不必再往下执行了
	                if (a == 0) {
	                    return step + 1;
	                }
	                if (!visited[a]) {
	                    queue.add(new Node(a, step + 1));
	                    visited[a] = true;
	                }
	            }
	        }
	        return -1;
	    }
}
