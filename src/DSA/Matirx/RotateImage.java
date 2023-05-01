package DSA.Matirx;

public class RotateImage {

    public static void main(String[] args) {
       int [][] A = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
       int N=A.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(A[i][j] + " ");
            System.out.print("\n");
        }
        new RotateImage().rotate(A);

        System.out.print("Modified matrix is \n");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(A[i][j] + " ");
            System.out.print("\n");
        }
    }
    public void rotate(int[][] matrix) {
        for(int i=0;i<matrix.length;i++){
            for(int j=i+1;j<matrix[0].length;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }

        //reverse each row
        for(int i=0;i<matrix.length;i++){
            int j=0;
            int m=matrix[i].length-1;
            while (j<m){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[i][m];
                matrix[i][m]=temp;
                j++;
                m--;
            }
        }

        // 01 10
        //02 20
        //12 21
        // 22 22
    }
}
