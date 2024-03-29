package study5;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Offer41 {
	/*如何得到一个数据流中的中位数？
	如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
	如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。*/
	private PriorityQueue<Integer> left = new PriorityQueue<>((o1, o2) -> o2 - o1);
	/* 小顶堆，存储右半边元素，并且右半边元素都大于左半边 */
	private PriorityQueue<Integer> right = new PriorityQueue<>();
	/* 当前数据流读入的元素个数 */
	private int N = 0;

	public void Insert(Integer val) {
	    /* 插入要保证两个堆存于平衡状态 */
	    if (N % 2 == 0) {
	        /* N 为偶数的情况下插入到右半边。
	         * 因为右半边元素都要大于左半边，但是新插入的元素不一定比左半边元素来的大，
	         * 因此需要先将元素插入左半边，然后利用左半边为大顶堆的特点，取出堆顶元素即为最大元素，此时插入右半边 */
	        left.add(val);
	        right.add(left.poll());
	    } else {
	        right.add(val);
	        left.add(right.poll());
	    }
	    N++;
	}

	public Double GetMedian() {
	    if (N % 2 == 0)
	        return (left.peek() + right.peek()) / 2.0;
	    else
	        return (double) right.peek();
	}
	/*请实现一个函数用来找出字符流中第一个只出现一次的字符。
	例如，当从字符流中只读出前两个字符 "go" 时，第一个只出现一次的字符是 "g"。
	当从该字符流中读出前六个字符“google" 时，第一个只出现一次的字符是 "l"。
*/	
	private int[] cnts = new int[256];
	private Queue<Character> queue = new LinkedList<>();

	public void Insert(char ch) {
	    cnts[ch]++;
	    queue.add(ch);
	    while (!queue.isEmpty() && cnts[queue.peek()] > 1)
	        queue.poll();
	}

	public char FirstAppearingOnce() {
	    return queue.isEmpty() ? '#' : queue.peek();
	}
	
	
	
}





