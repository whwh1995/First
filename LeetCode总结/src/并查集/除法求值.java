package 并查集;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class 除法求值 {
	/*解法一：DFS + Adjacent list

	O(equation + equation* queries )   先遍历所有输入equation + 对于每一个query都可能遍历整个表

	 

	1. 先遍历输入的已有的公式，创建adjacent list. - 得到String可能的下一个String

	例如

	A - >(B, value), (C, value)
	C - >(D,value)

	2. 不断DFS - 求A/D， 从A开始遍历整个表去寻找是否能到达D。A->C->D
	*/
	 public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {

	      //make adjacent list 
	      // A-> (B, 2.0) (C, 3.0)
	      Map<String, Map<String, Double>> map = new HashMap<>();
	      for(int i = 0 ; i < equations.length; ++i){
	        Map<String, Double> current = map.computeIfAbsent(equations[i][0], k -> new HashMap());
	        current.put(equations[i][1], values[i]);
	        current = map.computeIfAbsent(equations[i][1], k -> new HashMap());
	        current.put(equations[i][0], 1 / values[i]);
	      }
	      
	      //populate the result
	      double[] result = new double[queries.length];
	      for(int i = 0 ; i < queries.length; ++i){
	        result[i] = dfs(queries[i][0], queries[i][1], map, new HashSet<String>());
	      }
	      return result;
	    }
	  
	 private double dfs(String numerator, String denominator, Map<String, Map<String, Double>> map,HashSet<String> visited){
	      if(visited.contains(numerator)) 
	    	  return -1;
	      visited.add(numerator);
	      Map<String, Double> adj = map.get(numerator);
	      if(adj == null) 
	    	  return -1;
	      if(adj.containsKey(denominator)){
	          return adj.get(denominator);
	      }
	      for(String next: adj.keySet()){
	        double ans = dfs(next, denominator, map, visited);
	        if(ans != -1){
	          return adj.get(next) * ans;
	        }
	      }
	      return -1;
	    }      


/*解法2：UNION FIND

O(equation + queries)   先遍历所有输入equation形成并查集 + 对于每一个query都是O(1)的操作

通过上面的思考过程，我们发现如果dfs可以走通，说明两个String在同一个set里面。 想到可以用并查集来做。
可以把每一对的String之前的关系(value)都转换成他们和共同父亲的关系。 
如果两个String有共同的father， 说明是有答案的。取到他们和这个共同父亲的关系，得到他们之间的关系*/

//定义父节点
private class Father{
  String name;
  double value;
  public Father(String name, double value){
    this.name = name;
    this.value = value;
  }
}

//合并两个节点，指向同一个父节点
private void union(String numer, String deno, Map<String, Father> uf, double value){
  Father f_nume = find(numer,uf);
  Father f_deno = find(deno,uf);
  
  if(!f_nume.name.equals(f_deno.name)){
    uf.put(f_deno.name, new Father(f_nume.name, f_nume.value * value *(1/f_deno.value)));
  }
}

//找到当前target的父节点。途中做路径压缩 
private Father find(String target, Map<String, Father> uf){
  Father current_father = uf.get(target);
  
  if(!current_father.name.equals(target)){
    Father final_father = find(current_father.name, uf);
    uf.put(target, new Father(final_father.name, current_father.value * final_father.value));
  }
  return uf.get(target);
}


public double[] calcEquation1(String[][] equations, double[] values, String[][] queries) {

	  Map<String, Father> unionFind = new HashMap<>();
	  for(int i = 0 ; i< equations.length; ++i){
	    unionFind.putIfAbsent(equations[i][0], new Father(equations[i][0], 1.0));
	    unionFind.putIfAbsent(equations[i][1], new Father(equations[i][1], 1.0));
	    union(equations[i][0], equations[i][1], unionFind, values[i]);
	  }
  
  // find result
	  double[] result = new double[queries.length];
	  for(int i = 0 ; i < queries.length; ++i){
	    if(!unionFind.containsKey(queries[i][0]) || !unionFind.containsKey(queries[i][1])){ 
	      result[i] = -1;
	      continue;
	    }
	    Father nume = find(queries[i][0],unionFind);
	    Father deno = find(queries[i][1],unionFind);
	    if(!nume.name.equals(deno.name)){ //如果两个点没有一样的父亲节点，说明没有关系不在一个union里面
	      result[i] = -1;
	      continue;
	    }
	    result[i] = (1.0 / nume.value) * deno.value;
	    
	  }
	  return result;
}
}
