package DSA.Matirx;

public class GameOfLife {

    public static void main(String[] args) {
      int [][]board = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
      new GameOfLife().gameOfLife(board);
        System.out.println(board);


    }
    public void gameOfLife(int[][] board) {
        int n=board.length;
        int m=board[0].length;
        int drow[]={-1,-1,-1,0,1,1,1,0};
        int dcol[]={-1,0,1,1,1,0,-1,-1};
        int [][] ans=new int [board.length][board[0].length];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                ans[i][j]=board[i][j];
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int oneCount=0;
                int zeroCount=0;
                int currCell=board[i][j];
                for(int k=0;k<drow.length;k++){
                    int nrow=drow[k]+i;
                    int ncol=dcol[k]+j;
                    if(nrow<n &&nrow>=0 && ncol<m &&ncol>=0){
                        if(board[nrow][ncol]==1)
                            oneCount++;
                        else
                            zeroCount++;
                    }
                }
                if(currCell==1){
                    //live cell
                    if(oneCount<2){
                        ans[i][j]=0;
                    }
                    else if(oneCount>3){
                        ans[i][j]=0;
                    }

                }
                else
                {//dead cell
                    if(oneCount==3){
                        ans[i][j]=1;
                    }

                }

            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){

              board[i][j]=ans[i][j];
            }
          }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){

                System.out.print(board[i][j]+" ");
            }
            System.out.println("");
        }

    }
}
