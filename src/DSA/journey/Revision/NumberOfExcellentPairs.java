package DSA.journey.Revision;
import java.util.*;
class Pair{
    int no;
    int setBits;
    public Pair(int no,int setBits){
        this.no=no;this.setBits=setBits;
    }
}
public class NumberOfExcellentPairs {
    public static void main(String[] args) {
        int n[]={1,2,3,1,536870911};
        int k=3;
        System.out.println( new NumberOfExcellentPairs().countExcellentPairs(n,k));
    }

    public long countExcellentPairs(int[] nums, int k) {
        long ans=0;
        List<Pair> list=new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            int count=0;
            // for(int j=30;j>=0;j--){
            //     if(checkSetBit(nums[i],j)){
            //         count++;
            //     }
            // }
            int setBitsInOr=countSetBits(nums[i]);
            list.add(new Pair(nums[i],setBitsInOr));

        }
        for(int i=0;i<list.size();i++){
            if(list.get(i).setBits *2 >=k)ans++;
        }


        int i=0;
        int j=nums.length-1;
        while(i<=j){
            int orSetBits=list.get(i).setBits+list.get(j).setBits;
            int andNum=list.get(i).no & list.get(j).no;
            // int setBitsInAnd=setBitsAnd(andNum);
            int setBitsInAnd=countSetBits(andNum);
            if(orSetBits+setBitsInAnd>=k){
                ans=ans+2;
                i++;
                j--;
            }

            else {
                i++;
            }
        }

        return ans;
    }
    public int setBitsAnd(int no){
        int count=0;
        for(int i=30;i>=0;i--){
            if(checkSetBit(no,i)){
                count++;
            }
        }
        return count;
    }
    public boolean checkSetBit(int n,int ind){
        return (((n>>ind)&1)==1);
    }


    public  int countSetBits(int number) {
        int count = 0;
        while (number != 0) {
            number &= (number - 1);
            count++;
        }
        return count;
    }
}
