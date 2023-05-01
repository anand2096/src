package DSA.leetCodeDaily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumTimeToCollectAllAppleeInATree {

    public static void main(String[] args) {
        int n = 7;
        int[][] edges = {{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}};
        List<Boolean> hasApple = Arrays.asList(false, false, true, false, true, true, false);

        System.out.println(new MinimumTimeToCollectAllAppleeInATree().minTime(n, edges, hasApple));

    }

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        int ans = 0;
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < hasApple.size(); i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int temp[] = edges[i];
            adjList.get(temp[0]).add(temp[1]);
            adjList.get(temp[1]).add(temp[0]);
        }

        boolean[] visited = new boolean[hasApple.size()];
        ans = dfs(0, hasApple, adjList, visited);
        return ans;
    }

    public int dfs(int src, List<Boolean> hasApple, List<List<Integer>> adjList, boolean[] visited) {
        visited[src] = true;
        int tempAns = 0;//2//4//6
        for (int child : adjList.get(src)) {

            if (!visited[child]) {
                tempAns += dfs(child, hasApple, adjList, visited);
            }
        }

        if ((src!=0)&& (hasApple.get(src) || tempAns > 0)) {
            tempAns = tempAns + 2;

        }
        return tempAns;


    }


}
