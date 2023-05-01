package DSA.leetCodeDaily;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Node1
{
    int val;
    Node1 left, right;

    Node1(int item)
    {
        val = item;
        left = right = null;
    }
}
public class MinimumDistanceBetweenBSTNodes {
//4,2,6,1,3
    public static void main(String[] args) {
        Node1 root = new Node1(1);
        root.left = new Node1(0);
        root.right = new Node1(48);
        root.right.left = new Node1(12);
        root.right.right = new Node1(49);
        System.out.println(new MinimumDistanceBetweenBSTNodes().minDiffInBST(root));
    }


    public int minDiffInBST(Node1 root) {
        List<Integer> list=new ArrayList<>();
        getPath(root,list);
        //Collections.sort(list);
        int min=Integer.MAX_VALUE;
        for(int i=1;i<list.size();i++){
            int diff=list.get(i)-list.get(i-1);
            if(diff<min)
                min=diff;
        }
        return min;

    }
    public void getPath(Node1 root,List<Integer>list){

        if(root==null)return;
        getPath(root.left,list);
        list.add(root.val);
        getPath(root.right,list);
    }
}
