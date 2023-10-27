package DSA.journey.queue;

import java.util.*;

public class PerfectNumbers {

    public static void main(String[] args) {
    int n=5;
        System.out.println(new PerfectNumbers().solve(n));

    }
    public String solve(int n) {
        Deque<String> queue=new LinkedList<>();
        queue.add("1");queue.add("2");
        List<String> list=new ArrayList<>();
        while(list.size()!=n){
            String front=queue.peek();
            queue.remove();
            String reverse=new StringBuilder(front).reverse().toString();
            list.add(front+reverse);
            queue.add(front+"1");
            queue.add(front+"2");
        }
        // System.out.println(list);
        return list.get(n-1);

    }

}
