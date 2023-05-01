package DSA.journey.PrefixSum;

public class IncrementSubmatricesByOne {

    public static void main(String[] args) {
       int n = 3; int [][]queries = {{1,1,2,2},{0,0,1,1}};
        //int n = 2; int [][]queries = {{0,0,1,1}};
        int ans[][]=new IncrementSubmatricesByOne().rangeAddQueriesOptimized(n,queries);
       for(int i=0;i<ans.length;i++){
           for(int j=0;j<ans[0].length;j++){
               System.out.print(ans[i][j]+" ");
           }
           System.out.println("");
       }

    }

    public int[][] rangeAddQueries(int n, int[][] queries) {
        int [][]ans=new int[n][n];
        for(int i=0;i<queries.length;i++){
            int []query=queries[i];
            for(int j=query[0];j<=query[2];j++){
                for(int k=query[1];k<=query[3];k++){
                    ans[j][k]++;
                }
            }
        }


return ans;
    }



    public int[][] rangeAddQueriesOptimized(int n, int[][] queries) {
        int [][]ans=new int[n][n];
        for(int i=0;i<queries.length;i++){
            //11 22
            //00 11
            int []query=queries[i];
            int row1=query[0];
            int row2=query[2];
            for(int j=row1;j<=row2;j++){
                // 1 1 +
                // 1 3 -
                // 2 1 +
                // 2 2
                //0 0 +
                //
                    ans[j][query[1]]++;
                    if (query[3]+1 < n) {
                        ans[j][query[3]+1] --;
                    }
            }

        }

        for(int i=0;i<n;i++){

            for(int j=1;j<n;j++){
                ans[i][j]=ans[i][j]+ans[i][j-1];
            }
        }

        return ans;
    }
}
