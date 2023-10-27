package DSA.journey.Tree;
import java.util.*;
class Pair{
    TreeNode node;
    int dis;
    public Pair(TreeNode node,int dis){
        this.node=node;
        this.dis=dis;
    }
}
public class EvenOddSum {

    public static void main(String[] args) {

//        [3,5,1,6,2,0,8,null,null,7,4]
//        5
//        2
        TreeNode root=new TreeNode(3);
        root.left=new TreeNode(5);

        root.right=new TreeNode(1);
        root.left.left=new TreeNode(6);
        root.left.right=new TreeNode(2);
        root.left.right.left=new TreeNode(7);
        root.left.right.right=new TreeNode(4);
        root.right.left=new TreeNode(0);
        root.right.right=new TreeNode(8);
        //root.left.left.left=new TreeNode(8);
     //   System.out.println(new EvenOddSum().zigzagLevelOrder(root));
        System.out.println(new EvenOddSum().distanceK(root,root.left.right.left,2));
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        List<Integer> ans=new ArrayList<>();
        Queue<Pair> que=new LinkedList<>();
        que.add(new Pair(root,0));
        Map<Integer,Integer> map=new HashMap<>();

        while(!que.isEmpty()){
            Pair top=que.peek();
            que.remove();
            TreeNode nod=top.node;
            map.put(nod.val,top.dis);
            if(nod.left!=null){
                que.add(new Pair(nod.left,top.dis+1));
            }
            if(nod.right!=null){
                que.add(new Pair(nod.right,top.dis+1));

            }
        }

        if(!map.containsKey(target))return new ArrayList<>();
        int mainDis=map.get(target);

        for(Map.Entry<Integer,Integer> m:map.entrySet()){

            if(Math.abs(m.getValue()-mainDis)==k){
                ans.add(m.getKey());
            }
        }
        return ans;
    }



}
