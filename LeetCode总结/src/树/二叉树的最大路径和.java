package 树;


public class 二叉树的最大路径和 {
	/*给定一个非空二叉树，返回其最大路径和。

	本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。

	示例 1:

	输入: [1,2,3]

	       1
	      / \
	     2   3

	输出: 6
	示例 2:

	输入: [-10,9,20,null,null,15,7]

	   -10
	   / \
	  9  20
	    /  \
	   15   7

	输出: 42*/
	int max=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        max(root);
        return max;
    }
    public int max(TreeNode root){
        if(root==null)
            return 0;
        int max_left=Math.max(max(root.left),0);
        int max_right=Math.max(max(root.right),0);
        int all=max_left+max_right+root.val;
        max=Math.max(all,max);
        return root.val+Math.max(max_left,max_right);
    }
}
