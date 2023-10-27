package DSA.journey.Heap;
import java.util.PriorityQueue;
public class ProductOfThree {
    public static void main(String[] args) {
        int nums[]={1,2,3,4,5};
        int ans[]=new ProductOfThree().solve(nums);
    }
    public int[] solve(int[] nums) {
        //put -1 in the array
        // make heap of 3 elements
        //now itereate over next n-3 elements and if we gets a larger element then min of heap remove that element and push new do the same for product;
        int product=1;
        int n=nums.length;
        int ans[]=new int[n];
        for(int i=0;i<n;i++){
            ans[i]=-1;
        }
        PriorityQueue<Integer> pq=new PriorityQueue<>(3);
        int k=3;
        for(int i=0;i<k;i++){
            pq.add(nums[i]);
            product*=nums[i];
        }
        int j=k-1;
        ans[j++]=product;
        for(int i=k;i<n;i++){
            if(nums[i]>pq.peek()){
                product=product/pq.peek();
                pq.remove();
                product=product*nums[i];
                pq.add(nums[i]);
            }
            ans[j++]=product;
        }
        return ans;


    }
}
