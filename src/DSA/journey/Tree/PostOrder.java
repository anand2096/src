package DSA.journey.Tree;

import java.util.ArrayList;

public class PostOrder {

    public ArrayList<Integer> postorderTraversal(TreeNode head) {

        ArrayList<Integer> ans=new ArrayList<>();
        postOrder(head,ans);
        return ans;
    }

    public void postOrder(TreeNode root,ArrayList<Integer> list){

        if(root==null)return;

        postOrder(root.left,list);

        postOrder(root.right,list);
        list.add(root.val);
    }
}
