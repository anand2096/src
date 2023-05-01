package DSA.Graph;

import java.util.*;

public class NumberOfProvinces {
    static int province=0;
    public static void main(String[] args) {
        int isConnected[][]= {{1,0,0},{0,1,0},{0,0,1}};

        System.out.println(new NumberOfProvinces().findCircleNum(isConnected));
    }

    public int findCircleNum(int[][] isConnected) {
        province=0;
        Map<Integer,List<Integer>>nodeToChildren=new HashMap<>();
         boolean []visited=new boolean[isConnected.length+1];
        for(int i=0;i<isConnected.length;i++){
            int arr[]=isConnected[i];
            for(int j=0;j<arr.length;j++){
                if(nodeToChildren.containsKey((i+1))) {
                    if(arr[j]==1) {
                        List<Integer> list = nodeToChildren.get((i + 1));
                        list.add((j+1));
                        nodeToChildren.put((i + 1),list);
                    }
                }
                else{
                    if(arr[j]==1){
                        List<Integer> list =new LinkedList<>();
                        list.add(j+1);
                                nodeToChildren.put((i+1),list);
                    }
                }
            }
        }

        for(int i=1;i<isConnected.length+1;i++){
            if(!visited[i]){
                province++;
                findCircleNum(i,nodeToChildren,visited);
            }
        }

        return province;
    }
    public void findCircleNum(int node,Map<Integer,List<Integer>> nodeToChildren,boolean visited[] ){
         visited[node]=true;
        for(int child:nodeToChildren.getOrDefault(node,new LinkedList<>())){
            if(!visited[child]) {
                findCircleNum(child, nodeToChildren, visited);
            }
        }

    }

}
