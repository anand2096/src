package DSA.journey.Tree;

import java.util.*;

public class TopViewOfTree {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);

        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);
        root.right.left=new TreeNode(6);
        root.right.right=new TreeNode(7);
        root.left.left.left=new TreeNode(8);
        System.out.println(new TopViewOfTree().topView(root));
    }

    //better
    public ArrayList<Integer> topView(TreeNode root) {
        ArrayList<Integer> ans=new ArrayList<>();
        Queue<Node> queue=new LinkedList<>();
        Map<Integer,Integer> map=new HashMap<>();
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
                map.put(level,node.val);
            }
           // map.get(level).add();

            if(node.left!=null){
                queue.add(new Node(node.left,level-1));
            }
            if(node.right!=null){
                queue.add(new Node(node.right,level+1));
            }
        }



        for(int i=0;i>=min;i--){
            ans.add(map.get(i));
        }
        for(int i=1;i<=max;i++){
            ans.add(map.get(i));
        }
        return ans;

    }
    public ArrayList<Integer> topViewBrute(TreeNode root) {
        ArrayList<Integer> ans=new ArrayList<>();
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



        for(int i=0;i>=min;i--){
            ans.add(map.get(i).get(0));
        }
        for(int i=1;i<=max;i++){
            ans.add(map.get(i).get(0));
        }
        return ans;

    }
}
