package DSA.journey.Array2d;

public class MaximumSumSquareSubMatrix {
    public static void main(String[] args) {
        int arr[][]={
                {1, 1, 1, 1, 1},
                {2, 2, 2, 2, 2},
                {3, 8, 6, 7, 3},
                {4, 4, 4, 4, 4},
                {5, 5, 5, 5, 5},
        };
        int b=3;
//        int arr[][]={
//                {2, 2},
//                {2, 2}};
//        int b=2;
        System.out.println(new MaximumSumSquareSubMatrix().solve(arr,b));
    }


    public int [][] getPrefixMatrix(int arr [][]){
        int n=arr.length;
        int m=arr[0].length;
        int [][]prefixMatrix=new int[arr.length][arr[0].length];

        prefixMatrix[0][0]=arr[0][0];
        for(int i=1;i<n;i++){
            prefixMatrix[0][i]=prefixMatrix[0][i-1]+arr[0][i];
        }
        for(int i=1;i<m;i++){
            prefixMatrix[i][0]=prefixMatrix[i-1][0]+arr[i][0];
        }


        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                prefixMatrix[i][j]=arr[i][j]+prefixMatrix[i-1][j]+prefixMatrix[i][j-1]-prefixMatrix[i-1][j-1];
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(prefixMatrix[i][j]+" ");
            }
            System.out.println();
        }
        return prefixMatrix;
    }
    public int solve(int[][] arr, int k) {
        getPrefixMatrix(arr);


        int max=Integer.MIN_VALUE;
        int n=arr.length;
        int m=arr[0].length;
        int prefixArray[][]=new int[n][m];
        //row wise

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if (j == 0) {
                    prefixArray[i][j]=arr[i][j];
                }
                else{
                    prefixArray[i][j]=prefixArray[i][j-1]+arr[i][j];
                }
            }
        }
        //col wise
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0){
                    prefixArray[i][j]=prefixArray[i][j];
                }else{
                    prefixArray[i][j]=prefixArray[i-1][j]+prefixArray[i][j];
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(prefixArray[i][j]+" ");
            }
            System.out.println();
        }

//
//        for(int i=0;i<n;i++){
//            for(int j=0;j<m;j++){
//                System.out.print(getp[i][j]+" ");
//            }
//            System.out.println();
//        }

        for(int row=0;row<n;row++){
            int startRow=row;
            int endRow=row+k-1;
            for(int col=0;col<m;col++){
                int startCol=col;
                int endCol=col+k-1;
                if(endCol<m && endRow<n){
                    int a1=row;
                    int b1=startCol;
                    int a2=endRow;
                    int b2=endCol;
                    int sum=0;
                    sum=prefixArray[a2][b2];
                    if(b1>0){
                        sum=(sum-prefixArray[a2][b1-1]);
                    }
                    if(a1>0){
                        sum=(sum-prefixArray[a1-1][b2]);
                    }
                    if(a1>0 && b1>0){
                        sum=(sum+prefixArray[a1-1][b1-1]);
                    }
                    if(max<sum){
                        max=sum;
                    }

//                    if(sum<0){
//                        sum=sum;
//
//                    }

                }




            }

        }





        return max;
    }
}
