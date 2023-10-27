package DSA.journey.Heap;

import java.util.PriorityQueue;

public class KthLargestELementInWindow {

    public static void main(String[] args) {
      int  A = 4;
        int [] B = {1, 2, 3, 4, 5, 6};
        int ans[]=new KthLargestELementInWindow().solve(A,B);
    }

    public int[] solve(int k, int[] nums) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(k);
        int n=nums.length;

        int ans[]=new int[nums.length];
        for(int i=0;i<ans.length;i++){
            ans[i]=-1;
        }
        for(int i=0;i<k;i++){
            pq.add(nums[i]);

        }
        int j=k-1;
        ans[j++]=pq.peek();
        for(int i=k;i<n;i++){
            if(nums[i]>pq.peek()){
                pq.remove();
                pq.add(nums[i]);
            }
            ans[j++]=pq.peek();

        }
        return ans;

    }
}
