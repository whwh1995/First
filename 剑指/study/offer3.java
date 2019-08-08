package study;

public class offer3 {
	/*将一个字符串中的空格替换成 "%20"。

	Input:
	"A B"

	Output:
	"A%20B"
	*/
	public String replaceSpace(StringBuffer str){
		int p1=str.length()-1;
		for(int i=0;i<=p1;i++) {
			if(str.charAt(i)==' ') {
				str.append("  ");
			}
		int p2=str.length()-1;	
		while(p1>=0&&p2>p1){
			char c=str.charAt(p1--);
			if(c==' ') {
				str.setCharAt(p2--, '0');
				str.setCharAt(p2--, '2');
				str.setCharAt(p2--, '%');
			}else {
				str.setCharAt(p2--, c);
				}
			}	
		}
		return str.toString();		
}
//	合并两个数组时也可以从后往前复制
	
	
	
}
