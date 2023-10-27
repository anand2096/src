package DSA.journey.queue;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class NumberOfPeopleAwareOfSecret {

    public static void main(String[] args) {
    int n=425;int delay=81;int forget=118;
        System.out.println(new NumberOfPeopleAwareOfSecret().peopleAwareOfSecret(n,delay,forget));
    }
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int ans=0;
        Deque<Integer> dq=new LinkedList<>();

       // char c='A';
        int c=1;
        Map<Integer,Integer> map=new HashMap<>();
        int day=1;
        dq.add(c);
        map.put(c,day);
        c++;
         for(day=2;day<=n;day++){


                while(!dq.isEmpty() && day-map.get(dq.peek())>=forget){
                    int front=dq.peek();
                    dq.remove();
                    map.remove(front);
                }


            int count=0;
            for(Map.Entry<Integer,Integer> entry:map.entrySet()){
                if(day-entry.getValue()>=delay){
                    count++;
                }
            }
            for(int j=1;j<=count;j++){
                dq.add(c);
                map.put(c,day);
                c++;
            }
        }
        return dq.size();


    }
}
