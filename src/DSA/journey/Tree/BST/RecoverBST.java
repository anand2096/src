package DSA.journey.Tree.BST;
import DSA.journey.Tree.TreeNode;
public class RecoverBST {

    TreeNode prev=null;
    TreeNode finalPrev=null;
    TreeNode finalCurr=null;
    public void recoverTree(TreeNode root) {

        morrisInorder(root);


    }


    public void morrisInorder(TreeNode root){

        TreeNode curr=root;
        while(curr!=null){
            if(curr.left==null){
                //print curr.val
                if(prev!=null){
                    if(prev.val>=curr.val){
                       // finalPrev=prev;
                       // finalCurr=curr;
                        int temp=prev.val;
                        prev.val=curr.val;
                        curr.val=temp;
                       // break;
                    }
                }
                prev=curr;
                //and move right
                curr=curr.right;
            }
            else{
                TreeNode temp=curr.left;
                while(temp.right!=null && temp.right!=curr){
                    temp=temp.right;
                }
                if(temp.right==null){
                    temp.right=curr;
                    prev=curr;
                    curr=curr.left;
                }
                else if(temp.right==curr){

                    // print curr data
                    //move right side
                    if(temp.right==null &&prev!=null){
                        if(prev.val>=curr.val){
                            int temp1=prev.val;
                            prev.val=curr.val;
                            curr.val=temp1;
                        }
                    }
                    temp.right=null;
                    prev=curr;
                    curr=curr.right;
                }
            }
        }

        //swap previous and curr
//        int temp=finalPrev.val;
//        finalPrev.val=finalCurr.val;
//        finalCurr.val=temp;

    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(3);
        //root.right=new TreeNode(5);
        //root.left.left=new TreeNode(3);
        root.left.right=new TreeNode(2);
    //    root.right.right=new TreeNode(6);
      new RecoverBST().recoverTree(root);;
    }
}
