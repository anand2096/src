package DSA.Matirx;

import java.util.LinkedList;
import java.util.Queue;


class IndexPair{

    int row;
    int col;
    IndexPair(int row,int col){
        this.row=row;
        this.col=col;
    }
}

public class SetMatrixZeroes {

    public static void main(String[] args) {
     int [][]  matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};

      new SetMatrixZeroes().setZeroes(matrix);
    }
    public void setZeroes(int[][] matrix) {



    }

    public void setZeroesBRUTE(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        Queue<IndexPair> queue=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==0){
                    queue.add(new IndexPair(i,j));
                }
            }
        }

        while(!queue.isEmpty()){
            int row=queue.peek().row;
            int col=queue.peek().col;
            queue.remove();

            for(int i=0;i<m;i++){
                matrix[row][i]=0;
            }
            for(int i=0;i<n;i++){
                matrix[i][col]=0;
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }

    }
}
