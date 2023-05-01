package DSA.leetCodeDaily;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class SnakeAndLadder {
    public static void main(String[] args) {

        int board[][] = {{-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}
                , {-1, -1, -1, -1, -1, -1}, {-1, 35, -1, -1, 13, -1}
                , {-1, -1, -1, -1, -1, -1}, {-1, 15, -1, -1, -1, -1}};
        System.out.println(new SnakeAndLadder().snakesAndLadders(board));
    }


    public int snakesAndLadders(int[][] board) {
        final int target = board.length * board.length;
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> currLevel = new LinkedList<>();
        currLevel.add(1);
        visited.add(1);
        int steps = 0;
        while (!currLevel.isEmpty()) {
            Queue<Integer> nextLevel = new LinkedList<>();
            while (!currLevel.isEmpty()) {
                int node = currLevel.poll();
                for (int i = node + 1; i <= Math.min(node + 6, target); i++) {
                    int next = getAt(board, i);
                    if (next == -1) {
                        next = i;
                    }
                    if (visited.contains(next)) continue;
                    if (next == target) {
                        return steps + 1;
                    }
                    nextLevel.add(next);
                    visited.add(next);
                }

            }
            steps++;
            currLevel = nextLevel;
        }
        return -1;


    }

    private int getAt(int[][] board, int curr) {
        curr=curr-1;
        int rowOffSet=curr/board.length;
        int row=(board.length-1)-rowOffSet;
        int col=rowOffSet%2==0? curr%board.length:(board.length-1)-(curr%board.length);
        return board[row][col];
    }

    //    public int snakesAndLadders2(int[][] board) {
//        int steps = 0;
//        int n = board.length;
//        int m = board[0].length;
//        int finalSquare = n * n;
//
//        boolean switchSide = false;
//        int j = 0;
//        for (int k = n - 1; k >=0; ) {
//            int current=j;
//            if (k == n - 1&& !switchSide) j = 0;
//           else  if (k == n - 1&& switchSide) j = m - 1;
//            int max = 0;
//            int maxIndex = -1;
//            if (!switchSide) {
//                while (j < n) {
//
//                    if (max < board[k][j]) {
//                        max = board[k][j];
//                        maxIndex = j;
//                    }
//                    j++;
//                }
//            }
//            else {
//                while (j >= 0) {
//
//                    if (max < board[k][j]) {
//                        max = board[k][j];
//                        maxIndex = j;
//                    }
//                    j--;
//                }
//            }
//
//            if (max != 0) {
//                steps = steps + (maxIndex-current);
//                current=maxIndex;
//
//                if(max%n!=0){
//                    k=(n-max/n);
//                }
//                else{
//                    k=(n-((max/n)-1));
//                }
//               // int nextRow = (int) Math.floor(max / n); // 15/6 = 3
//        k--;
//                if(k%2==0){
//                    switchSide = !switchSide;
//                }
//              //  int nextCol =max- ((n-k) * n) ;
//                int nextCol = ((n-k) * n) -max;
//                if(!switchSide)
//                    nextCol=n-nextCol;
//            //    j = nextCol - 1;
//            } else {
//                steps = steps + n-current;
//                current=maxIndex;
//                if (switchSide) {
//                    j = m - 1;
//                } else {
//                    j = 0;
//                }
//                k--;
//                if(k%2==0){
//                    switchSide = !switchSide;
//                }
//            }
//
//
//
//            if(max==n*n)
//                return steps;
//        }
//
//
//return -1;
//    }

}
