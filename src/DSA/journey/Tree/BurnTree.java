package DSA.journey.Tree;
import java.util.*;
class Node1 {
    int data;
    Node1 left;
    Node1 right;

    public Node1(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
public class BurnTree {
    public static int max;

    public static void main(String[] args) {
        Node1 node=new Node1(1);
        node.left=new Node1(2);
        node.right=new Node1(3);
        node.left.left=new Node1(4);
        node.left.right=new Node1(5);
        node.left.right.left=new Node1(7);
        node.left.right.right=new Node1(8);
        node.right.right=new Node1(6);
        node.right.right.right=new Node1(9);
        node.right.right.right.right=new Node1(10);

        System.out.println(BurnTree.minTime(node,8));

    }
    public static int minTime(Node1 root, int target)
    {   max=Integer.MIN_VALUE;
        // Your code goes here
        Map<Integer,Integer> map=new HashMap<>();
        rec(root,0,map);
        inorder(root,root,target,map);
        return max;


    }

    public static void inorder(Node1 root,Node1 Node1,int target,Map<Integer,Integer> map){

        if(Node1==null)return;
        int lca=lca(root,Node1.data,target);
        int val=map.get(Node1.data)-map.get(lca)+map.get(target)-map.get(lca);
        max=Math.max(max,val);
        inorder(root,Node1.left,target,map);
        inorder(root,Node1.right,target,map);

    }
    public static void rec(Node1 root,int dis,Map<Integer,Integer> map){
        if(root==null)return;
            map.put(root.data,dis);


            rec(root.left,dis+1,map);

            rec(root.right,dis+1,map);

    }


    public static int lca(Node1 root, int b, int c) {

        List<Integer> list1=new ArrayList<>();
        List<Integer> list2=new ArrayList<>();
        boolean foundB=findPath(root,b,list1);
        boolean foundC=findPath(root,c,list2);
        if(!foundB ||!foundC)return -1;

        list1.retainAll(list2);
        return list1.get(0);

    }


    public static boolean findPath(Node1 root,int k,List<Integer>list){

        if(root==null)return false;

        if(root.data==k){
            list.add(root.data);
            return true;
        }

        boolean res=findPath(root.left,k,list) || findPath(root.right,k,list);
        if(res){
            list.add(root.data);
        }
        return res;

    }





}
