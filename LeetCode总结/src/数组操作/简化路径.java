package 数组操作;

public class 简化路径 {
	  public static String simplifyPath(String path) {
		    char[] pathChars = path.toCharArray();
		    int resI = pathChars.length;
		    int mode = 0;
		    int skips = 0;
		    for (int i = pathChars.length - 1; i >= 0; --i) {
		      char c = pathChars[i];
		      if (c == '/') {
		        if (mode == 1) {
		          pathChars[--resI] = '/';
		        }
		        mode = 0;
		      } else {
		        if (mode == 0) {
		          if (c == '.') {
		            if (pathChars[i - 1] == '.' && pathChars[i - 2] == '/') {
		              ++skips;
		              i -= 2;
		              continue;
		            } 
		            if (pathChars[i - 1] == '/') {
		              --i;
		              continue;
		            } 
		          }
		          if (skips > 0) {
		            --skips;
		            mode = 2;
		          } else {
		            pathChars[--resI] = c;
		            mode = 1;
		          }
		        } else if (mode == 1) {
		          pathChars[--resI] = c;
		        }
		      }
		    }
		    if (resI == pathChars.length || mode == 1) {
		      pathChars[--resI] = '/';
		    }
		    return new String(pathChars, resI, pathChars.length - resI);
		  }
}
