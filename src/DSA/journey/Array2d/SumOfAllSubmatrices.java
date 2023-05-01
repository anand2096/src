package DSA.journey.Array2d;

public class SumOfAllSubmatrices {
    public static void main(String[] args) {
       int [][] a = {{1, 1},
               {1, 1}};

        System.out.println(new SumOfAllSubmatrices().solve(a));
    }
    public int solve(int[][] a) {
     int sum=0;
     //Top left cells =     (i*1) * (j+1)
     //Bottom right cells = (N-i) * (N-j)

        int n=a.length;
        int m=a[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){

                int  topLefts=(i+1)*(j+1);
                int bottomRights=(n-i)*(m-j);
                int k=topLefts*bottomRights;
                sum=sum+(a[i][j]*k);

            }
        }

     return sum;
    }
}
