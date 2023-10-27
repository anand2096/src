package DSA.journey.Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeastCommonAncestorInBinaryTree {
    public static void main(String[] args) {


        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);

        root.right=new TreeNode(3);
         root.left.left=new TreeNode(4);
          root.left.right=new TreeNode(5);
       // root.right.left=new TreeNode(454);
      //  root.right.right=new TreeNode(321);
//        //   root.right.right.right=new TreeNode(321);
        //  root.left.left.left=new TreeNode(8);

        System.out.println(new LeastCommonAncestorInBinaryTree().lca(root,4,5));
    }
    public int lca(TreeNode root, int b, int c) {

        List<Integer> list1=new ArrayList<>();
        List<Integer> list2=new ArrayList<>();
        boolean foundB=findPath(root,b,list1);
        boolean foundC=findPath(root,c,list2);
        if(!foundB ||!foundC)return -1;

        list1.retainAll(list2);
        return list1.get(0);
        //return common;
    }


    public boolean findPath(TreeNode root,int k,List<Integer>list){

        if(root==null)return false;

        if(root.val==k){
            list.add(root.val);
            return true;
        }

        boolean res=findPath(root.left,k,list) || findPath(root.right,k,list);
        if(res){
            list.add(root.val);
        }
        return res;

    }
}
