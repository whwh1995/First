package study3;

public class Test {
public static void main(String[] args) {
	TreeNode t1=new TreeNode(1);
	TreeNode t2=new TreeNode(2);
	TreeNode t3=new TreeNode(3);
	TreeNode t4=new TreeNode(4);
	t1.left=t2;
	t1.right=t3;
	TreeNode test=t1;
	test.left.left=t4;
	System.out.println(t1.left.left.val);
	test=t2;
	System.out.println(test.left.val);
	test.left.left=new TreeNode(5);
	System.out.println(t1.left.left.left.val);
}
}
