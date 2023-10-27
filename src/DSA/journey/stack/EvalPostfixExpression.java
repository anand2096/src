package DSA.journey.stack;

import java.util.HashSet;
import java.util.Stack;

public class EvalPostfixExpression {
    public static void main(String[] args) {
        String []s={"4","13","5","/","+"};
        System.out.println(new EvalPostfixExpression().evalRPN(s));
    }
    public int evalRPN(String[] tokens) {
        int ans=0;
        HashSet<String> set=new HashSet();
        set.add("+");
        set.add("*");
        set.add("-");
        set.add("/");
        Stack<String> stack=new Stack();
        for(int i=0;i<tokens.length;i++){
            if(set.contains(tokens[i])){
                String operator=tokens[i];
                String first=stack.pop();
                String second=stack.pop();
                int temp=performOperation(operator,first,second);
                stack.push(String.valueOf(temp));

            }
            else{
                stack.push(tokens[i]);
            }
        }
        return Integer.parseInt(stack.peek());

    }
    public int performOperation(String operator, String first, String second){
        int f=Integer.parseInt(first);
        int s=Integer.parseInt(second);
        if(operator.equals("*")){
            return f*s;
        }
        else if(operator.equals("/")){
            return s/f;
        }
        else if(operator.equals("+")){
            return f+s;
        }
        else{
            return s-f;
        }
    }
}
