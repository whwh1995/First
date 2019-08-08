package study3;

public class Offer27 {
//	得到二叉树的镜像
	public void Mirror(TreeNode root) {
	    if (root == null)
	        return;
	    swap(root);
	    Mirror(root.left);
	    Mirror(root.right);
	}

	private void swap(TreeNode root) {
	    TreeNode t = root.left;
	    root.left = root.right;
	    root.right = t;
	}
}
