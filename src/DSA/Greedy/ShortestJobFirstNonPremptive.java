package DSA.Greedy;


import java.util.*;

class SJF{
    int pid;
    int arrivalTime;
    int burstTime;
    public SJF(int pid,int arrivalTime,int burstTime){
        this.pid=pid;this.arrivalTime=arrivalTime;this.burstTime=burstTime;
    }
}

class SJFComparator implements Comparator<SJF>{

    @Override
    public int compare(SJF o1, SJF o2) {
        if(o1.arrivalTime==o2.arrivalTime){
            if(o1.burstTime==o2.burstTime){
                return  o1.pid-o2.pid;
            }
            else{
                return o1.burstTime-o2.burstTime;
            }
        }
        return o1.arrivalTime-o2.arrivalTime;
    }
}
class SJFQueueComparator implements Comparator<SJF> {

    @Override
    public int compare(SJF o1, SJF o2) {
        return o1.burstTime - o2.burstTime;
    }
}

public class ShortestJobFirstNonPremptive {

    public static void main(String[] args) {
        List<SJF> sjfList=new ArrayList<>();
        List<Integer> ans=new ArrayList<>();
        PriorityQueue<SJF> queue=new PriorityQueue<SJF>(new SJFQueueComparator());
        Scanner kb=new Scanner(System.in);
    for(int i=0;i<4;i++){
            int pid=kb.nextInt();
            int arrivalTime=kb.nextInt();
            int burstTime=kb.nextInt();
            SJF sjf=new SJF(pid,arrivalTime,burstTime);
            sjfList.add(sjf);

    }

     Collections.sort(sjfList,new SJFComparator());
     queue.add(sjfList.get(0));
     int i=1;
     int currentTime=0;
     while(!queue.isEmpty()){

         int burstTime=queue.peek().burstTime;
         int id=queue.peek().pid;
         queue.poll();
         ans.add(id);
         currentTime=currentTime+burstTime;
         while(true){

             if(i<sjfList.size() && sjfList.get(i).arrivalTime<=currentTime){
                 queue.add(sjfList.get(i));
                 i++;
             }
             else break;
         }
     }
        System.out.println(ans);
    }
}
