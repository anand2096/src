package DSA.journey.Tree;

public class DeepestLeavesSum {
    int ans=0;
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);

        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);
        root.left.left.left=new TreeNode(7);
        // root.right.left=new TreeNode(454);
          root.right.right=new TreeNode(6);
        root.right.right.right=new TreeNode(8);
        //  root.left.left.left=new TreeNode(8);
        System.out.println(new DeepestLeavesSum().deepestLeavesSum(root));

    }
    public int height(TreeNode root){
        if(root==null){
            return 0;
        }

        int l=height(root.left);
        int r=height(root.right);

        return 1+Math.max(l,r);

    }

    public int deepestLeavesSum(TreeNode root) {

        TreeNode temp=root;
        int maxDepth=height(temp)-1;
        calculate(root,maxDepth,0);
        return ans;

    }
    public void calculate(TreeNode root,int maxH,int currH){
        if(root==null)return;

        if(currH==maxH){

            ans=ans+root.val;
        }
        calculate(root.left,maxH,currH+1);
        calculate(root.right,maxH,currH+1);
    }
}
