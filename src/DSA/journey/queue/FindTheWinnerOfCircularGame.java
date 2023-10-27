package DSA.journey.queue;

import java.util.LinkedList;
import java.util.Queue;

public class FindTheWinnerOfCircularGame {
    public static void main(String[] args) {
    int n=6;
    int k=5;
        System.out.println(new FindTheWinnerOfCircularGame().findTheWinner(n,k));
    }
    public int findTheWinner(int n, int k) {
        Queue<Integer> que=new LinkedList<>();
        for(int i=1;i<=n;i++){
            que.add(i);
        }
        while(que.size()>1){
            int i=1;
            while(i<=k-1){
                int val=que.peek();
                que.remove();
                que.add(val);
                i++;
            }
            que.poll();
        }
        return que.peek();


    }
}
