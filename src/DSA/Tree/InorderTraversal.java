package DSA.Tree;

import java.util.Stack;

public class InorderTraversal {

    public static void main(String[] args) {
                /* Construct the following tree
                   1
                 /   \
                /     \
               2       3
              /      /   \
             /      /     \
            4      5       6
                  / \
                 /   \
                7     8
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);

        inorderIterative(root);

    }

    public static void inorderRecursion(Node root){

        if(root ==null) return;
        inorderRecursion(root.left);
        System.out.println(root.data);
        inorderRecursion(root.right);

    }




    public static void inorderIterative(Node root){
        Stack<Node> stack =new Stack<>();
        Node curr =root;
        while(!stack.empty() || curr!=null){

            if(curr!=null){

                stack.push(curr);
                curr=curr.left;
            }
            else{
                curr=stack.pop();
                System.out.println(String.valueOf(curr.data));
                curr=curr.right;

            }


        }


    }
}
