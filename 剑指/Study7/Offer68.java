package Study7;

public class Offer68 {
//	二叉查找树中，两个节点 p, q 的公共祖先 root 满足 root.val >= p.val && root.val <= q.val。
//	二叉查找树
			public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
			    if (root == null)
			        return root;
			    if (root.val > p.val && root.val > q.val)
			        return lowestCommonAncestor(root.left, p, q);
			    if (root.val < p.val && root.val < q.val)
			        return lowestCommonAncestor(root.right, p, q);
			    return root;
			}
			
//	普通二叉树
//	在左右子树中查找是否存在 p 或者 q，如果 p 和 q 分别在两个子树中，那么就说明根节点就是最低公共祖先。

			public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
			    if (root == null || root == p || root == q)
			        return root;
			    TreeNode left = lowestCommonAncestor1(root.left, p, q);
			    TreeNode right = lowestCommonAncestor1(root.right, p, q);
			    return left == null ? right : right == null ? left : root;
			}
}
