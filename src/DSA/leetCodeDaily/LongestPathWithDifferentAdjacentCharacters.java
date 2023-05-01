package DSA.leetCodeDaily;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


class  NodeInfo {

    int max;
    int maxThroughRoot;

    NodeInfo(int max, int maxThroughRoot) {
        this.max = max;
        this.maxThroughRoot = maxThroughRoot;
    }
}

//https://leetcode.com/problems/longest-path-with-different-adjacent-characters/
public class LongestPathWithDifferentAdjacentCharacters {
    static int max;

    public static void main(String[] args) {
        int parent[] = {-1, 0, 0, 1, 1, 2};
        String s = "abacbe";

        System.out.println(new LongestPathWithDifferentAdjacentCharacters().longestPath(parent, s));

    }

    public int longestPath(int[] parent, String s) {

        Map<Integer, List<Integer>> nodeToChildren = new HashMap<>();
        for (int child = 1; child < parent.length; child++) {

            int par = parent[child];
            nodeToChildren.putIfAbsent(par, new LinkedList<>());
            nodeToChildren.get(par).add(child);
        }
        return longestPath(0,nodeToChildren,s).max;
    }

    public NodeInfo longestPath(int i, Map<Integer, List<Integer>> nodeToChildren, String s) {
        int maxChild = 0;
        int secondMaxChild = 0;
        int overAllMax = 1;
        for (int child : nodeToChildren.getOrDefault(i, new LinkedList<>())) {
            NodeInfo childNodeInfo = longestPath(child, nodeToChildren, s);
            overAllMax=Math.max(overAllMax,childNodeInfo.max);
            if (s.charAt(i) != s.charAt(child)) {
                if (childNodeInfo.maxThroughRoot > maxChild) {
                    secondMaxChild = maxChild;
                    maxChild = childNodeInfo.maxThroughRoot;
                } else if (childNodeInfo.maxThroughRoot > secondMaxChild) {
                    secondMaxChild = childNodeInfo.maxThroughRoot;
                }
            }

        }
        overAllMax = Math.max(overAllMax, 1 + maxChild + secondMaxChild);
        int maxThroughRoot = 1 + maxChild;
        return new NodeInfo(overAllMax, maxThroughRoot);
    }
}
