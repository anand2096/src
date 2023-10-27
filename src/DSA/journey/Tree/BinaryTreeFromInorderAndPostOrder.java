package DSA.journey.Tree;

public class BinaryTreeFromInorderAndPostOrder {

    public static void main(String[] args) {
        int a[]={ 6, 1, 3, 2};
        int b[]={6, 3, 2, 1};
        System.out.println(new BinaryTreeFromInorderAndPostOrder().buildTree(a,b));
    }

    public TreeNode buildTree(int[] A, int[] B) {
        TreeNode ans= rec(A,B,0,A.length-1,B.length-1,0);
        System.out.println(new PostOrder().postorderTraversal(ans));
        return ans;

    }
    public TreeNode rec(int ino[],int pos[],int is,int ie,int pe,int ps){
        if(ps>pe || is>ie )return null;
        TreeNode root=new TreeNode(pos[pe]);
        int idx=search(pos[pe],ino,is,ie);
        if(idx!=-1){
            // no of elements on left = idx-is
            // no of elements on right= ie-idx
             root.left=rec(ino,pos,is,idx-1,pe-(ie-idx)-1,ps);
             root.right=rec(ino,pos,idx+1,ie,pe-1,pe-(ie-idx));
        }

        return root;

    }
    public int search(int target,int[] ino,int is,int ie ){
        for(int i=is;i<=ie;i++){
            if(ino[i]==target){
                return i;
            }
        }
        return -1;
    }
}
