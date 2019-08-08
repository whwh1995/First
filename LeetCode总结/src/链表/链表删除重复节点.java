package 链表;

public class 链表删除重复节点 {
//	 在 O(1) 时间内删除链表节点
	
	
	
/*  ① 如果该节点不是尾节点，那么可以直接将下一个节点的值赋给该节点，然后令该节点指向下下个节点
	② 如果链表只有一个节点，那么直接
	② 否则，就需要先遍历链表，找到节点的前一个节点，然后让前一个节点指向 null，时间复杂度为 O(N)。
*/
	
	/*public class ListNode{
		ListNode next;
		int val;
		public ListNode(int i) {
			this.val=i;
		}
		
	}*/
	public ListNode deleteNode(ListNode head, ListNode tobeDelete) {
	    if (head == null || tobeDelete == null)
	        return null;
	    if (tobeDelete.next != null) {
	        // 要删除的节点不是尾节点
	        ListNode next = tobeDelete.next;
	        tobeDelete.val = next.val;
	        tobeDelete.next = next.next;
	    } else {
	        if (head == tobeDelete)
	             // 只有一个节点
	            head = null;
	        else {
	            ListNode cur = head;
	            while (cur.next != tobeDelete)
	                cur = cur.next;
	            cur.next = null;
	        }
	    }
	    return head;
	}
//	删除链表中重复的结点
//	在一个排序的链表中，如何删除重复的节点。
	public ListNode deleteDuplication(ListNode pHead) {
	    if (pHead == null || pHead.next == null)
	        return pHead;
	    ListNode next = pHead.next;
	    if (pHead.val == next.val) {
	        while (next!=null&&pHead.val == next.val) //重点,因为 null.val 会报空指针异常，所以需要next！=null判断；
	             next = next.next;
	        return deleteDuplication(next);
	    } else {
	        pHead.next = deleteDuplication(pHead.next);
	        return pHead;
	    }
	}
}
