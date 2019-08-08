package study2;
public class Test {
public static void main(String[] args) {
	Offer18 test= new Offer18();
	ListNode node1= new ListNode(1);
	ListNode node2= new ListNode(1);
	ListNode node3= new ListNode(1);
	ListNode node4= new ListNode(1);
	ListNode node5= new ListNode(1);
	node1.next=node2;
	node2.next=node3;
	node3.next=node4;
	node4.next=node5;
	node5.next=null;
	ListNode result=test.deleteDuplication(node1);
	System.out.println(result);
}
}
