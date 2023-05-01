package DSA.journey.Hashing;


import DSA.Pair;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Point{
    int x;
    int y;
    public Point(int x,int y){
        this.x=x;
        this.y=y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
public class CountRectangles {
    public static void main(String[] args) {
        int [] A = {1, 1, 2, 2};
       int [] B = {1, 2, 1, 2};
        System.out.println(new CountRectangles().solve(A,B));
    }
    public int solve(int[] x, int[] y) {
        int count=0;
        HashSet<Point> set=new HashSet<>();
        for(int i=0;i<x.length;i++){
            Point p=new Point(x[i],y[i]);
            set.add(p);
        }

        for(int i=0;i<x.length;i++){
            for(int j=0;j<y.length;j++){
                int xi=x[i];
                int yi=y[i];
                int xj=x[j];
                int yj=y[j];
                if(xi<xj &&yi <yj){
                    Point p1=new Point(xi,yj);
                    Point p2=new Point(xj,yi);
                    if(set.contains(p1)&& set.contains(p2)){
                        count++;
                    }

                }

            }
        }
        return count;
    }
}
