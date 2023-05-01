package DSA.leetCodeDaily;

import java.util.*;

public class NumberOfNodesInTheSubtreeWIthSameLabel {


    public static void main(String[] args) {
        int n = 7;
        int edges[][] = {{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}};
        String labels = "abaedcd";
        int ans[]=new NumberOfNodesInTheSubtreeWIthSameLabel().countSubTrees(n, edges, labels);
        for(int i=0;i<ans.length;i++)
            System.out.println( ans[i]);

    }

    public int[] countSubTrees(int n, int[][] edges, String labels) {
        Map<Integer, List<Integer>> nodeToChildren = new HashMap<>();
        for (int edge[] : edges) {
            nodeToChildren.putIfAbsent(edge[0], new LinkedList<>());
            nodeToChildren.putIfAbsent(edge[1], new LinkedList<>());
            nodeToChildren.get(edge[0]).add(edge[1]);
            nodeToChildren.get(edge[1]).add(edge[0]);
        }
        int[] answer = new int[n];
        getCharCount(0,nodeToChildren,new HashSet<>(),labels,answer);
        return answer;
    }

    private Map<Character, Integer> getCharCount(int i, Map<Integer, List<Integer>> nodeToChildren, Set<Integer> visited, String labels, int[] answer) {
        visited.add(i);
        Map<Character, Integer> charCount = new HashMap<>();
        for(int child:nodeToChildren.getOrDefault(i,new LinkedList<>())){

            if(visited.contains(child))
                continue;
            Map<Character, Integer> childCharCount=getCharCount(child,nodeToChildren,visited,labels,answer);
            for(Map.Entry<Character,Integer> childCharCountEntry:childCharCount.entrySet()){
                char character=childCharCountEntry.getKey();
                int occurences=childCharCountEntry.getValue();
                charCount.put(character,charCount.getOrDefault(character,0)+occurences);

            }
        }

        char currNodeLabel=labels.charAt(i);
        charCount.put(currNodeLabel,charCount.getOrDefault(currNodeLabel,0)+1);

        answer[i]=charCount.get(currNodeLabel);

        return charCount;
    }

}
