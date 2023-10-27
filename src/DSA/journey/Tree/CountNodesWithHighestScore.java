package DSA.journey.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountNodesWithHighestScore {
    int count;

    public static void main(String[] args) {
        int arr[] = {-1, 2, 0, 2, 0};
        System.out.println(new CountNodesWithHighestScore().countHighestScoreNodes(arr));
    }

    public int countHighestScoreNodes(int[] parents) {
        int max = Integer.MIN_VALUE;
        Map<Integer, Integer> freq = new HashMap<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        int n = parents.length;
        for (int i = 0; i < n; i++) {
            List<Integer> temp = new ArrayList<>();
            map.put(i, temp);
        }
        for (int i = 1; i < n; i++) {
            int val = parents[i];
            map.get(i).add(val);
            map.get(val).add(i);
        }

        for (int i = 0; i < n; i++) {
            int ans = 1;
            List<Integer> list = map.get(i);
            for (int j = 0; j < list.size(); j++) {
                count = 1;
                dfs(list.get(j), map, i);
                ans = ans * count;
                count = 1;
            }
            max = Math.max(max, ans);
            freq.put(i, ans);
        }
        int fans = 0;
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() == max) {
                fans++;
            }
        }
        return fans;
    }

    public void dfs(int index, Map<Integer, List<Integer>> map, int parent) {

        for (int child : map.get(index)) {
            if (child != parent) {
                count++;
                dfs(child, map, index);
            }
        }


    }
}
