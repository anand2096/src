package DSA.Graph;

import DSA.Pair;

import java.util.LinkedList;
import java.util.Queue;


public class NumberOfIslands {

    public void bfs(char[][] grid, int[][] visited, int row, int col) {
        visited[row][col] = 1;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(row, col));
        int n = grid.length;
        int m = grid[0].length;
        while (!queue.isEmpty()) {
            Pair pop = queue.peek();
            queue.remove();
            for (int delrow = -1; delrow <= 1; delrow++) {
                for (int delcol = -1; delcol <= 1; delcol++) {
                    int nrow = delrow + pop.first;
                    int ncol = delcol + pop.second;
                    if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && visited[nrow][ncol] == 0 && grid[nrow][ncol] == '1') {
                        visited[nrow][ncol] = 1;
                        queue.add(new Pair(nrow, ncol));
                    }
                }
            }


        }

    }

    public int numIslands(char[][] grid) {
        int cnt = 0;
        int n = grid.length;
        int m = grid[0].length;

        int visited[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] == 0 && grid[i][j] =='1' ) {
                    cnt++;
                    bfs(grid, visited, i, j);
                }

            }
        }

        return cnt;
    }
}
