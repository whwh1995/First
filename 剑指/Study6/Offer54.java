package Study6;

public class Offer54 {
//	二叉查找树的第 K 个结点
	//中序遍历
	private TreeNode ret;
	private int cnt = 0;

	public TreeNode KthNode(TreeNode pRoot, int k) {
	    inOrder(pRoot, k);
	    return ret;
	}

	private void inOrder(TreeNode root, int k) {
	    if (root == null || cnt >= k)
	        return;
	    inOrder(root.left, k);
	    cnt++;
	    if (cnt == k)
	        ret = root;
	    inOrder(root.right, k);
	}
}
