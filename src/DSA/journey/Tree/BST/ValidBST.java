package DSA.journey.Tree.BST;

import DSA.journey.Tree.TreeNode;

import java.util.ArrayList;

public class ValidBST {
    public static void main(String[] args) {

        //3 2 4 1 3 -1 -1 -1 -1 -1 -1
        TreeNode root=new TreeNode(3);
        root.left=new TreeNode(2);

        root.right=new TreeNode(4);
        root.left.left=new TreeNode(1);
        root.left.right=new TreeNode(3);

    }
    public int isValidBST(TreeNode root) {

        // if(isValid(root,Integer.MIN_VALUE,Integer.MAX_VALUE))
        //     return 1;
        // else
        //     return 0;
        return  isValidBSTInorder(root);
    }
    //best solution
    public boolean isValid(TreeNode root,int l,int r){
        if(root==null)return true;
        if(root.val<l || root.val> r)return false;

        boolean left=isValid(root.left,l,root.val-1);
        boolean right=isValid(root.right,root.val+1,r);

        return left && right;
    }
    //using inorder appraoch( inorder of BST will always be sorted)
    public int isValidBSTInorder(TreeNode root){
        ArrayList<Integer> list=new ArrayList<>();
        inOrder(root,list);
        System.out.println(list);
        for(int i=1;i<list.size();i++){
            if(list.get(i)>list.get(i-1))
                return 0;
        }
        return 1;

    }

    public void inOrder(TreeNode root,ArrayList<Integer> list){

        if(root==null)return;

        inOrder(root.left,list);
        list.add(root.val);
        inOrder(root.right,list);
    }
}
