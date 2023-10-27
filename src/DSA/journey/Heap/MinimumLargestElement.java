package DSA.journey.Heap;


import java.util.Comparator;
import java.util.PriorityQueue;

class Pair{
    int v;
    int o;
    public Pair(int v,int o){
        this.v=v;
        this.o=o;
    }
}
class MyComparator implements Comparator<Pair> {


    @Override
    public int compare(Pair o1, Pair o2) {
//        if(o1.v<o2.v){
//            return -1;
//        }
//        else if(o1.v>o2.v){
//            return 1;
//        }
//        else{
//            if(o1.o<o2.o)return -1;
//            return 1;
//        }

        if(o1.o+o1.v<=o2.o+o2.v)return -1;
        return 1;
    }
}

public class MinimumLargestElement {
    public static void main(String[] args) {
     int   A []= {8,6,4,2};
        int B = 8;
        System.out.println(new MinimumLargestElement().solve(A,B));
    }

        public int solve(int[] nums, int k) {

            PriorityQueue<Pair>pq=new PriorityQueue<>(new MyComparator());
            for(int i=0;i<nums.length;i++){
                pq.add(new Pair(nums[i],nums[i]));
            }
            while(k>0){

                Pair p=pq.remove();
                p.v=p.v+p.o;
                pq.add(p);
                k--;
            }
            int max=Integer.MIN_VALUE;
            while(pq.size()>0){
                Pair p=pq.remove();
                max=Math.max(max,p.v);
            }
            return max;
        }


}
