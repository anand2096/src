package DSA.leetCodeDaily;


import java.util.ArrayList;

class Node2
{
    int val;
    Node2 left, right;

    Node2(int item)
    {
        val = item;
        left = right = null;
    }
}
public class InvertTree {

    public static void main(String[] args) {
        //4,2,7,1,3,6,9
        Node2 root = new Node2(4);
        root.left = new Node2(2);
        root.right = new Node2(7);
        root.left.left = new Node2(1);
        root.left.right = new Node2(3);
        root.right.left = new Node2(6);
        root.right.right = new Node2(9);
        ArrayList<Integer>list =new ArrayList<>();
        preOrder(root,list);
        System.out.println(list);
        System.out.println("///////////");
        new InvertTree().invertTree(root);
        ArrayList<Integer>list1 =new ArrayList<>();
        preOrder(root,list1);
        System.out.println(list1);
    }
    public static void preOrder(Node2 root,ArrayList<Integer>list){
        if(root!=null){
            list.add(root.val);
            preOrder(root.left,list);
            preOrder(root.right,list);
        }

    }
    public Node2 invertTree(Node2 root) {
        invert(root);
        return root;
    }

    public void invert(Node2 root){
        if(root!=null){
            Node2 temp=root.left;
            root.left=root.right;
            root.right=temp;
            invert(root.left);
            invert(root.right);
        }
    }

}
