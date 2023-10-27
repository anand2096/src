package DSA.journey.leetcode75;
import  java.util.*;
public class EqualRowColumnPairs {

    public static void main(String[] args) {

       int mat[][]= {{11,1},{1,11}};
        System.out.println(new EqualRowColumnPairs().equalPairs(mat));
    }

    public int equalPairs(int[][] grid) {
        int pairs=0;
        Map<String,Integer> map=new HashMap<>();
        int n=grid.length;
        int m=grid[0].length;
        for(int i=0;i<n;i++){
            StringBuilder sb=new StringBuilder();
            for(int j=0;j<m;j++){
                sb.append(grid[i][j]);
            }
            map.put(sb.toString(),map.getOrDefault(sb.toString(),0)+1);
        }

        for(int j=0;j<m;j++){
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<n;i++){
                sb.append(grid[i][j]);
            }
            if(map.containsKey(sb.toString())){
                pairs+=map.get(sb.toString());
            }
        }
        return pairs;
    }
}
