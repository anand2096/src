package DSA.journey.feb17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayRotation {
    public static void main(String[] args) {

        System.out.println(new ArrayRotation().solve(Arrays.asList(2,5,6),5));

    }
   // 5 6 2
    public List<Integer> solve(List<Integer> A, int k) {
        if(k>A.size()-1){
            k=k%A.size();
        }
        reverseArray(A,0,A.size()-1);
        reverseArray(A,0,k-1);
        reverseArray(A,k,A.size()-1);
        return A;


    }

    public void reverseArray(List<Integer> A,int s,int e){
        int i=s;
        int j=e;
        while(i<=j){
            int temp=A.get(i);
            A.set(i,A.get(j));
            A.set(j,temp);
            i++;j--;
        }
    }
}
