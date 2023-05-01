package DSA.Tree;

import java.util.ArrayList;
import java.util.List;

public class PreOrderTraversal {
    List<Integer> ans = new ArrayList<>();

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

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(new PreOrderTraversal().preorderTraversal(root));
    }


    public List<Integer> preorderTraversal(TreeNode root) {

        if (root == null) return new ArrayList<Integer>();
        else {
            ans.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }

        return ans;
    }
}
