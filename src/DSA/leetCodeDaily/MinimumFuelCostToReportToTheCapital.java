package DSA.leetCodeDaily;

import java.util.*;

public class MinimumFuelCostToReportToTheCapital {
    private long ans = 0;

    public static void main(String[] args) {

        int[][] roads = {{3, 1}, {3, 2}, {1, 0}, {0, 4}, {0, 5}, {4, 6}};
        int seats = 2;
        System.out.println(new MinimumFuelCostToReportToTheCapital().minimumFuelCost(roads, seats));
    }

    public long minimumFuelCost(int[][] roads, int seats) {
        List<Integer>[] grpah = new List[roads.length + 1];
        for (int i = 0; i < grpah.length; i++) {
            grpah[i] = new ArrayList<>();
        }

        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            grpah[u].add(v);
            grpah[v].add(u);
        }
        dfs(grpah, 0, -1, seats);
        return ans;
        //  long total = 0;
//        List<List<Integer>> adjList = new ArrayList<>();
//        Map<Integer, List<Integer>> nodeToChild = new HashMap<>();

//        for(int i=0;i<roads.length;i++){
//            adjList.add(new ArrayList<>());
//        }

//        for (int i = 0; i < roads.length; i++) {
//            int temp[] = roads[i];
//
//            if (nodeToChild.containsKey(temp[0])) {
//                List<Integer> t = nodeToChild.get(temp[0]);
//                t.add(temp[1]);
//                nodeToChild.put(temp[0], t);
//            } else {
//                List<Integer> t = new ArrayList<>();
//                t.add(temp[1]);
//                nodeToChild.put(temp[0], t);
//            }
//
//            if (nodeToChild.containsKey(temp[1])) {
//                List<Integer> t = nodeToChild.get(temp[1]);
//                t.add(temp[0]);
//                nodeToChild.put(temp[1], t);
//            } else {
//                List<Integer> t = new ArrayList<>();
//                t.add(temp[0]);
//                nodeToChild.put(temp[1], t);
//            }
//
//        }


    }

    private int dfs(List<Integer>[] grpah, int u, int prev, int seats) {

        int people = 1;
        for (int v : grpah[u]) {
            if (v == prev)
                continue;
            people = people + dfs(grpah, v, u, seats);
        }
        if (u > 0) {
            ans += (people + seats - 1) / seats;

        }
        return people;
    }

//    private int dfs(int node, int count, long total, int seats, Map<Integer, List<Integer>> nodeToChild, Set<Integer> vis) {
//        vis.add(node);
//        int cnt=1;
//            for (int child : nodeToChild.get(node)) {
//                if (!vis.contains(child)) {
//
//                   cnt=cnt+ dfs(child,count+1,total,seats,nodeToChild,vis);
//
//                }
//            }
//
//            if (node != 0) {
//                if (count == seats) {
//                    total = total + count;
//                } else if (seats < count) {
//                    total = total + count + (count - seats);
//                }
//                return
//            }
//
//
//
//    }


}
