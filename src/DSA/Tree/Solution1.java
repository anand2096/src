package DSA.Tree;

import java.util.*;

class Solution1
{int l=0;
    Map<Integer,Integer> m=new HashMap<>();
    boolean check(Node root)
    {
        // Your code here
        if(root==null)return false;


        checkLevel(root,0,m);
        if(m.size()>1)return false;
        else
            return true;

    }



    void checkLevel(Node root,int n,Map m){
        if(root.left==null &&root.right==null){
            m.put(n,root.data);

        }
        checkLevel(root.left,n+1,m);
        checkLevel(root.right,n+1,m);


    }

    public static void main(String[] args) {

    }



}
