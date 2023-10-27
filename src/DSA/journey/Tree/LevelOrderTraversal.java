package DSA.journey.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;



class Level{

    TreeNode node;
    int level;
    Level(TreeNode node,int level){
        this.node=node;
        this.level=level;
    }

}


public class LevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);

        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);
        root.right.left=new TreeNode(6);
        root.right.right=new TreeNode(7);
        root.left.left.left=new TreeNode(8);
        System.out.println(new LevelOrderTraversal().solve(root));
    }
    public ArrayList<ArrayList<Integer>> solve1(TreeNode root) {
        if(root==null)return new ArrayList<>();
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        Queue<Level> queue=new LinkedList<>();
        queue.add(new Level(root,0));
        while(!queue.isEmpty()){

            Level pop=queue.remove();
            int lev=pop.level;
            if(ans.size()-1<lev){
                ArrayList<Integer> levelNodes=new ArrayList<>();
                ans.add(levelNodes);
            }
            ans.get(lev).add(pop.node.val);
            if(pop.node.left!=null)
            queue.add(new Level(pop.node.left,lev+1));
            if(pop.node.right!=null)
            queue.add(new Level(pop.node.right,lev+1));


        }
        return ans;
    }
    //better
    public ArrayList<ArrayList<Integer>> solve(TreeNode root) {
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        if(root==null) return new ArrayList<>();
        q.add(root);
        q.add(null);
        ArrayList<Integer> temp=new ArrayList<>();
        // temp.add(root.data);
        while (q.size()>1){
            TreeNode front=q.peek();
            q.remove();
            if(front==null){
                ans.add(temp);
                temp=new ArrayList<>();
                q.add(null);

            }
            else{
                temp.add(front.val);

                if(front.left!=null){
                    q.add(front.left);
                }
                if(front.right!=null){
                    q.add(front.right);
                }
            }

        }
        ans.add(temp);

        return ans;
    }
}
