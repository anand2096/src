//package DSA.Recursion;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class MColoringProblem {
//    public static void main(String[] args) {
//       int N = 4;
//      int  M = 3;
//       int E = 5;
//        int Edges[][] = {{0,1},{1,2},{2,3},{3,0},{0,2}};
//        System.out.println(new MColoringProblem().graphColoring(Edges,M,N));
//    }
//    public boolean graphColoring(boolean graph[][], int m, int n) {
//        // Your code here
//        boolean ans =true;
//        List<List<Integer>> adjList=new ArrayList<>();
//        for(int i=0;i<n;i++){
//            adjList.add(new ArrayList<>());
//        }
//        for(int i=0;i<graph.length;i++){
//            for(int j=0;j<graph[0].length;j++){
//                if(graph[i][j]){
//                    adjList.get(i).add(j);
//                }
//            }
//        }
//        int color[]=new int[n];
//
//        if(mColor(0,adjList,m,color))
//            return true;
//
//
//        return  false;
//    }
//
//    private boolean mColor(int index, List<List<Integer>> adjList, int m,int [] color) {
//
//        for(int i=1;i<=m;i++){
//            if(isPossible(index,adjList,color,i)){
//                color[index]=i;
//                if(mColor(index+1,adjList,m,color))
//                    return true;
//                color[index]=0;
//            }
//        }
//        return  false;
//    }
//
//    private boolean isPossible(int index, List<List<Integer>> adjList,int []color,int col) {
//        for(int it:adjList.get(index)){
//            if(color[it]==col)return false;
//        }
//        return true;
//    }
//
//
//}
