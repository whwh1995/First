package Study6;

public class Offer55 {
//	平衡二叉树左右子树高度差不超过 1。
	
	private boolean isBalanced = true;

	public boolean IsBalanced_Solution(TreeNode root) {
	    height(root);
	    return isBalanced;
	}

	private int height(TreeNode root) {
	    if (root == null || !isBalanced)
	        return 0;
	    int left = height(root.left);
	    int right = height(root.right);
	    if (Math.abs(left - right) > 1)
	        isBalanced = false;
	    return 1 + Math.max(left, right);
	}
	
	//二叉树的深度
	
	public int TreeDepth(TreeNode root) {
	    return root == null ? 0 : 1 + Math.max(TreeDepth(root.left), TreeDepth(root.right));
	}
}
