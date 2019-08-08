package study4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Offer32Tree {
	/*不分行从上往下打印出二叉树的每个节点，同层节点从左至右打印。（层序遍历）

	例如，以下二叉树层次遍历的结果为：1,2,3,4,5,6,7*/
//	使用队列来进行层次遍历。
	public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
	    Queue<TreeNode> queue = new LinkedList<>();
	    ArrayList<Integer> ret = new ArrayList<>();
	    queue.add(root);
	    while (!queue.isEmpty()) {
	        int cnt = queue.size();
	        while (cnt-- > 0) {
	            TreeNode t = queue.poll();
	            if (t == null)
	                continue;
	            ret.add(t.val);
	            queue.add(t.left);
	            queue.add(t.right);
	        }
	    }
	    return ret;
	}
//	分行打印
	public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
	    ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
	    Queue<TreeNode> queue = new LinkedList<>();
	    queue.add(pRoot);
	    while (!queue.isEmpty()) {
	        ArrayList<Integer> list = new ArrayList<>();
	        int cnt = queue.size();
	        while (cnt-- > 0) {
	            TreeNode node = queue.poll();
	            if (node == null)
	                continue;
	            list.add(node.val);
	            queue.add(node.left);
	            queue.add(node.right);
	        }
	        if (list.size() != 0)
	            ret.add(list);
	    }
	    return ret;
	}
	/*按之字形顺序打印二叉树，
	请实现一个函数按照之字形打印二叉树，
	即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。*/
//	解法1：最后反转要反转的那行的元素	
	public ArrayList<ArrayList<Integer>> zPrint(TreeNode pRoot) {
		 ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
		    Queue<TreeNode> queue = new LinkedList<>();
		    queue.add(pRoot);
		    boolean reverse = false;
		    while (!queue.isEmpty()) {
		        ArrayList<Integer> list = new ArrayList<>();
		        int cnt = queue.size();
		        while (cnt-- > 0) {
		            TreeNode node = queue.poll();
		            if (node == null)
		                continue;
		            list.add(node.val);
		            queue.add(node.left);
		            queue.add(node.right);
		        }
		        if (reverse)
		            Collections.reverse(list);
		        reverse = !reverse;
		        if (list.size() != 0)
		            ret.add(list);
		    }
		    return ret;
	}
//	解法2：使用两个栈
	public ArrayList<ArrayList<Integer> > ZPrint(TreeNode Root) {
        int level = 1;
        //s1存奇数层节点
        Stack<TreeNode> s1 = new Stack<TreeNode>();
        s1.push(Root);
        //s2存偶数层节点
        Stack<TreeNode> s2 = new Stack<TreeNode>();
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        while (!s1.empty() || !s2.empty()) {
            if (level%2 != 0) {
                ArrayList<Integer> temp = new ArrayList<Integer>();
                while (!s1.empty()) {
                    TreeNode node = s1.pop();
                    if(node != null) {
                        temp.add(node.val);
                        s2.push(node.left);
                        s2.push(node.right);
                    }
                }
                if (!temp.isEmpty()) {
                    list.add(temp);
                    level++;
                    }
            } else {
                    ArrayList<Integer> temp = new ArrayList<Integer>();
                    while (!s2.empty()) {
                        TreeNode node = s2.pop();
                        if(node != null) {
                            temp.add(node.val);
                            s1.push(node.right);
                            s1.push(node.left);
                        }
                    }
                    if (!temp.isEmpty()) {
                        list.add(temp);
                        level++;
                    }
                }
            }
        return list;
    }
}

	
