package DSA.leetCodeDaily;

import java.util.LinkedList;
import java.util.Queue;


class Land {

    int start;
    int end;
    int dis;

    Land(int start, int end, int dis) {
        this.start = start;
        this.end = end;
        this.dis = dis;
    }
}


public class AsFarFromLandAsPossible {
    public static void main(String[] args) {
        int[][] grid = {{1, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        System.out.println(new AsFarFromLandAsPossible().maxDistance(grid));
    }

    public int maxDistance(int[][] grid) {
        int ans = 0;
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int[][] result = new int[n][n];
        Queue<Land> queue = new LinkedList<>();
        int delRow[] = {-1, 0, 1, 0};
        int delCol[] = {0, 1, 0, -1};
        for (int i = 0; i <n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    visited[i][j]=true;
                    queue.add(new Land(i,j,0));
                }
            }
        }
        while(!queue.isEmpty()){
            Land peek=queue.peek();
            int start=peek.start;
            int end=peek.end;
            int dis=peek.dis;
            queue.remove(peek);
            result[start][end]=dis;
            for(int i=0;i<4;i++){
                int nRow=delRow[i]+start;
                int nCol=delCol[i]+end;
                if(nRow>=0&&nRow<n&&nCol>=0&&nCol<m&& !visited[nRow][nCol]){
                    visited[nRow][nCol]=true;
                    queue.add(new Land(nRow,nCol,dis+1));
                }
            }
        }
        for (int i = 0; i <n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0){
                    if(result[i][j]>ans){
                        ans=result[i][j];
                    }
                }
            }
        }
        return ans;

    }
}
