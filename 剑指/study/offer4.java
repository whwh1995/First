package study;

import java.util.ArrayList;
import java.util.Stack;

public class offer4 {
//	从尾到头反过来打印出每个结点的值。

	public ArrayList<Integer> printListFromTailToHead(ListNode listnode){
		Stack<Integer> stack=new Stack<>();
		ArrayList<Integer> list=new ArrayList<Integer>();
	    while(listnode!=null) {
	    	stack.push(listnode.val);
	    	listnode=listnode.next;
	    }
	    while(!stack.isEmpty()) {
	    	list.add(stack.pop());
	    }
	    return list;
		
}	
}
/*使用递归
public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
    ArrayList<Integer> ret = new ArrayList<>();
    if (listNode != null) {
        ret.addAll(printListFromTailToHead(listNode.next));
        ret.add(listNode.val);
    }
    return ret;
}*/



/*利用链表头插法为逆序的特点。

头结点和第一个节点的区别：

头结点是在头插法中使用的一个额外节点，这个节点不存储值；
第一个节点就是链表的第一个真正存储值的节点。*/

/*public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
    // 头插法构建逆序链表
    ListNode head = new ListNode(-1);
    while (listNode != null) {
        ListNode memo = listNode.next;
        listNode.next = head.next;
        head.next = listNode;
        listNode = memo;
    }
    // 构建 ArrayList
    ArrayList<Integer> ret = new ArrayList<>();
    head = head.next;
    while (head != null) {
        ret.add(head.val);
        head = head.next;
    }
    return ret;
}*/
