package DSA.journey.TwoPointers;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Pair{
    int i;
    int j;
    Pair(int i,int j){
        this.i=i;
        this.j=j;
    }
}
public class PairsWithGivenDifference {

    public static void main(String[] args) {
//        int [] A = {5, 2, 2, 4, 9, 8, 5, 3, 8, 8, 10, 4, 2, 10, 9, 7, 6, 1, 3, 9, 7, 1, 3, 5};
//        int B = 3;
//        //ans=2

//        int []A = {8, 12, 16, 4, 0, 20};
//        int B = 4;
//      //  ans 5:

       int [] A ={1, 1, 1, 2, 2};
        int B = 0;
//ans2
        System.out.println(new PairsWithGivenDifference().solve(A,B));
    }
    public int solve(int[] arr, int k) {
        Arrays.sort(arr);
        int n=arr.length;
        Set<String> set=new HashSet<>();
        int i=0;
        int j=1;
        int count=0;
        while(i<n&&j<n) {
            if (i == j) {
                j++;
            } else {
                if (i<n&&j<n && Math.abs(arr[i] - arr[j]) == k) {
                    count++;
                    i++;
                    j++;
                    while(i+1<n && arr[i]==arr[i-1]){
                        i++;
                    }
                    while(j+1<n && arr[j]==arr[j-1]){
                        j++;
                    }
//                    set.add(arr[i]+""+arr[j]);
//                    i++;
//                    j++;
                } else if (i<n&&j<n && Math.abs(arr[i] - arr[j]) < k) {
                    j++;
                } else {
                    i++;
                }
            }
        }
        return count;
      //  return set.size();
    }
}
