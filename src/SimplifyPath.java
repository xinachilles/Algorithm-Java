import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Created by xhu on 10/6/16.
 */
public class SimplifyPath {
    public String simplifyPath(String path){
        if(path == null || path.length() == 0){
            return path;
        }

        Set<String> skip = new HashSet<>();
        Stack<String> pathes = new Stack<String>();
        skip.add("..");
        skip.add(".");
        skip.add("");

        for(String p : path.split("/")){
            if(p.equals("..") && !pathes.isEmpty()){
                pathes.pop();
            }else if(!skip.contains(p)){
                pathes.push(p);
            }
        }

        String result = "";

        while(!pathes.isEmpty()){
            result ="/"+pathes.pop()+result;
        }

        return result.length() == 0? "/" : result ;

    }


}
