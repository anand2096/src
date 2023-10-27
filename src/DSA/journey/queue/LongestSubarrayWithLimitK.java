package DSA.journey.queue;

import java.util.Deque;
import java.util.LinkedList;

public class LongestSubarrayWithLimitK {

    public static void main(String[] args) {

    }

    public int longestSubarray(int[] nums, int limit) {
        int ans = Integer.MIN_VALUE;
        Deque<Integer> minQ=new LinkedList<>();
        Deque<Integer> maxQ=new LinkedList<>();
        int i=0;
        int j=0;
        int n=nums.length;
        while(j<n){


            int val=nums[j];
            while(!minQ.isEmpty()  && nums[minQ.peekLast()]>=val){
                minQ.pollLast();
            }
            minQ.addLast(j);
            while(!maxQ.isEmpty() &&nums[maxQ.peekLast()]<=val){
                maxQ.pollLast();
            }
            maxQ.add(j);

            int minVal=minQ.peekFirst();
            int maxVal=maxQ.peekFirst();
            if(maxVal-minVal<=limit){
                ans=Math.max(ans,j-i+1);
                j++;
            }
            else{
                i++;
                while(i>minQ.peekFirst())minQ.pollFirst();
                while(i>maxQ.peekFirst())maxQ.pollFirst();

            }

        }

        return ans;
    }
}
