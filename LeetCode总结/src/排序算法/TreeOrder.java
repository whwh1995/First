package ≈≈–ÚÀ„∑®;

import java.util.ArrayList;
import java.util.List;

public class TreeOrder {
	List<Integer> list =new ArrayList<Integer>();
	public  void preOder(TreeNode tree) {
		if(tree!=null) {
			list.add(tree.val);
			preOder(tree.left);
			preOder(tree.right);
		}
	}
	public  void inOder(TreeNode tree) {
		if(tree!=null) {
			inOder(tree.left);
			list.add(tree.val);
			inOder(tree.right);
		}
	}
	public  void posOder(TreeNode tree) {
		if(tree!=null) {
			preOder(tree.left);
			preOder(tree.right);
			list.add(tree.val);
		}
	}
	
	
	
	
	
}