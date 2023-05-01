package DSA.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    Node root;

    public List<List<Integer>> levelOrder() {

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
            if(popedElement.left!=null){
                q.add(popedElement.left);
                temp.add(popedElement.left.data);
            }

            if(popedElement.right!=null)
            { q.add(popedElement.right);
                temp.add(popedElement.right.data);}
            if(temp.size()>0)
            ans.add(temp);


        }
        return ans;
    }
    public static void main(String[] args) {
        LevelOrderTraversal tree_level = new LevelOrderTraversal();
        tree_level.root = new Node(3);
        tree_level.root.left = new Node(9);
        tree_level.root.right = new Node(20);
        tree_level.root.right.left = new Node(15);
        tree_level.root.right.right = new Node(7);
        System.out.println(tree_level.levelOrder());
    }
}
