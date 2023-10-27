package DSA.journey.Tree;

import java.util.HashMap;
import java.util.Map;

public class LongestUnivaluePath {
    int ans;
    public static void main(String[] args) {
        TreeNode root=new TreeNode(5);
        root.left=new TreeNode(4);
        root.right=new TreeNode(5);
        root.left.left=new TreeNode(1);
        root.left.right=new TreeNode(1);
      //  root.left.left.left=new TreeNode(7);
        // root.right.left=new TreeNode(454);
        root.right.right=new TreeNode(5);
       // root.right.right.right=new TreeNode(5);
        //  root.left.left.left=new TreeNode(8);

//        TreeNode root=new TreeNode(1);
//        root.left=new TreeNode(4);
//        root.right=new TreeNode(5);
//        root.left.left=new TreeNode(4);
//        root.left.right=new TreeNode(4);
//        //  root.left.left.left=new TreeNode(7);
//        // root.right.left=new TreeNode(454);
//        root.right.right=new TreeNode(5);
//        // root.right.right.right=new TreeNode(5);
//        //  root.left.left.left=new TreeNode
        System.out.println(new LongestUnivaluePath().longestUnivaluePath(root));
    }

    public int longestUnivaluePath(TreeNode root) {
        ans=Integer.MIN_VALUE;

        preorder(root);
        return ans;
    }
    public void preorder(TreeNode root){
        if(root==null)return;
        int left=calculateLeft(root);
        int right=calculateRight(root);
        ans=Math.max(ans,left+right);

        preorder(root.left);
        preorder(root.right);
    }
    public int calculateLeft(TreeNode root){
        if(root==null)return 0;
        TreeNode temp=root;
        int val=root.val;
        int count=0;
        while(temp.left!=null && temp.left.val==val){

            count++;
            temp=temp.left;
        }
        return count;
    }

    public int calculateRight(TreeNode root){
        if(root==null)return 0;
        TreeNode temp=root;
        int val=root.val;
        int count=0;
        while(temp.right!=null && temp.right.val==val ){
            count++;
            temp=temp.right;
        }
        return count;
    }


}
