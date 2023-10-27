package DSA.journey.Tree;


import java.util.*;

public class ZigZagLevelOrderTraversalBT {


    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);

        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);
        root.right.left=new TreeNode(6);
        root.right.right=new TreeNode(7);
        root.left.left.left=new TreeNode(8);
        System.out.println(new ZigZagLevelOrderTraversalBT().zigzagLevelOrder(root));
    }
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Stack<TreeNode> st1=new Stack<>();
        Stack<TreeNode> st2=new Stack<>();
        boolean flag=false;
        st1.add(root);
        while (!st1.isEmpty() || !st2.isEmpty()){
            ArrayList<Integer> temp=new ArrayList<>();
                while(!st1.isEmpty()){
                    TreeNode node=st1.pop();
                    temp.add(node.val);
                    if(flag){
                        if(node.right!=null){
                            st2.add(node.right);
                        }
                        if(node.left!=null){
                            st2.add(node.left);
                        }

                    }
                    else{
                        if(node.left!=null){
                            st2.add(node.left);
                        }
                        if(node.right!=null){
                            st2.add(node.right);
                        }

                    }
                }
                ans.add(temp);
                flag=!flag;
                st1=st2;
                st2=new Stack<TreeNode>();

        }
        return ans;

    }

    public ArrayList<ArrayList<Integer>> zigzagLevelOrderBrute(TreeNode root) {

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        queue.add(new Node(root, 1));
        queue.add(null);
        boolean flag = false;
        while (queue.size() > 1) {
            Node front = queue.peek();
            queue.remove();
            if (front == null) {
                if (flag) {
                    Collections.reverse(temp);
                    ans.add(temp);
                } else
                    ans.add(temp);
                temp = new ArrayList<Integer>();
                queue.add(null);
                flag = !flag;
            } else {
                TreeNode treeNode = front.treeNode;
                int level = front.level;

                temp.add(treeNode.val);
                if (treeNode.left != null) {
                    queue.add(new Node(treeNode.left, level + 1));
                }
                if (treeNode.right != null) {
                    queue.add(new Node(treeNode.right, level + 1));
                }


            }

        }
        if (flag) {
            Collections.reverse(temp);
            ans.add(temp);
        } else
            ans.add(temp);
        return ans;
    }
}