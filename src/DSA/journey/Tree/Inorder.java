package DSA.journey.Tree;

import java.util.ArrayList;


public class Inorder {

    public ArrayList<Integer> inorderTraversal(TreeNode head) {

        ArrayList<Integer> ans=new ArrayList<>();
        inOrder(head,ans);
        return ans;
    }

    public void inOrder(TreeNode root,ArrayList<Integer> list){

        if(root==null)return;

        inOrder(root.left,list);
        list.add(root.val);
        inOrder(root.right,list);
    }
}
