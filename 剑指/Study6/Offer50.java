package Study6;

import java.util.LinkedList;
import java.util.Queue;

public class Offer50 {
//	在一个字符串中找到第一个只出现一次的字符，并返回它的位置。
	public int FirstNotRepeatingChar(String str) {
	    int[] cnts = new int[256];
	    for (int i = 0; i < str.length(); i++)
	        cnts[str.charAt(i)]++;
	    for (int i = 0; i < str.length(); i++)
	        if (cnts[str.charAt(i)] == 1)
	            return i;
	    return -1;
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
