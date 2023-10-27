package DSA.journey.Tree;

import java.util.*;
class NodeD{
    int data;
    NodeD left;
    NodeD right;
    NodeD(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
class PairD{
    NodeD NodeD;
    int level;
    public PairD(NodeD NodeD, int level){
        this.NodeD=NodeD;
        this.level=level;
    }
}

public class DiagonalTraversal {
    public static void main(String[] args) {
        NodeD root=new NodeD(1);
        root.left=new NodeD(2);

        root.right=new NodeD(3);
        root.left.left=new NodeD(4);
        root.left.right=new NodeD(5);
        root.right.left=new NodeD(6);
        root.right.right=new NodeD(7);
//        // root.right.left=new NodeD(454);
//        root.right.right=new NodeD(14);
//        root.right.right.left=new NodeD(13);
        //  root.left.left.left=new NodeD(8);
        System.out.println(new DiagonalTraversal().diagonal(root));
    }


    public ArrayList<Integer> diagonal(NodeD root)
    {
        //add your code here.
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        if(root==null)return new ArrayList<Integer>();
        ArrayList<Integer> ans=new ArrayList<>();
        Map<Integer,ArrayList<Integer>> map=new TreeMap<>();
        Queue<PairD> que=new LinkedList<>();
        que.add(new PairD(root,0));
        while(que.size()>0){
            PairD top=que.peek();
            min=Math.min(min,top.level);
            max=Math.max(max,top.level);
            que.remove();
            if(!map.containsKey(top.level)){
                map.put(top.level,new ArrayList<Integer>());
            }
            ArrayList<Integer>temp= map.get(top.level);
            temp.add(top.NodeD.data);
            map.put(top.level,temp);
            if(top.NodeD.left!=null){
                que.add(new PairD(top.NodeD.left,top.level-1));
            }
            if(top.NodeD.right!=null){
                que.add(new PairD(top.NodeD.right,top.level));
            }
        }

        for(int i=max;i>=min;i--){
            if(map.containsKey(i)){
                ArrayList<Integer> temp=map.get(i);
                ans.addAll(temp);
            }

        }

        return ans;


    }
}
