package DSA.journey.Array2d;

public class MaximumSubmatrixSum {

    public static void main(String[] args) {
     int a[][]=   {{-5 ,-4 ,-3},
        { -1 , 2 , 3},
        {2 , 2 , 4}};
        System.out.println(new MaximumSubmatrixSum().solve(a));
    }

    public long solve(int[][] a) {
        int n=a.length;
        int m=a[0].length;
         long ans=Long.MIN_VALUE;
        long [][]prefixSum=new long[n][m];
        for(int i=0;i<n;i++) {
            for (int j = m - 1; j >= 0; j--) {
                if(j==m-1){
                    prefixSum[i][j]=(long)a[i][j];
                }

              else{
                  prefixSum[i][j]=(long)a[i][j]+prefixSum[i][j+1];
              }
            }
        }

        for(int j=m-1;j>=0;j--){
            for(int i=n-1;i>=0;i--){

                if(i==n-1){
                    prefixSum[i][j]=(long)prefixSum[i][j];
                }else {
                    prefixSum[i][j] = (long) prefixSum[i][j] + prefixSum[i+1][j ];
                }

                if(ans<prefixSum[i][j]){
                    ans=prefixSum[i][j];
                }
            }

        }


        return ans;
    }
}
