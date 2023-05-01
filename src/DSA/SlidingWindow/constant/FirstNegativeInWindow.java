package DSA.SlidingWindow.constant;

import java.util.ArrayList;
import java.util.List;

public class FirstNegativeInWindow {

    public static void main(String[] args) {
       int arr[] = {-8, 2, 3, -6, 10};
       int k = 2;
       int i=0,j=0;
       List<Integer> negativeNumbers=new ArrayList<>();
       while(j<arr.length){
           if(arr[j]<0) negativeNumbers.add(arr[j]);

           if(j-i+1<k){
               j++;
           }
           else if(j-i+1==k){
            if(negativeNumbers.size()==0) System.out.println(0);
            else{
                System.out.println(negativeNumbers.get(0));
                if(arr[i]==negativeNumbers.get(0)){
                    negativeNumbers.remove(0);
                }
            }

            i++;j++;
           }
       }

    }


}
