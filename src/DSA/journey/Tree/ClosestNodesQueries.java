package DSA.journey.Tree;

import java.util.ArrayList;
import java.util.List;

public class ClosestNodesQueries {

    public static void main(String[] args) {
        TreeNode root=new TreeNode(6);
        root.left=new TreeNode(2);
        root.right=new TreeNode(13);
        root.left.left=new TreeNode(1);
        root.left.right=new TreeNode(4);
        //  root.left.left.left=new TreeNode(7);
         root.right.left=new TreeNode(9);
        root.right.right=new TreeNode(15);
         root.right.right.left=new TreeNode(14);
        //  root.left.left.left=new TreeNode(8);
        List<Integer> q=new ArrayList<>();
        q.add(2);q.add(5);q.add(16);
        System.out.println( new ClosestNodesQueries().closestNodes(root,q));
    }

    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer>inorderList=new ArrayList<>();
        TreeNode temp=root;
        inorder(temp,inorderList);
        for(int i=0;i<queries.size();i++){
            int val=queries.get(i);
            int idx=search(inorderList,val);
            List<Integer> t=new ArrayList<>();

            if(idx==-1){
                t.add(-1);
                t.add(inorderList.get(0));
            }
            else if(inorderList.get(idx)==val){
                t.add(val);
                t.add(val);
            }
            else if(idx==inorderList.size()-1){
                t.add(inorderList.get(idx));
                t.add(-1);
            }
            else{
                t.add(inorderList.get(idx));
                t.add(inorderList.get(idx+1));
            }
            ans.add(t);
        }
        return ans;

    }
    public int search(List<Integer> list,int k){
        int low=0;
        int high=list.size()-1;
        int ans=-1;
        while(low<=high){
            int mid=(low+high)/2;
            int midVal=list.get(mid);
            if(midVal==k){
                return mid;
            }
            else if(midVal<k){
                ans=mid;
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return ans;
    }

    public void inorder(TreeNode root,List<Integer> list){
        if(root==null)return ;
        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);

    }
}
