package DSA.journey.queue;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWIndowMaximum {

    public static void main(String[] args) {
       int[] A = {1, 3, -1, -3, 5, 3, 6, 7};
       int B = 3;
       int ans[]=new SlidingWIndowMaximum().slidingMaximum(A,B);
       for(int i=0;i<ans.length;i++){
           System.out.print(ans[i]+" ");
       }

    }

    public int[] slidingMaximum(final int[] nums, int k) {
        int t=0;
        Deque<Integer> deque = new LinkedList<Integer>();
        int i=0;
        int j=0;
        int n=nums.length;
        int ans[]=new int[n-k+1];
        while(j<n){

            if(j<k-1){
                while(!deque.isEmpty() && deque.getLast()<nums[j]){
                    deque.removeLast();
                }
                deque.add(nums[j]);
                j++;

            }
            else{

                while(!deque.isEmpty() && deque.getLast()<nums[j]){
                    deque.removeLast();
                }
                deque.add(nums[j]);
                ans[t++]=deque.getFirst();

                if(deque.getFirst()==nums[i]){
                    deque.removeFirst();
                }
                i++;
                j++;
            }
        }
        return ans;

    }


    public int[] slidingMinimum(final int[] nums, int k) {
        int t=0;
        Deque<Integer> deque = new LinkedList<Integer>();
        int i=0;
        int j=0;
        int n=nums.length;
        int ans[]=new int[n-k+1];
        while(j<n){

            if(j<k-1){
                while(!deque.isEmpty() && deque.getLast()>nums[j]){
                    deque.removeLast();
                }
                deque.add(nums[j]);
                j++;

            }
            else{

                while(!deque.isEmpty() && deque.getLast()>nums[j]){
                    deque.removeLast();
                }
                deque.add(nums[j]);
                ans[t++]=deque.getFirst();

                if(deque.getFirst()==nums[i]){
                    deque.removeFirst();
                }
                i++;
                j++;
            }
        }
        return ans;

    }
}
