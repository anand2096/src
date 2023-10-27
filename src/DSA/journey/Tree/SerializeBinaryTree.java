package DSA.journey.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeBinaryTree {

    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);

        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);
        System.out.println(new SerializeBinaryTree().solve(root));
    }

    public ArrayList<Integer> solve(TreeNode root) {
        ArrayList<Integer> ans=new ArrayList<>();
        if(root==null)
        {
            ans.add(-1);
            return ans;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){

            TreeNode pop=queue.remove();
            if(pop==null){
                ans.add(-1);
            }
            else{
                ans.add(pop.val);
            }
            if(pop!=null){
                queue.add(pop.left);
                queue.add(pop.right);
            }
        }
        return  ans;
    }


}
