package DSA.leetCodeDaily;


import DSA.Tree.TreeNode;

class TreeNode1 {
    int val;
    TreeNode1 left;
    TreeNode1 right;

    TreeNode1(int val, TreeNode1 left, TreeNode1 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }}
public class MaximumDepthOfBinaryTree {

    public int maxDepth(TreeNode1 root) {

        if(root==null)
            return 0;
        int lD=maxDepth(root.left);
        int rD=maxDepth(root.right);
        return 1+Math.max(lD,rD);


    }
}
