package DSA.journey.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenerateParenthesis {

    public static void main(String[] args) {
        String[] list=new GenerateParenthesis().generateParenthesis(3);
        for(int i=0;i<list.length;i++){
            System.out.println(list[i]);
        }
    }
    public String[] generateParenthesis(int n) {
        List<String> list=new ArrayList<>();
        rec(list,"",n);
        String [] ans=new String[list.size()];
        for(int i=0;i<list.size();i++){
            ans[i]=list.get(i);
        }
        return ans;
    }
    public void rec(List<String> list,String s,int n){
        if(s.length()==2*n){
            if(isValidParenthesis(s)) {
                list.add(s);
            }
        }
        else {
            rec(list,s+"(",n);
            rec(list,s+")",n);
        }

    }
    public boolean isValidParenthesis(String s){
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stack.push(s.charAt(i));
            }
            if(stack.isEmpty()){
                return false;
            }
            else if(s.charAt(i)==')'){
                    if(stack.pop()!='(')
                        return false;
            }
        }
        return stack.isEmpty();
    }


}
