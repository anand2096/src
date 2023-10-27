package DSA.journey.Tree;

import sun.reflect.generics.tree.Tree;

public class BinaryTreeToCircularLinkedList {

    public   TreeNode temp;
    public TreeNode prev;
    public TreeNode  solve (TreeNode root) {
        temp=new TreeNode(0);
        prev=temp;
        inorder(root);
        temp.left=null;
        return temp.right;
    }
    public void inorder(TreeNode root){
        if(root==null)return;
        inorder(root.left);
        prev.right=root;
        root.left=prev;
        prev=root;
        inorder(root.right);
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(5);
        root.left.left=new TreeNode(3);
        root.left.right=new TreeNode(4);
        root.right.right=new TreeNode(6);
        //  root.left.left.left=new TreeNode(7);
//        root.right.left=new TreeNode(9);
//        root.right.right=new TreeNode(15);
//        root.right.right.left=new TreeNode(14);

       new BinaryTreeToCircularLinkedList().flatten(root);
        System.out.println("");
    }



    public void flatten(TreeNode root) {
        TreeNode head=new TreeNode(0);
        TreeNode prev=new TreeNode(0);
        int flag=0;
        inorder(root,head,prev,flag);
        //head.left=null;
        System.out.println("");
    }

    public void inorder(TreeNode root,TreeNode head,TreeNode prev,int flag){
        if(root==null)return;
        inorder(root.left,head,prev,flag);
        if(flag==0){
            flag=1;
            head=root;
            prev=root;
        }
        else{
            prev.right=root;
            root.left=prev;
            prev=root;
        }

        inorder(root.right,head,prev,flag);
    }
}
