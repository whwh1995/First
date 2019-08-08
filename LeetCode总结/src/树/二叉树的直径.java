package Ê÷;

public class ¶þ²æÊ÷µÄÖ±¾¶ {
	int res=0;
    public int diameterOfBinaryTree(TreeNode root) {
         max(root);
        return res;
    }
    public int max(TreeNode root){
        if(root==null)
            return -1;
        int left_max=max(root.left)+1;
        int right_max=max(root.right)+1;
        int tmp=(left_max+right_max);
        res=Math.max(tmp,res);
        return Math.max(left_max,right_max);
    }
}
