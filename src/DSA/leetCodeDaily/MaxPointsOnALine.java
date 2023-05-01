package DSA.leetCodeDaily;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxPointsOnALine {
    public static void main(String[] args) {
       //int  points [][]= {{1,1},{2,2},{3,3}};
        //int points[][] = {{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}};
        int points[][] = {{4, 5}, {4, -1}, {4, 0}};
       // int points[][] = { { -1, 1 }, { 0, 0 }, { 1, 1 },
               // { 2, 2 },  { 3, 3 }, { 3, 4 } };
        System.out.println(new MaxPointsOnALine().maxPoints(points));
    }

    static int gcd(int p, int q) {
        if (q == 0) {
            return p;
        }
        int r = p % q;
        return gcd(q, r);
    }

    public int maxPoints(int[][] points) {
        if (points.length <= 2) return points.length;
        int max = 0;
        for (int i = 0; i < points.length; i++) {
            Map<String, Integer> slopeMap = new HashMap<>();
            int curMax = 0;
            int overlapPoints = 0;
            int verticalPoint = 0;
            for (int j = i + 1; j < points.length; j++) {
                int prev_point[] = points[i];
                int point[] = points[j];
                //checking if both the points are same
                if (point[0] == prev_point[0] && point[1] == prev_point[1]) overlapPoints++;

                    //checking if both the points are vertical(then there x co-ordinate would be same)
                else if (point[0] == prev_point[0]) verticalPoint++;
                else {
                    int y2_y1 = point[1] - prev_point[1];
                    int x2_x1 = point[0] - prev_point[0];

                    int gcd = gcd(x2_x1, y2_y1);
                    x2_x1 /= gcd;
                    y2_y1 /= gcd;

                    String slope = y2_y1 + " " + x2_x1;
                    if (!slopeMap.containsKey(slope))
                        slopeMap.put(slope, 0);

                    slopeMap.put(slope,
                            slopeMap.get(slope) + 1);
                    curMax = Math.max(curMax, slopeMap.get(slope));


                }
                curMax = Math.max(curMax, verticalPoint);
            }
            max = Math.max(max,
                    curMax + overlapPoints + 1);
            }
        return max + 1;
    }
}
