package DSA.journey.stack;

import java.util.Stack;

public class MinElement {
    Stack<Integer> stack=new Stack<>();
    Stack<Integer> minStack=new Stack<>();
    public void push(int x) {
        stack.push(x);
        if(minStack.isEmpty()){
            minStack.push(x);
        }
        else{
            int peek=minStack.peek();
            if(peek>=x){
                minStack.push(x);
            }
            else{
                int pop=minStack.pop();
                minStack.push(x);
                minStack.push(pop);
            }
        }

    }

    public void pop() {
        if(!stack.isEmpty()){
            int stackPeek=stack.peek();
            int minPeek=minStack.peek();
            if(stackPeek==minPeek){
                stack.pop();
                minStack.pop();
            }else
            {
                stack.pop();
                int min=minStack.pop();
                minStack.pop();
                minStack.push(min);
            }
        }



    }

    public int top() {
        if(stack.isEmpty()){
            return -1;
        }
        else{
            return stack.peek();
        }

    }

    public int getMin() {
        if(stack.isEmpty())return -1;
        else
            return minStack.peek();

    }

}
