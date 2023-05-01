package DSA.journey.combinatorics;

public class RectangleArea {

    public static void main(String[] args) {
        int a=0;int b=0;
        int c=4;int d=4;
        int e=2;int f=2;
        int g=3;int h=6;

        System.out.println(new RectangleArea().solve(a,b,c,d,e,f,g,h));
    }

    public int solve(int A, int B, int C, int D, int E, int F, int G, int H) {
        int areaRect1=(C-A)*(D-B);
        int areaRect2=(G-E)*(H-F);


        int left = Math.max(A, E);
        int right = Math.min(G, C);
        int bottom = Math.max(F, B);
        int top = Math.min(D, H);

        //If overlap
        int overlap = 0;
        if(right > left && top > bottom)
            overlap = (right - left) * (top - bottom);

        return  overlap;

    }
}
