package DSA.journey.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LeftViewTree {

    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);

        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);
        root.right.left=new TreeNode(6);
        root.right.right=new TreeNode(7);
        root.left.left.left=new TreeNode(8);
        System.out.println(new LeftViewTree().solve(root));
    }

    public ArrayList<Integer> solve(TreeNode root) {

        ArrayList<Integer> ans=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        if(root==null)return ans;
        queue.add(root);
        queue.add(null);
        ArrayList<Integer> level=new ArrayList<>();
        while (queue.size()>1){
            TreeNode front=queue.peek();
            queue.remove();
            if(front==null){
                ans.add(level.get(0));
                level=new ArrayList<>();
                queue.add(null);
            }
            else{
                level.add(front.val);
                if(front.left!=null){
                    queue.add(front.left);
                }
                if(front.right!=null){
                    queue.add(front.right);
                }
            }

        }

        ans.add(level.get(0));
        return ans;
    }
}
