package DSA.journey.interveiwBit.week1;

import java.util.Arrays;

public class KthRowPascalTriangle {
    public static void main(String[] args) {
        int ans[]=new KthRowPascalTriangle().getRow(2);
        System.out.println(Arrays.toString(ans));
    }

    public int[] getRow(int n) {
        int mat[][]=new int[n+1][n+1];
        mat[0][0]=1;
        for(int i=1;i<=n;i++){

            for(int j=0;j<=n;j++){
                if(j==0){
                    mat[i][j]=mat[i-1][j];
                }
                else if(j==n){
                    mat[i][j]=mat[i-1][j-1];
                }
                else{
                    mat[i][j]=mat[i-1][j]+mat[i-1][j-1];
                }
            }
        }
        for(int i=0;i<=n;i++){
            for(int j=0;j<=n;j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println("");
        }
        return mat[n];
    }

}
