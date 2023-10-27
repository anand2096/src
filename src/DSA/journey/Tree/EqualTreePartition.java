package DSA.journey.Tree;

public class EqualTreePartition {
    boolean flag;
    public int solve(TreeNode root) {
        if(root==null)return 0;
        flag=false;
        if(check(root,root.val))return 1;
        return 0;
    }

    public boolean check(TreeNode root, int currSum){
        if(root==null)return false;
        int lsum=sum(root.left);
        int rsum=sum(root.right);
        if(lsum+currSum==rsum|| rsum+currSum==lsum){
            return true;
        }
        if(root.left!=null){
            if(check(root.left,currSum+root.left.val))return true;}
        if(root.right!=null){
            if(check(root.right,currSum+root.right.val)) return true;
        }

        return false;
    }

    public int sum(TreeNode root){
        if(root==null)return 0;
        int l=sum(root.left);
        int r=sum(root.right);

        return root.val+l+r;

    }
    public static void main(String[] args) {
        TreeNode root=new TreeNode(375);
        root.left=new TreeNode(112);

        root.right=new TreeNode(267);
       // root.left.left=new TreeNode(4);
      //  root.left.right=new TreeNode(6);
        root.right.left=new TreeNode(454);
        root.right.right=new TreeNode(321);
        root.right.right.left=new TreeNode(719);
     //   root.right.right.right=new TreeNode(321);
      //  root.left.left.left=new TreeNode(8);
        System.out.println( new EqualTreePartition().solve(root));
    }



}
