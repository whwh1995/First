package 图论;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 课程表 {
	/*现在你总共有 n 门课需要选，记为 0 到 n-1。

	在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，
	你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]

	给定课程总量以及它们的先决条件，判断是否可能完成所有课程的学习？

	示例 1:
	输入: 2, [[1,0]] 
	输出: true
	解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
	
	示例 2:
	输入: 2, [[1,0],[0,1]]
	输出: false
	解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；
	并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。
*/
	
//	解法1、(拓扑排序)
	public boolean canFinish(int numCourses, int[][] prerequisites) {
	    if(numCourses<0)
	    	return false;
	    if(prerequisites.length==0||prerequisites==null)
	    	return true;
	    int[] indgree=new int[numCourses];
	    for(int[] p:prerequisites) {
	    	indgree[p[0]]++;
	    }
	    Queue<Integer> que=new LinkedList<>();
	    for(int i=0;i<numCourses;i++){
	    	if(indgree[i]==0) {
	    		que.add(i);
	    	}		
	    }
	    List<Integer> res=new ArrayList<>();
	    while(que.size()>0) {
	    	int number=que.poll();
	    	res.add(number);
	    	for(int[] p:prerequisites) {
	    		if(p[1]==number) {
	    			indgree[p[0]]--;
	    			if(indgree[p[0]]==0) {
	    				que.offer(p[0]);
	    			}
	    		}
	    	}
	    }
	    return res.size()==numCourses;
    }
	
	
	
//	解法2、逆邻接表
	public boolean canFinish1(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<numCourses;i++)
            graph.add(new ArrayList<>());
        for(int[] n:prerequisites)
        {
            graph.get(n[0]).add(n[1]);
        }
        int[] visited = new int[numCourses];
        for(int i=0;i<numCourses;i++)
            if(DFS(i,graph,visited))
                return false;
        return true;
    }
	public boolean DFS(int curr,ArrayList<ArrayList<Integer>> graph,int[] visited)
    {
        //递归结束条件
        if(visited[curr]==1)//这个节点已经被访问
            return true;
        if(visited[curr]==2)//这个节点没有被访问
            return false;
         
        //业务逻辑处理
        visited[curr]=1;//表示正在访问
        for(int id:graph.get(curr))
            if(DFS(id,graph,visited))
                return true;
        visited[curr]=2;//表示已经访问
        return false;
    }
}
