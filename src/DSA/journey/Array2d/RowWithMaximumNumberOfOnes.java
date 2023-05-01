package DSA.journey.Array2d;

public class RowWithMaximumNumberOfOnes {

    public static void main(String[] args) {
        int arr[][]= {
                {0, 0, 1, 1},
                {0, 0, 1, 1},
                {0, 0, 1, 1},
                {1, 1, 1, 1},
        };

        System.out.println(new RowWithMaximumNumberOfOnes().solve(arr));
    }

    public int solve(int[][] arr) {
        int max=Integer.MIN_VALUE;
        int rowIndex=-1;
        int n=arr.length;
        int m=arr[0].length;
        int row=0;
        int col=m-1;

        while(row<n&&col>=0){
            while((row<n&&col>=0) && (arr[row][col]==1)){
                col--;
            }
            int noOfZeros=m-col-1;
            if(max<noOfZeros){
                max=noOfZeros;
                rowIndex=row;
            }
            row++;

        }
      //  System.out.println("row :: "+rowIndex);
      //  System.out.println("maxZeros :: "+ max);
    return rowIndex;
    }
}
