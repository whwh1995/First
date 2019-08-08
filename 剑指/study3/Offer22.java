package study3;

public class Offer22 {
//	链表中倒数第 K 个结点
	public ListNode FindKthToTail(ListNode head, int k) {
	    if (head == null)
	        return null;
	    ListNode P1 = head;
	    while (P1 != null && k-- > 0)
	        P1 = P1.next;
	    if (k > 0)
	        return null;
	    ListNode P2 = head;
	    while (P1 != null) {
	        P1 = P1.next;
	        P2 = P2.next;
	    }
	    return P2;
	}
}
