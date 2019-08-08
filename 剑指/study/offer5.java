package study;

import java.util.HashMap;
import java.util.Map;

public class offer5 {
	/*根据二叉树的前序遍历和中序遍历的结果，重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。

	preorder = [1,2,4,7,3,5,6,8]
	inorder =  [4,7,2,1,5,3,8,6]
	*/
	public class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
	   public TreeNode(int x) { 
			 val = x; 
	     }
	   public TreeNode(TreeNode left,TreeNode right,int val) {
		   this.left=left;
		   this.right=right;
		   this.val=val;
	   }
	   public TreeNode() {
		   
	   }
	}
	
	
	private Map<Integer, Integer> indexForInOrders = new HashMap<>();

	public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
	    for (int i = 0; i < in.length; i++)
	        indexForInOrders.put(in[i], i);
	    return reConstructBinaryTree(pre, 0, pre.length - 1, 0);
	}

	private TreeNode reConstructBinaryTree(int[] pre, int preL, int preR, int inL) {
	    if (preL > preR)
	        return null;	
	    TreeNode root = new TreeNode(pre[preL]);
	    int inIndex = indexForInOrders.get(root.val);
	    int leftTreeSize = inIndex - inL;
	    root.left = reConstructBinaryTree(pre, preL + 1, preL + leftTreeSize, inL);
	    root.right = reConstructBinaryTree(pre, preL + leftTreeSize + 1, preR, inL + leftTreeSize + 1);
	    return root;
	}
	
	
}





/*public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        return reConBTree(pre,0,pre.length-1,in,0,in.length-1);
    }
    public TreeNode reConBTree(int [] pre,int preleft,int preright,int [] in,int inleft,int inright){
        if(preleft > preright || inleft> inright)//当到达边界条件时候返回null
            return null;
        //新建一个TreeNode
        TreeNode root = new TreeNode(pre[preleft]);
        //对中序数组进行输入边界的遍历
        for(int i = inleft; i<= inright; i++){
            if(pre[preleft] == in[i]){
                //重构左子树，注意边界条件
                root.left = reConBTree(pre,preleft+1,preleft+i-inleft,in,inleft,i-1);
                //重构右子树，注意边界条件
                root.right = reConBTree(pre,preleft+i+1-inleft,preright,in,i+1,inright);
            }
        }
        return root;     
    }*/