package study3;

public class Offer23 {
//	一个链表中包含环，请找出该链表的环的入口结点。要求不能使用额外的空间。
	/*使用双指针，一个指针 fast 每次移动两个节点，一个指针 slow 每次移动一个节点。
	因为存在环，所以两个指针必定相遇在环中的某个节点上。
	假设相遇点在下图的 z1 位置，此时 fast 移动的节点数为 x+2y+z，slow 为 x+y，
	由于 fast 速度比 slow 快一倍，因此 x+2y+z=2(x+y)，得到 x=z。

在相遇点，slow 要到环的入口点还需要移动 z 个节点，如果让 fast 重新从头开始移动，并且速度变为每次移动一个节点，
那么它到环入口点还需要移动 x 个节点。在上面已经推导出 x=z，因此 fast 和 slow 将在环入口点相遇。*/
	public ListNode EntryNodeOfLoop(ListNode pHead) {
	    if (pHead == null || pHead.next == null)
	        return null;
	    ListNode slow = pHead, fast = pHead;
	    do {
	        fast = fast.next.next;
	        slow = slow.next;
	    } while (slow != fast);
	    fast = pHead;
	    while (slow != fast) {
	        slow = slow.next;
	        fast = fast.next;
	    }
	    return slow;
	}
}
