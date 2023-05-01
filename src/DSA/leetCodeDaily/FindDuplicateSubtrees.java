package DSA.leetCodeDaily;

import DSA.Tree.PreOrderTraversal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
 }


public class FindDuplicateSubtrees {
    Map<String,Integer> map=new HashMap<>();
    List<TreeNode> ansT=new ArrayList<>();

    public static void main(String[] args) {

//        TreeNode root = new TreeNode(2);
//        root.left=new TreeNode(1);
//        root.right = new TreeNode(1);



        TreeNode root = new TreeNode(1);
        root.left=new TreeNode(2);
        root.left.left=new TreeNode(4);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(4);
        root.right.left.left = new TreeNode(4);
        System.out.println(new FindDuplicateSubtrees().findDuplicateSubtrees(root));
    }
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode>ans =new ArrayList<>();


        preorder(root,map,ansT);
//        for(Map.Entry<String,Integer> entry:map.entrySet()){
//            if(entry.getValue()>1){
//                String key=entry.getKey();
//                int rootNode=(Character.getNumericValue(key.charAt(0)));
//                ans.add(new TreeNode(rootNode));
//            }
//        }


        return ansT;

    }

    public String preorder(TreeNode root,Map<String,Integer> map,List<TreeNode> ansT){
        if(root==null)return null;

        int rootVal=root.val;
        String left=preorder(root.left,map,ansT);
        String right=preorder(root.right,map,ansT);
         String store=String.valueOf(rootVal)+","+left+","+right;
        //System.out.println(store);


        map.put(store,map.getOrDefault(store,0)+1);

        if(map.getOrDefault(store,0)==2){
            ansT.add(root);
            System.out.println("ans :: " +store);
        }
        return store;


    }
}
