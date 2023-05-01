package DSA.Graph;

public class SurroundedRegion {
    public static void main(String[] args) {
//        char[][] board = {{'X' , 'X' , 'X' , 'X'}
//                       , {'X' , 'O' , 'O' , 'X'}
//                       , {'X' , 'X' , 'O' , 'X'},
//                         {'X' , 'O' , 'X' , 'X'}};
//
        char[][] board = {{'X' , 'O' , 'X' , 'X'}
                       , {'O' , 'X' , 'O' , 'X'}
                       , {'X' , 'O' , 'X' , 'O'},
                         {'O' , 'X' , 'O' , 'X'}};


     //   [["X","O","X","X"],["O","X","O","X"],["X","O","X","O"],["O","X","O","X"]]
       // char[][] board = {{'O'}};
        new SurroundedRegion().solve(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        int delRow[] = {-1, 0, 1, 0};
        int delCol[] = {0, 1, 0, -1};

        boolean visited[][] = new boolean[board.length][board[0].length];
        for (int j = 0; j < m; j++) {
            //left row
            if (board[0][j] == 'O' && !visited[0][j]) {
                dfs(0, j, board, visited, delRow, delCol);
            }
            if (board[n-1][j] == 'O' && !visited[n-1][j]) {
                dfs(n-1, j, board, visited, delRow, delCol);
            }
        }
        for (int i = 0; i < n; i++) {
            //left col
            if (board[i][0] == 'O' && !visited[i][0]) {
                dfs(i, 0, board, visited, delRow, delCol);
            }
            //right col
            if (board[i][m-1] == 'O' && !visited[i][m-1]) {
                dfs( i, m-1, board, visited, delRow, delCol);
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
              if(!visited[i][j]&&board[i][j]=='O'){
                  board[i][j]='X';
              }
            }
        }


    }

    public void dfs(int i, int j, char[][] board, boolean[][] vis, int[] delRow, int[] delCol) {
        int n = board.length;
        int m = board[0].length;
        vis[i][j] = true;
        for (int t = 0; t < 4; t++) {
            int nRow = delRow[t] + i;
            int nCol = delCol[t] + j;
            if (nRow < n && nRow >= 0 && nCol < m && nCol >= 0 && board[nRow][nCol] == 'O' && !vis[nRow][nCol]) {
                dfs(nRow, nCol, board, vis, delRow, delCol);
            }
        }

    }


}
