package DSA.journey.Array1d_1march;

public class ContinuousSumQuery {

    public static void main(String[] args) {
        int q[][] = {{1, 2, 10}, {2, 3, 20}, {2, 5, 25}};
        int n = 5;

        int ans[] = new ContinuousSumQuery().solve(n, q);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }

    public int[] solve(int n, int[][] queries) {

        int arr[] = new int[n];
        for (int i = 0; i < queries.length; i++) {
            int temp[] = queries[i];
            int l=temp[0]-1;
            int h=temp[1]-1;
            int cost=temp[2];
            arr[l] = arr[l] + temp[2];
            if(h+1<n) {
                arr[h+1] = arr[h+1] - temp[2];
            }
        }

        for(int i=1;i<n;i++){
            arr[i]=arr[i]+arr[i-1];
        }
        return arr;
    }




}
