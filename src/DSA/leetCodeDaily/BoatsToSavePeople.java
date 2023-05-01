package DSA.leetCodeDaily;

import java.util.Arrays;

public class BoatsToSavePeople {

    public static void main(String[] args) {
        int arr[]={5,1,4,2};
        int limit=6;
        System.out.println(new BoatsToSavePeople().numRescueBoats(arr,limit));
    }
    public int numRescueBoats(int[] people, int limit) {
        int boats=0;
        int n=people.length;
       Arrays.sort(people);
        int i=0; int j=n-1;

        while(i<=j){
            if(people[i]+people[j]<=limit){
                boats++;
                i++;
                j--;
            }
            else{
                boats++;
                j--;
            }
        }





//        for(i=1;i<n;){
//            if(people[i]+people[i-1]<=limit){
//                boats=boats+1;
//            }
//            else{
//                boats=boats+2;
//            }
//            i=i+2;
//        }
//
//        if(n%2!=0){
//            if(people[n-1]<=limit){
//                boats=boats+1;
//            }
//            else{
//                boats=boats+2;
//            }
//        }
//

        return boats;
    }
}
