package DSA.leetCodeDaily;

import java.util.HashMap;
import java.util.Map;

public class FindTheTownJudge {

    public static void main(String[] args) {
        int n = 3, trust[][] = {{1, 3},{2, 3},{3, 1}};
       // int n = 4, trust[][] = {{3, 2},{4, 1},{3, 1},{2, 1},{2, 3},{4, 3},{4, 2},{3, 4}};

        System.out.println(new FindTheTownJudge().findJudge2(n, trust));
    }

    public int findJudge(int n, int[][] trust) {
        if(trust.length==0)return -1;
        if(trust.length==0 &&n>1) return -1;
        int ans = -1;
        int index=-1;
        Map<Integer, Integer> map = new HashMap<>();
        int arr[] = new int[n + 1];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < trust.length; i++) {

            int[] temp = trust[i];
            map.put(temp[0], temp[1]);
            arr[temp[1]]++;
        }
        for(int i=0;i<arr.length;i++){
            if(max<arr[i]){
                max=arr[i];
                index=i;
            }
        }
        if (arr[index] == n - 1 && !map.containsKey(index))
            return index;
        return -1;
    }
    public int findJudge2(int n, int[][] trust) {
        if(n==1 && trust.length == 0) return 1;
        int [] count = new int[n+1];
        for(int i = 0;i<trust.length;i++){

            count[trust[i][0]]--;

            count[trust[i][1]]++;
        }

        for(int i = 0;i<count.length;i++){
            if(count[i] ==n-1)  return i;
        }
        return -1;
    }
}
