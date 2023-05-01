package DSA.Tree;

public class SameTree {

    static TreeNode root1;
    static TreeNode root2;
    public static void main(String[] args) {

        SameTree tree = new SameTree();

        tree.root1 = new TreeNode(1);
        tree.root1.left = new TreeNode(2);
        tree.root1.right = new TreeNode(3);
      tree.root1.left.left = new TreeNode(4);
//        tree.root1.left.right = new TreeNode(5);

        tree.root2 = new TreeNode(1);
        tree.root2.left = new TreeNode(2);
        tree.root2.right = new TreeNode(3);
        tree.root2.left.left = new TreeNode(4);
//        tree.root2.left.right = new TreeNode(5);


        System.out.println(new SameTree().isSameTree2(root1,root2));
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {

        if(p==null || q==null){
            return p==q;
        }
            return (p.val==q.val && isSameTree(p.left,q.left) &&isSameTree(p.right,q.right));

    }
    public boolean isSameTree2(TreeNode p, TreeNode q) {

        if(p==null || q==null){
            return p==q;

        }
        if(p!=null &q!=null){
            if(p.val!=q.val) return false;
            return isSameTree(p.left,q.left) &&isSameTree(p.right,q.right);
        }
        else{
            return false;
        }
    }
}
