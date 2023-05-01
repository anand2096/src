package DSA.Tree;

import java.util.ArrayList;
import java.util.List;

public class SumRootToLeafNumbers {
    int ans = 0;

    public static void main(String[] args) {
        TreeNode root= new TreeNode(0);
        root.left=new TreeNode(1);
//        root.right=new TreeNode(0);
//        root.left.left=new TreeNode(5);
//        root.left.right=new TreeNode(1);
        System.out.println(new SumRootToLeafNumbers().sumNumbers(root));
    }
    public int sumNumbers(TreeNode root) {
        rec(root,new ArrayList<>());
        return ans;
    }


    //Going top to  down approach
    public int dfs(TreeNode root, int sum){
        if(root==null){
            return 0;

        }
        sum=sum*10+root.val;
        if(root.left==null && root.right==null){
            return sum;
        }
        return dfs(root.left,sum)+dfs(root.right,sum);
    }

    //Going bottom to up appoach
    public void rec(TreeNode root, List<Integer> list) {
        if (root.left==null && root.right==null) {
            list.add(root.val);
            int s = 0;
            int j = 0;
            for (int i = list.size() - 1; i >= 0; i--) {
                s = s + list.get(i) * (int) Math.pow(10, j);
                j++;
            }
            ans = ans + s;
            list.remove(list.size()-1);
            return;
        } else {
            list.add(root.val);
            if(root.left!=null)
            rec(root.left, list);
            if(root.right!=null)
            rec(root.right, list);
            list.remove(list.size() - 1);

        }
    }
}
