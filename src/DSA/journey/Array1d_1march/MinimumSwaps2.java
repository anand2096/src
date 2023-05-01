package DSA.journey.Array1d_1march;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Pair{
    int first;
    int second;
    Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}
public class MinimumSwaps2 {

    public static void mainmi(String[] args) {
        int a[] = {2,0,1,3};
        System.out.println(new MinimumSwaps2().solve(a));
    }

    public int solve(int[] arr) {
        List<Pair> list=new ArrayList<>();
        int swaps=0;
        for(int i=0;i<arr.length;i++){

            list.add(new Pair(arr[i],i));
        }
        Collections.sort(list,(i1,i2)->i1.first-i2.first);
        for(int i=0;i<list.size();i++){

            if(list.get(i).second==i){
                continue;
            }
            else{
                swaps++;
                Pair temp=list.get(i);
                int index=temp.second;
                Pair ele=list.get(index);
                list.set(index,temp);
                list.set(i,ele);
                i--;
            }
        }
        return  swaps;
    }
    public int solveOP(int[] arr) {
        int swaps=0;
        int n=arr.length;
        int i=0;
        while(i<n){

            if(i==arr[i]){
                i++;
            }
            else{
                int ele=arr[i];
                int temp=arr[ele];
                arr[ele]=ele;
                arr[i]=temp;
                swaps++;
            }
        }

        return swaps;
    }
}
