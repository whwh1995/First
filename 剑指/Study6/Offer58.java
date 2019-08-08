package Study6;

public class Offer58 {
//	翻转单词顺序列
	public String ReverseSentence(String str) {
	    int n = str.length();
	    char[] chars = str.toCharArray();
	    int i = 0, j = 0;
	    reverse1(chars, 0, n - 1);
	    while (j <= n) {
	        if (j == n || chars[j] == ' ') {
	            reverse1(chars, i, j - 1);
	            i = j + 1;
	        }
	        j++;
	    }
	    
	    return new String(chars);
	}

	private void reverse1(char[] c, int i, int j) {
	    while (i < j)
	        swap(c, i++, j--);
	}

	private void swap(char[] c, int i, int j) {
	    char t = c[i];
	    c[i] = c[j];
	    c[j] = t;
	}
	
	
//	先将 "abc" 和 "XYZdef" 分别翻转，得到 "cbafedZYX"，然后再把整个字符串翻转得到 "XYZdefabc"。
	
	public String LeftRotateString(String str, int n) {
	    if (n >= str.length())
	        return str;
	    char[] chars = str.toCharArray();
	    reverse1(chars, 0, n - 1);
	    reverse1(chars, n, chars.length - 1);
	    reverse1(chars, 0, chars.length - 1);
	    return new String(chars);
	}

}
