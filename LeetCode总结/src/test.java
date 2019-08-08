import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import jdk.nashorn.internal.ir.Flags;


public class test {
		static String max="-1";
	 public static void main(String[] args){
		 Scanner sc=new Scanner(System.in);
		 int n=Integer.parseInt(sc.nextLine());
		 String[] tmp=new String[n];
		 for(int i=0;i<n;i++) {
			tmp[i]=sc.nextLine(); 
		 }
		 boolean[] flag=new boolean[tmp.length];
		 
		for(int i=0;i<tmp.length;i++) {
			backtracking(tmp,i,0,new StringBuffer(),flag);
		}
		System.out.println(max);
	 }
	 public static void backtracking(String[] tmp,int index,int length,StringBuffer sb,boolean[] flag) {
		 if(length==tmp.length) {
			 for(int i=0;i<sb.length();i++){
				 if(sb.charAt(i)>max.charAt(i)) {
					 max=sb.toString();
					 break;
				 }else if(sb.charAt(i)<max.charAt(i)){
					 break;
				 }else {
					 continue;
				 }
			 }
			 return;
		 }
		 for(int i=0;i<tmp.length;i++) {
			 if(flag[index]==true)
				 return;
			 flag[index]=true;
			 sb.append(tmp[index]);
			 backtracking(tmp, i, length+1, sb, flag);
			 flag[index]=false;
			 sb.delete(sb.length()-tmp[index].length(), sb.length());
		 }
	 }
}