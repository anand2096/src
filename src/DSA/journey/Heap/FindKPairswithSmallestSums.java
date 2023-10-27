package DSA.journey.Heap;
import java.util.*;

class PairK{
    int no;
    int freq;
    public PairK(int no,int freq){
        this.no=no;
        this.freq=freq;
    }
}
public class FindKPairswithSmallestSums {
    public static void main(String[] args) {
     //   nums1 = [1,7,11], nums2 = [2,4,6], k = 3
        int [] nums1 = {1,2};
        int [] nums2 = {3};int k = 3;
        System.out.println(new FindKPairswithSmallestSums().kSmallestPairs(nums1,nums2,k));
    }


    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        Map<Integer,Integer> map1=new HashMap<>();
        Map<Integer,Integer> map2=new HashMap<>();
        PriorityQueue<PairK> pq1=new PriorityQueue<>((a, b) -> a.no - b.no);
        PriorityQueue<PairK> pq2=new PriorityQueue<>((a, b) -> a.no - b.no);
        for(int i=0;i<nums1.length;i++){
            map1.put(nums1[i],map1.getOrDefault(nums1[i],0)+1);
        }
        for(int i=0;i<nums2.length;i++){
            map2.put(nums2[i],map2.getOrDefault(nums2[i],0)+1);
        }

        for(Map.Entry<Integer,Integer> m1:map1.entrySet()){
            pq1.add(new PairK(m1.getKey(),m1.getValue()));
        }
        for(Map.Entry<Integer,Integer> m2:map2.entrySet()){
            pq2.add(new PairK(m2.getKey(),m2.getValue()));
        }
        List<List<Integer>> ans=new ArrayList<>();

        while(k>0 && pq1.size()>0 &&pq2.size()>0){
            PairK first=pq1.peek();
            PairK second=pq2.peek();

            int count=first.freq*second.freq;
            if(count<=k){
                for(int i=1;i<=count;i++){
                    List<Integer> temp=new ArrayList<>();
                    temp.add(first.no);
                    temp.add(second.no);
                    ans.add(temp);
                }
                k=k-count;

                if(first.no>second.no){
                    pq1.remove();
                }
                else{
                    pq2.remove();
                }
            }
            else{
                for(int i=1;i<=k;i++){
                    List<Integer> temp=new ArrayList<>();
                    temp.add(first.no);
                    temp.add(second.no);
                    ans.add(temp);

                }
                break;
            }
        }
        return ans;
    }
}
