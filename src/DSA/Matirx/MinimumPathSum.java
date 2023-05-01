package DSA.Matirx;

public class MinimumPathSum {
    int min=Integer.MAX_VALUE;
    public static void main(String[] args) {
        int [][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(new MinimumPathSum().minPathSum(grid));
    }

    public int minPathSum(int[][] grid) {
        int[][] memo = new int[grid.length][grid[0].length];
        int n=grid.length-1;
        int m=grid[0].length-1;
        rec(0,0,grid,n,m,0,memo);
        return min;
    }
    public void rec(int i,int j,int [][] grid,int n,int m,int sum,int [][]memo){
        if(i>n || j>m){
            return;
        }
        if(i==n&&j==m){
            min=Math.min(min,sum+grid[i][j]);
            return;
        }

        else{

            rec(i+1,j,grid,n,m,sum+grid[i][j],memo);
            rec(i,j+1,grid,n,m,sum+grid[i][j],memo);

        }

    }
}
