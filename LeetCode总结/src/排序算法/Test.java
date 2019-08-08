package ÅÅĞòËã·¨;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test{
	public static void main(String[] args) {
		Map<Integer,Integer> map =new HashMap<>();
        map.put(1,1);
        map.put(0,0);
        map.put(8,8);
        map.put(2,5);
        map.put(5,2);
        map.put(6,9);
        Scanner sc=new Scanner(System.in);
        int a =sc.nextInt();
        int count=0;
        for(int i=0;i<=a;i++){
            if(isGood(i,map))
                count++;
    }
        System.out.print(count);
    }
	 public  static boolean isGood(int i,Map map){
	        boolean flag=false;
	        while(i!=0){
	            Integer n=i%10;
	            i=i/10;
	            if(!map.containsKey(n))
	                return false;
	            if(map.containsKey(n)&& map.get(n)!=n)
	                flag=true;
	        }
	        return flag;
	    }
}