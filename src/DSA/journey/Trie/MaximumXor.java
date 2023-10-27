package DSA.journey.Trie;
class NodeChild{
    NodeChild [] children=new NodeChild[2];
}

public class MaximumXor {

    public static void main(String[] args) {
        int arr[]={1, 2, 3, 4, 5};
        System.out.println( new MaximumXor().solve(arr));
    }
    public int solve(int[] arr) {
        NodeChild root=new NodeChild();
        //build your Trie
        createTrie(arr,root);
        //find max
        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++) {
            NodeChild curr = root;
            int val = arr[i];
            int ans = 0;
            for (int j = 31; j >= 0; j--) {
                if (checkSetBit(val, j)) {
                    if (curr.children[0] != null) {
                        ans = ans + (1 << j);
                        curr = curr.children[0];
                    } else {
                        curr = curr.children[1];
                    }
                } else {
                    if (curr.children[1] != null) {
                        ans = ans + (1 << j);
                        curr = curr.children[1];
                    } else {
                        curr = curr.children[0];
                    }
                }
            }
            max = Math.max(max, ans);
        }


    return max;
    }
    public void createTrie(int arr[],NodeChild root){
        for(int i=0;i<arr.length;i++){
            int val=arr[i];
            NodeChild curr=root;
            for(int j=31;j>=0;j--){
                if(checkSetBit(val,j)){
                    if(curr.children[1]==null){
                        curr.children[1]=new NodeChild();
                    }
                    curr=curr.children[1];
                }else{
                    if(curr.children[0]==null){
                        curr.children[0]=new NodeChild();
                    }
                    curr=curr.children[0];
                }
            }
        }
    }
    public boolean checkSetBit(int no,int i){

        return ((no>>i) & 1)==1;
    }

}
