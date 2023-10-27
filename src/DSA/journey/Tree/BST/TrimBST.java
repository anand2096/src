package DSA.journey.Tree.BST;
import DSA.journey.Tree.Inorder;
import DSA.journey.Tree.TreeNode;
public class TrimBST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
       // root.left = new TreeNode(0);
        root.right = new TreeNode(2);
//        root.left.right = new TreeNode(2);
//        root.left.right = new TreeNode(1);

        TreeNode ans=new TrimBST().trimBST(root,2,4);
        System.out.println(new Inorder().inorderTraversal(ans));

    }

    public TreeNode trimBST(TreeNode root, int low, int high) {
        TreeNode main=root;
        inorder(root,low,high,main);
        return root;

    }
    public void inorder(TreeNode root,int low,int high,TreeNode main){
        if(root==null)return;

        if(root.val<low || root.val> high){
            root=delete(main,root.val);
        }
        if(root!=null )
            inorder(root.left,low,high,main);
        if(root!=null)
            inorder(root.right,low,high,main);
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
