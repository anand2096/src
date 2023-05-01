package DSA.leetCodeDaily;

import java.util.Arrays;

public class SuccessfulPairsOfSpellsAndPotions {

    public static void main(String[] args) {
        int []spells={15,8,19};
        int [] potions={38,36,23};

        long success=328;
        int ans[]=new SuccessfulPairsOfSpellsAndPotions().successfulPairs(spells,potions,success);
        for(int i=0;i<ans.length;i++){
            System.out.print(ans[i]+" ");
        }
    }
    public int[] successfulPairs(int[] spells, int[] potions, long success) {

        int n=potions.length;
        int ans[]=new int[spells.length];
        Arrays.sort(potions);
        for(int i=0;i<spells.length;i++){
            // TLE
//            while(j<n ){
//                long temp= ((long) spells[i] *potions[j]);
//                if(temp<success)
//                    j++;
//                else break;
//            }
            // Binary Search
            int s=0;
            int e=n-1;
           // int t=0;
          //  long product1= ((long) spells[i] *potions[0]);
          //  long product2= ((long) spells[i] *potions[n-1]);
//            if(product1>=success){
//                ans[i]=n;
//            }
//            else if(product2<success){
//                ans[i]=0;
//            }
//            else{
                while(s<=e){
                    int mid=s+(e-s)/2;
                    long product= ((long) spells[i] *potions[mid]);
                    if(product>=success){
                     //   t=mid;
                        e=mid-1;
                    }
                    else{
                        s=mid+1;
                    }
                }
                    ans[i]=n-s;
           // }

        }
        return ans;


    }
}
