package study4;

import java.util.ArrayList;

public class Offer34_ {
	/*输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的   所有路径。
	路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。*/
	private ArrayList<ArrayList<Integer>> ret = new ArrayList<>();

	public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
	    backtracking(root, target, new ArrayList<>());
	    return ret;
	}

	private void backtracking(TreeNode node, int target, ArrayList<Integer> path) {
	    if (node == null)
	        return;
	    path.add(node.val);
	    target -= node.val;
	    if (target == 0 && node.left == null && node.right == null) {
	        ret.add(new ArrayList<>(path)); // ????!!!!
	    } else {
	        backtracking(node.left, target, path);
	        backtracking(node.right, target, path);
	    }
	    path.remove(path.size() - 1);
	}
}
