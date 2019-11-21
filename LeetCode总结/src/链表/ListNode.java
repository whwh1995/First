package Á´±í;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ListNode {
	ListNode next=null;
	int val;
	public  ListNode(int i) {
		this.val=i;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            ListNode node = Wrapper.stringToListNode(line);
            node=reverseKGroup(node,3);
            Wrapper.prettyPrintLinkedList(node);
        }
	}
	 public static ListNode reverseKGroup(ListNode head, int k) {
	        if (head == null) return null;
	        if (k <= 0) return null;
	        if (k == 1) return head;
	        ListNode toHead = new ListNode(0);
	        toHead.next = head;
	        ListNode temp = toHead;
	        while (temp.next != null) {
	            temp = reverseSingleK(temp, k);
	        }
	        return toHead.next;
	    }
	    
	    public static ListNode reverseSingleK(ListNode before, int k) {
	        ListNode pre = before.next;
	        ListNode cur = pre.next;
	        int flag = 0;
	        for (int i = 1; i < k; i ++) {
	            if (cur == null) {
	                flag = i;
	                break;
	            }
	            ListNode temp = cur.next;
	            cur.next = pre;
	            pre = cur;
	            cur = temp;
	        }
	        if (flag != 0) {
	            ListNode ret = pre;
	            cur = pre.next;
	            for (int i = 2; i < flag; i ++) {
	                ListNode temp = cur.next;
	                cur.next = pre;
	                pre = cur;
	                cur = temp;
	            }
	            ret.next = null;
	            return ret;
	        } else {
	            ListNode ret = before.next;
	            before.next = pre;
	            ret.next = cur;
	            return ret;
	        }
	    }
}

