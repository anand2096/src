package DSA.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    Node root;

    public List<List<Integer>> levelOrder1() {

        List<List<Integer>> ans=new ArrayList<>();
        Queue<Node> q=new LinkedList<Node>();
        if(root==null) return new ArrayList<>();
        q.add(root);
        List<Integer>t=new ArrayList<>();
        t.add(root.data);
        ans.add(t);
        while(q.size()!=0){
            List<Integer> temp=new ArrayList<>();

            Node popedElement=q.poll();
            if(popedElement.right!=null)
            { q.add(popedElement.right);
                temp.add(popedElement.right.data);}
            if(popedElement.left!=null){
                q.add(popedElement.left);
                temp.add(popedElement.left.data);
            }


            if(temp.size()>0)
            ans.add(temp);


        }
        return ans;
    }


    public List<List<Integer>> levelOrder() {
        List<List<Integer>> ans=new ArrayList<>();
        Queue<Node> q=new LinkedList<Node>();
        if(root==null) return new ArrayList<>();
        q.add(root);
        q.add(null);
        List<Integer> temp=new ArrayList<>();
       // temp.add(root.data);
        while (q.size()>1){
            Node front=q.peek();
            q.remove();
            if(front==null){
                ans.add(temp);
                temp=new ArrayList<>();
                q.add(null);

            }
            else{
                temp.add(front.data);

                if(front.left!=null){
                    q.add(front.left);
                }
                if(front.right!=null){
                    q.add(front.right);
                }
            }

        }
        ans.add(temp);
    return ans;

    }
    public static void main(String[] args) {
        LevelOrderTraversal tree_level = new LevelOrderTraversal();
        tree_level.root = new Node(1);
        tree_level.root.left = new Node(2);
        tree_level.root.right = new Node(3);
        tree_level.root.left.left = new Node(4);
        tree_level.root.left.right = new Node(5);
        tree_level.root.right.left = new Node(6);
        tree_level.root.right.right = new Node(7);

        System.out.println(tree_level.levelOrder());
    }
}
