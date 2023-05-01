package DSA.journey.Array2d;

public class SearchInARowWiseAndColumnWiseSortedMatrix {


    public static void main(String[] args) {
//      int a[][]=  {   {1, 2, 3},
//            {4, 5, 6},
//            {7, 8, 9}  };
        int a[][]=  {   {1, 2},
                {3,3  }};
        int b = 3;
        System.out.println(new SearchInARowWiseAndColumnWiseSortedMatrix().solve(a,b));
    }
    public int solve(int[][] a, int b) {
        int ans=Integer.MAX_VALUE;
        int n=a.length;
        int m=a[0].length;
        int i=0;
        int j=m-1;

        while(i<n && j>=0){

            if(a[i][j]==b){
                int foundValue=((i+1)*1009)+(j+1);
                if(foundValue<ans){
                    ans=foundValue;
                }

                j--;
            }
            else if(b<a[i][j]){
                j--;
            }
            else{
                i++;
            }
        }
        if(ans==Integer.MAX_VALUE)
            return -1;
        return ans;
    }
}
