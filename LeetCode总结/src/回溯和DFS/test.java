package »ØËİºÍDFS;

import java.util.Arrays;

public class test {
public static void main(String[] args) {
	 int[][] res= {{1,4},{0,4}};
	 merge(res);
}

    public static int[][] merge(int[][] intervals) {
        if(intervals==null||intervals.length==0)
            return intervals;
        int[][] tmp=new int[intervals.length][2];
        Arrays.sort(intervals,(o1,o2)->o1[0]-o2[0]);
        int index=0;
        int left=intervals[0][0];
        int right=intervals[0][1];
        for(int i=0;i<intervals.length;i++){
            if(intervals[i][0]<=right){
                right=Math.max(right,intervals[i][1]);
            }else{
                tmp[index][0]=left;
                tmp[index][1]=right;
                index++;
                left=intervals[i][0];
                right=intervals[i][1];
            }
        }
        tmp[index][0]=left;
        tmp[index][1]=right;
        index++;
        int[][] res=new int[index][2];
        for(int i=0;i<index;i++){
            res[i][0]=tmp[i][0];
            res[i][1]=tmp[i][1];
        }
        return res;
    }
}
