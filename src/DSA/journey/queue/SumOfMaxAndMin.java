package DSA.journey.queue;

import java.util.Deque;
import java.util.LinkedList;

public class SumOfMaxAndMin {

    public static void main(String[] args) {
        int A[]={2, 5, -1, 7, -3, -1, -2};
        int B=4;
        int mod=(int)Math.pow(10,9)+7;
        long fans=0;
        int max[]=new SumOfMaxAndMin().slidingMaximum(A,B);
        int min[]=new SumOfMaxAndMin().slidingMinimum(A,B);
        for(int i=0;i<max.length;i++){
            fans=(fans%mod+max[i]%mod+min[i]%mod)%mod;
        }
        System.out.println((int)fans%mod);
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


    public int[] slidingMinimum1(final int[] nums, int k) {
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

    public int[] slidingMinimum(final int[] nums, int k) {
        int n=nums.length;
        int ans[]=new int[n-k+1];
        int i=0;
        int j=0;
        int t=0;
        Deque<Integer> dq=new LinkedList<>();
        while(j<n){

            if(j<k-1){

                while(!dq.isEmpty() && dq.getLast()>=nums[j]){
                    dq.removeLast();
                }
                dq.add(nums[j]);
                j++;
            }
            else{
                while(!dq.isEmpty() && dq.getLast()>=nums[j]){
                    dq.removeLast();
                }
                dq.add(nums[j]);
                ans[t++]=dq.getFirst();
                if(dq.getFirst()==nums[i]){
                    dq.removeFirst();
                }
                i++;
                j++;
            }




        }

return ans;
    }
}
