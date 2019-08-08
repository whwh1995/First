package 回溯和DFS;

import java.util.ArrayList;

public class 根最长路径 {
	/*输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
	路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
	(注意: 在返回值的list中，数组长度大的数组靠前)
*/
         ArrayList<ArrayList<Integer>> list =new ArrayList<>();
        public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
            backtracking(root,target,new ArrayList<>());
                return list;
        }
        public void backtracking(TreeNode root ,int target ,ArrayList<Integer> tmp){
            if(root==null)
                return;
            target-=root.val;
            tmp.add(root.val);
            if(target==0&&root.left==null&&root.right==null){
                list.add(new ArrayList<>(tmp));
            }else{
                backtracking(root.left,target,tmp);
                backtracking(root.right,target,tmp);
            }
            tmp.remove(tmp.size()-1);
        }
    }


