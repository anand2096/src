package DSA.journey.Tree;

import java.util.*;

class Node{

    TreeNode treeNode;
    int level;
    public Node(TreeNode treeNode,int level){
        this.treeNode=treeNode;
        this.level=level;
    }


}
public class VerticalLevelOrderTraversal {


    //better


    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode root) {
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        Queue<Node> queue=new LinkedList<>();
        Map<Integer,ArrayList<Integer>> map=new HashMap<>();
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        queue.add(new Node(root,0));
        while(queue.size()>0){
            Node front=queue.peek();
            queue.remove();
            TreeNode node=front.treeNode;
            int level=front.level;
            min=Math.min(min,level);
            max=Math.max(max,level);
            if(!map.containsKey(level)){
                ArrayList<Integer> temp=new ArrayList<>();
                map.put(level,temp);
            }
            map.get(level).add(node.val);

            if(node.left!=null){
                queue.add(new Node(node.left,level-1));
            }
            if(node.right!=null){
                queue.add(new Node(node.right,level+1));
            }
        }



        for(int i=min;i<=max;i++){
            ans.add(map.get(i));
        }
        return ans;

    }
}


