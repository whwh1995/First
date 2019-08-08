package study3;

public class Offer24 {
//	 反转链表
	public ListNode ReverseList(ListNode head) { //递归
	    if (head == null || head.next == null)
	        return head;
	    ListNode next = head.next;
	    head.next = null;
	    ListNode newHead = ReverseList(next);
	    next.next = head;
	    return newHead;
	}
	public ListNode ReverseList1(ListNode head) {//迭代
	    ListNode newList = new ListNode(-1);
	    while (head != null) {
	        ListNode next = head.next;
	        head.next = newList.next;
	        newList.next = head;
	        head = next;
	    }
	    return newList.next;
	}
}
