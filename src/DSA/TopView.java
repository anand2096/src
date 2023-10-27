package src.src.DSA;


import java.util.*;

class TreeNode{
    TreeNode left;
    TreeNode right;
    public TreeNode(TreeNode left,TreeNode right){

        this.left=left;
        this.right=right;
    }



}

class Node{

    TreeNode node;
    int level;
    public Node(int level,TreeNode node){
        this.node=node;
        this.level=level;
    }
}
public class TopView{
    public void topViewTree(TreeNode root){

        //	queue to store the nodes
        Queue<Node> queue=new LinkedList<>();
        // map to store level wise nodes
        Map<Integer,TreeNode> levelMap=new TreeMap<>();

        Node nodeRoot=new Node(0,root);
        queue.add(nodeRoot);
        levelMap.put(0,nodeRoot.node);

        while(!queue.isEmpty()){

            Node top=queue.peek();
            queue.remove();
            TreeNode node=top.node;
            int level=top.level;
            if(node.left!=null){

                queue.add(new Node(level-1,node.left));
                if(!levelMap.containsKey(level-1)){
                    levelMap.put(level-1,node.left);
                }
            }
            if(node.right!=null){

                queue.add(new Node(level+1,node.right));
                if(!levelMap.containsKey(level+1)){
                    levelMap.put(level+1,node.right);
                }
            }

        }
        //printing the top view
        printTopView(levelMap);


    }

    public void printTopView(Map<Integer,TreeNode> levelMap){

        for(Map.Entry<Integer,TreeNode>map:levelMap.entrySet()){

            System.out.println(map.getValue());
        }

    }
}

