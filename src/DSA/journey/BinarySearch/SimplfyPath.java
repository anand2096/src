package DSA.journey.BinarySearch;

import java.util.*;

public class SimplfyPath {
    public static void main(String[] args) {
        String path="/a/../b/c/../d///";
        System.out.println(new SimplfyPath().simplifyPath(path));
    }
    public String simplifyPath(String path) {
        int n=path.length();
        String arr[]=path.split("/");
        List<String> skip=new ArrayList<>();
        skip.add(".");
        skip.add("");
        skip.add("..");
        Deque<String> stack = new LinkedList<>();

        for(String dir:arr){
            if(dir.equals("..") &&!stack.isEmpty()){
                stack.pop();
            }
            else if(!skip.contains(dir)){
                stack.push(dir);
            }
        }
        String ans="";
        for(String dir:stack){
            ans="/"+dir+ans;
        }
//        StringBuilder sb=new StringBuilder(ans);
//        sb.reverse();
        return ans.isEmpty()?"/":ans;
    }
}
