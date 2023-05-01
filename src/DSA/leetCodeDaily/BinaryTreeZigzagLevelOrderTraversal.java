package DSA.leetCodeDaily;

import DSA.Tree.TreeNode;

import java.util.*;


class Pair {
    TreeNode node;
    int level;

    Pair(TreeNode node, int level) {

        this.node = node;
        this.level = level;
    }
}

public class BinaryTreeZigzagLevelOrderTraversal {

    public static void main(String[] args) {
        //4,2,7,1,3,6,9
        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(9);
//        root.right = new TreeNode(20);
////        root.left.left = new TreeNode(1);
////        root.left.right = new TreeNode(3);
//        root.right.left = new TreeNode(15);
//        root.right.right = new TreeNode(7);
        List<List<Integer>> ans = new BinaryTreeZigzagLevelOrderTraversal().zigzagLevelOrder(root);
        System.out.println(ans);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        levelOrderTraversal(root, ans);
        for (int i = 0; i < ans.size(); i++) {
            if (i % 2 != 0) {
                List<Integer> temp = ans.get(i);
                Collections.reverse(temp);
                ans.set(i, temp);
            }
        }
        return ans;
    }

    public void levelOrderTraversal(TreeNode root, List<List<Integer>> ans) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {

            Pair peekNode = queue.peek();
            int curLevel = peekNode.level;
            TreeNode curNode = peekNode.node;
            queue.remove(peekNode);
            if (curLevel<ans.size()) {
                ans.get(curLevel).add(curNode.val);
            } else {
                List<Integer> temp = new ArrayList<>();
                if(curNode!=null){
                temp.add(curNode.val);
                ans.add(curLevel, temp);}
            }
            if (curNode!=null&&curNode.left != null) {
                queue.add(new Pair(curNode.left, curLevel + 1));
            }
            if (curNode!=null&&curNode.right != null) {
                queue.add(new Pair(curNode.right, curLevel + 1));
            }

        }
    }
}
