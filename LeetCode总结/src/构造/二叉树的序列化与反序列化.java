package 构造;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class 二叉树的序列化与反序列化 {
	public class Codec {

	    // Encodes a tree to a single string.
	    public String serialize(TreeNode root) {
	        if(root == null){
	            return "null,";
	        }
	        StringBuilder sb = new StringBuilder();
	        sb.append(root.val + ",");
	        sb.append(serialize(root.left));
	        sb.append(serialize(root.right));
	        return sb.toString();
	    }

	    // Decodes your encoded data to tree.
	    public TreeNode deserialize(String data) {
	        String[] strarr = data.split(",");
	        Queue<String> queue = new ArrayDeque<>(Arrays.asList(strarr));
	        return func(queue);
	    }
	    
	    private TreeNode func(Queue<String> strings) {
	        String string = strings.poll();
	        if ("null".equals(string)) {
	            return null;
	        }
	        TreeNode newNode = new TreeNode(Integer.parseInt(string));
	        newNode.left = func(strings);
	        newNode.right = func(strings);
	        return newNode;
	    }
	}
}
