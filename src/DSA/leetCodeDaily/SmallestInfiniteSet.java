package DSA.leetCodeDaily;

import java.util.PriorityQueue;

public class SmallestInfiniteSet {

    PriorityQueue<Integer> minHeap;
    public static void main(String[] args) {

    }
    public SmallestInfiniteSet() {
        minHeap = new PriorityQueue<>();
        for(int i=1;i<=3000;i++){
            minHeap.add(i);
        }
    }

    public int popSmallest() {
        Integer a=minHeap.poll();
        if(a!=null){
            return a;
        }
        return 0;
    }

    public void addBack(int num) {
        if(!minHeap.contains(num)){
            minHeap.add(num);
        }

    }

}
