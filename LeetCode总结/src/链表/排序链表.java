package 链表;

public class 排序链表 {
	/*在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。

	示例 1:

	输入: 4->2->1->3
	输出: 1->2->3->4
	示例 2:

	输入: -1->5->3->4->0
	输出: -1->0->3->4->5*/
	class Solution {
	    public ListNode sortList(ListNode head) {
	        if(head==null)
	            return head;
	       return  mergeSort(head);
	    }
	    public ListNode mergeSort(ListNode head){
	        if(head.next==null)
	            return head;
	        ListNode quick=head;
	        ListNode slow=head;
	        ListNode start=head;
	        while(quick!=null&&quick.next!=null){
	            start=slow;
	            quick=quick.next.next;
	            slow=slow.next;
	        }
	        start.next=null;
	        return merge(mergeSort(head),mergeSort(slow));
	    }
	    public ListNode merge(ListNode head,ListNode mid){
	        ListNode tmp=new ListNode(0);
	        ListNode cur=tmp;
	        while(head!=null&mid!=null){
	            if(head.val<=mid.val){
	                cur.next=head;
	                head=head.next;
	            }else{
	                cur.next=mid;
	                mid=mid.next;
	            }
	            cur=cur.next;
	        }
	        if(head==null){
	           cur.next=mid;
	            }
	        if(mid==null){
	           cur.next=head;
	        }
	        return tmp.next;
	    }
	}
}
