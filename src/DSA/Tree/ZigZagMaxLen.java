package DSA.Tree;

public class ZigZagMaxLen {
    int max=Integer.MIN_VALUE;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.right = new TreeNode(1);

        root.right.left = new TreeNode(1);

        root.right.right = new TreeNode(1);

        root.right.right.left = new TreeNode(1);

        root.right.right.right = new TreeNode(1);

        root.right.right.left.right = new TreeNode(1);

        root.right.right.left.right.right = new TreeNode(1);

        System.out.println(new ZigZagMaxLen().longestZigZag(root));
    }


    public int longestZigZag(TreeNode root) {
        boolean flag1=true;
        boolean flag2=true;
        rec(root,flag1,0);
        return max;
    }

    public void rec(TreeNode root,boolean flag1,int cnt){

            int temp=cnt;
            max=Math.max(max,temp);

        if(flag1){
             if(root.left!=null)
            rec(root.left,!flag1,cnt+1);
             if(root.right!=null)
            rec(root.right,!flag1,cnt+1);
        }
        else{
               if(root.right!=null)
            rec(root.right,!flag1,cnt+1);
             if(root.left!=null)
            rec(root.left,!flag1,cnt+1);

        }


    }
}
