package DSA.Recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NQueen {
    public static void main(String[] args) {

        System.out.println(new NQueen().solveNQueens(4));

    }

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> ans = new ArrayList<>();


        char[][] board = new char[n][n];
        for(int u=0;u<n;u++){
            for(int v=0;v<n;v++){
                board[u][v]='.';
            }
        }
        boolean  [] leftRow=new boolean[n];
        boolean  [] upperDiagonal=new boolean[2*n-1];
        boolean  [] lowerDiagonal=new boolean[2*n-1];

        generateSol(n, board, ans,0,leftRow,upperDiagonal,lowerDiagonal);

        return ans;
    }

    private void generateSol(int n, char[][] board, List<List<String>> ans,int col ,boolean [] leftRow,boolean [] upperDiagonal,boolean [] lowerDiagonal) {
        if(col==n){
            List<String> temp=new ArrayList<>();
            for(int u=0;u<n;u++){
                String s="";
                for(int v=0;v<n;v++){
                    s=s+board[u][v];
                }
                temp.add(s);
            }
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int row = 0; row < n; row++) {
            if(!leftRow[row] && !lowerDiagonal[row+col] && !upperDiagonal[n-1+col-row]){
                board[row][col]='Q';
                leftRow[row]=true;
                lowerDiagonal[row+col]=true;
                upperDiagonal[n-1+col-row]=true;
                generateSol(n,board,ans,col+1,leftRow,upperDiagonal,lowerDiagonal);
                board[row][col]='.';
                leftRow[row]=false;
                lowerDiagonal[row+col]=false;
                upperDiagonal[n-1+col-row]=false;

            }


        }
//        for (int row = 0; row < n; row++) {
//                if(canPlot(board,n,row,col)){
//                    board[row][col]='Q';
//                    generateSol(n,board,ans,col+1);
//                    board[row][col]='.';
//                }
//
//
//        }
    }



    public boolean canPlot(char[][] board, int n, int r, int c) {
        int a = r, b = c;
        boolean ans = true;
        //row- col check
        while(b>=0) {
            if (board[r][b] == 'Q') {
                return false;
            }
            b--;
        }
        //left upper diagonal check
         a = r; b = c;
        while (a >= 0 && b >= 0) {
            if (board[a][b] == 'Q') {
                return false;
            }
            a--;
            b--;

        }
//        //left bottom diagonal check
//        a = r;
//        b = c;
//        while (a < n && b < n) {
//            if (board[a][b] == 'Q')
//                return false;
//            a++;
//            b++;
//        }


//        //right upper diagonal check
//        a = r;
//        b = c;
//        while (a >= 0 && b < n) {
//            if (board[a][b] == 'Q')
//                return false;
//            a--;
//            b++;
//        }

        //right bottom diagonal check
        a = r;
        b = c;
        while (a < n && b >= 0) {
            if (board[a][b] == 'Q')
                return false;
            a++;
            b--;
        }
        return ans;
    }
}

