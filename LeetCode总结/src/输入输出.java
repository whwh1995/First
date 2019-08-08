import java.util.StringTokenizer;

public class 输入输出 {
	public static void main(String[] args) {
		//输出小数点后几位
		double d=(double)2/3;
		System.out.printf("%.6f",d);	
		
		}
	}

	/*
	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	 
	public class Main {
	    public static void main (String[] args) throws IOException {
	        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
	        int n=Integer.parseInt(bf.readLine());
	        }
	        */
	
	
	/*
	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.util.StringTokenizer;
	
	public class Main {
	    public static void main (String[] args) throws IOException {
	  BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
      String line;
      StringTokenizer st;
      while((line = reader.readLine()) != null){
          st = new StringTokenizer(line);
          int M = Integer.parseInt(st.nextToken());
          int N = Integer.parseInt(st.nextToken());
          //获取初始化成绩
          if((line = reader.readLine()) != null){
              st = new StringTokenizer(line);
              for(int i = 1; i <= M; i++){
                  score[i] = Integer.parseInt(st.nextToken());
              }
          }
          //多输入情况
          for(int i = 0; i < N; i++){ 
              if((line = reader.readLine()) != null){
                  st = new StringTokenizer(line);
                  String method = st.nextToken();
                  int a = Integer.parseInt(st.nextToken());
                  int b = Integer.parseInt(st.nextToken());
                  }
              }
          }
      }
  }*/

