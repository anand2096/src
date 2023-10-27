package DSA.journey.Tree.BST;

import DSA.journey.Tree.TreeNode;

public class DeleteNodeInBST {
    public TreeNode solve(TreeNode root, int k) {

        return delete(root,k);

    }
    public int min(TreeNode root){
        TreeNode node =root;
        while(node.right!=null){

            node=node.right;

        }
        return node.val;
    }

    public TreeNode delete(TreeNode root,int k){
        if(root==null)return null;
        if(root.val==k){
            if(root.left==null && root.right ==null){
                return null;
            }
            else if(root.left==null || root.right==null){
                if(root.left!=null){
                    return root.left;
                }
                else{
                    return root.right;
                }
            }
            else{
                int x=min(root.left);
                root.val=x;
                root.left=delete(root.left,x);
                return root;
            }

        }
        else if(root.val>k){
            root.left= delete(root.left,k);
        }
        else{
            root.right= delete(root.right,k);
        }
        return root;
    }


}
