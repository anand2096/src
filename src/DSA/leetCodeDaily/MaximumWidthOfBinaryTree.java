package DSA.leetCodeDaily;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class Node{
    TreeNode node;
    int pos;//1L,0R
    int level;//1234
    public Node(TreeNode node,int pos,int level){
        this.node=node;
        this.pos=pos;
        this.level=level;
    }
}
public class MaximumWidthOfBinaryTree {

    int max=Integer.MIN_VALUE;
    public static void main(String[] args) {

    }

    public int widthOfBinaryTree(TreeNode root) {
        Map<Integer,Integer> map=new HashMap<>();
        Map<Integer,Integer> levelMax=new HashMap<>();
        Queue<Node> queue=new LinkedList<>();
        if(root.left!=null) {
            queue.add(new Node(root.left, 1, 1));
            map.put(1,1);
            levelMax.put(1,1);
        }
        if(root.right!=null) {
            queue.add(new Node(root.right, 0, 1));
            map.put(1,2);
            levelMax.put(1,2);
        }
        while(!queue.isEmpty()){
            Node top=queue.remove();
            if(map.containsKey(top.level)){
                if(map.get(top.level)==1 && levelMax.get(top.level)!=1){
                    if(top.pos==1){
                       max=Math.max(max,(int)Math.pow(2,top.level)-1);
                    }
                    else{
                        max=Math.max(max,(int)Math.pow(2,top.level));
                    }
                    map.remove(top.level);
                }
                else{
                    map.put(top.level,map.get(top.level)-1);
                }
            }
            if(top.node.left!=null){
                queue.add(new Node(top.node.left,1,top.level+1));
                if(map.containsKey(top.level+1)){
                    map.put(top.level+1,map.get(top.level+1)+1);
                    levelMax.put(top.level+1,levelMax.get(top.level+1)+1);

                }
                else{
                    map.put(top.level+1,1);
                    levelMax.put(top.level+1,1);
                }
            }
            if(top.node.right!=null){
                queue.add(new Node(top.node.right,0,top.level+1));
                if(map.containsKey(top.level+1)){
                    map.put(top.level+1,map.get(top.level+1)+1);
                    levelMax.put(top.level+1,levelMax.get(top.level+1)+1);
                }
                else{
                    map.put(top.level+1,1);
                    levelMax.put(top.level+1,1);
                }
            }
        }


    return max;
    }
}
