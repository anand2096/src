package DSA.journey.Hashing;

import java.util.*;

public class SortArrayInGivenOrder {

    public static void main(String[] args) {
      int []  A = {6, 13, 20, 9, 8, 6, 9, 2 };
    int[]    B = {  7, 14, 11, 4, 15, 5, 9, 20, 12, 6 };
    int ans[]=new SortArrayInGivenOrder().solve(A,B);
    for(int i=0;i<ans.length;i++){
        System.out.print(ans[i]+" ");
    }
    }

    public int[] solve(int[] arr, int[] brr){
        List<Integer>ans=new ArrayList<>();
        Map<Integer,Integer> tMap=new TreeMap<>();
        for(int i=0;i<arr.length;i++){
            tMap.put(arr[i],tMap.getOrDefault(arr[i],0)+1);
        }
        for(int i=0;i<brr.length;i++){
            if(tMap.containsKey(brr[i])){
                int val=tMap.get(brr[i]);
                for(int j=1;j<=val;j++){
                    ans.add(brr[i]);
                }
                tMap.remove(brr[i]);
            }
        }
        for (Map.Entry<Integer, Integer> entry : tMap.entrySet()){
            int val= entry.getValue();
            for(int j=1;j<=val;j++){
                ans.add(entry.getKey());
            }

        }

        int fAns[]=new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            fAns[i]=ans.get(i);
        }
        return fAns;
    }

    public int[] solve1(int[] A, int[] B) {
        List<Integer> listA=new ArrayList<>();
        for(int i=0;i<A.length;i++){
            listA.add(A[i]);
        }

        List<Integer>ans=new ArrayList<>();

        int k=0;
        for(int i=0;i<B.length;i++){
            if(listA.contains(B[i])){

                //ans.add(B[i]);
                while (listA.indexOf(B[i])!=-1){
                    ans.add(B[i]);
                    listA.remove(listA.indexOf(B[i]));
                }
//                int fIndex=listA.indexOf(B[i]);
//                int lIndex=listA.lastIndexOf(B[i]);
//                for(int j=fIndex;j<=lIndex;j++){
//                   // ans[k++]=B[i];
//                    ans.add(B[i]);
//                    int index=listA.indexOf(B[i]);
//                    listA.remove(index);
//                }

            }
        }
        Collections.sort(listA);
        for(int i=0;i<listA.size();i++){
         //  ans[k++]=listA.get(i);
            ans.add(listA.get(i));
        }
        int fAns[]=new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            fAns[i]=ans.get(i);
        }
        return fAns;
    }
}
