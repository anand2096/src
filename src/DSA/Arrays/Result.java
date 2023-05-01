package DSA.Arrays;


import java.util.Arrays;

public class Result {


  static int countWays(int S[], int m, int n)
    {

        int[] table = new int[n+1];

        Arrays.fill(table, 0);


        table[0] = 1;

        for (int i=0; i<m; i++)
            for (int j=S[i]; j<=n; j++)
                table[j] += table[j-S[i]];

        return table[n];
    }

    public static int ways(int total,int k){

        int arr[] = new int [k];
        for(int i=1;i<=k;i++)
            arr[i]=i;
        int m = arr.length;
        return countWays(arr, m, total);

    }
}