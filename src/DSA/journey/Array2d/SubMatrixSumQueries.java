package DSA.journey.Array2d;

public class SubMatrixSumQueries {

    public static void main(String[] args) {
        int a[][]= {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int b[] = { 1,2};
        int c[]= {1,2};
        int d[]= { 2,2};
        int e[]= {2,4};
        int ans []=new SubMatrixSumQueries().solve(a,b,c,d,e);
        for(int i=0;i<ans.length;i++){
            System.out.print(ans[i]+" ");
        }

    }
    public int[] solve(int[][] A, int[] B, int[] C, int[] D, int[] E) {
        int mod=1000000007;
        int ans[]=new int[B.length];
        int [][]prefixSum=new int[A.length][A[0].length];
        int n=A.length;
        int m=A[0].length;
        //row wise
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(j==0){
                    prefixSum[i][j]=A[i][j];
                }else{
                    prefixSum[i][j]=(A[i][j]%mod+prefixSum[i][j-1]%mod)%mod;
                }
            }
        }
        //col wise
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(j==0 ){
                    prefixSum[j][i]=prefixSum[j][i]%mod;
                    continue;
                }else{
                    prefixSum[j][i]=(prefixSum[j][i]%mod+prefixSum[j-1][i]%mod)%mod;
                }
            }
        }
        // query
        for(int i=0;i<B.length;i++){
            int a1=B[i]-1;
            int b1=C[i]-1;
            int a2=D[i]-1;
            int b2=E[i]-1;
            int sum=0;
            sum=prefixSum[a2][b2];
            if(b1>0){
                sum=(sum%mod-prefixSum[a2][b1-1]%mod)%mod;
            }
            if(a1>0){
                sum=(sum%mod-prefixSum[a1-1][b2]%mod)%mod;
            }
            if(a1>0 && b1>0){
                sum=(sum%mod+prefixSum[a1-1][b1-1]%mod)%mod;
            }
            if(sum<0){
                sum=sum+mod;

            }
            ans[i]=sum%mod;
        }

        return  ans;

    }
}
