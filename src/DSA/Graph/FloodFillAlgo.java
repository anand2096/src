//package DSA.Graph;
//
//
//import java.util.LinkedList;
//import java.util.Queue;
//
//public class FloodFillAlgo {
//
//    public static void main(String[] args) {
//
//        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
//        int[][] visited = new int[image.length][image[0].length];
//        int sr = 1, sc = 1, newColor = 2;
//        for (int i = 0; i < image.length; i++) {
//            for (int j = 0; j < image[0].length; j++) {
//
//                System.out.print(image[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        int[][] response = new FloodFillAlgo().floodFill(image, sr, sc, newColor);
//        for (int i = 0; i < response.length; i++) {
//            for (int j = 0; j < response[0].length; j++) {
//
//                System.out.print(response[i][j] + " ");
//            }
//            System.out.println();
//        }
//
//    }
//
//    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
//        // Code here
//        int n = image.length;
//        int m = image[0].length;
//
//        int startColor = image[sr][sc];
//        int[][] op = bfs(image, sr, sc, newColor, startColor);
//
//        return op;
//    }
//
//    private int[][] bfs(int[][] image, int sr, int sc, int newColor, int startColor) {
//        int n = image.length;
//        int m = image[0].length;
//        int output[][] = new int[n][m];
//        for (int i = 0; i < image.length; i++) {
//            for (int j = 0; j < image[0].length; j++) {
//                output[i][j] = image[i][j];
//
//            }
//        }
//
//        Queue<Pair> queue = new LinkedList<>();
//        queue.add(new Pair(sr, sc));
//        while (!queue.isEmpty()) {
//            int row = queue.peek().first;
//            int col = queue.peek().second;
//            if (image[row][col] != newColor) {
//                output[row][col] = newColor;
//            }
//            queue.remove();
//            int[] delRow = {-1, 0, +1, 0};
//            int[] delCol = {+0, +1, +0, -1};
//            for (int i = 0; i < 4; i++) {
//                int nrow = row + delRow[i];
//                int ncol = col + delCol[i];
//                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && image[nrow][ncol] == startColor && output[nrow][ncol] != newColor) {
//                    output[nrow][ncol] = newColor;
//                    queue.add(new Pair(nrow, ncol));
//                }
//            }
//        }
//
//
//        return output;
//
//    }
//}
