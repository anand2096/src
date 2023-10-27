package DSA.journey.Trie;

import java.util.HashMap;
import java.util.Map;

public class MaximumXorSubArray {

    public static void main(String[] args) {
        int arr[]={15,25,23};
        int ans[]=new MaximumXorSubArray().solve(arr);
        for(int i=0;i<ans.length;i++){
            System.out.print(ans[i]+" ");
        }
    }


    public int[] solve(int[] arr) {
        int ansI=-1;
        int ansJ=-1;
        int []prefixXor=new int[arr.length];
        prefixXor[0]=arr[0];
        //calculating the prefix xor array
        for(int i=1;i<arr.length;i++){
            prefixXor[i]=prefixXor[i-1]^arr[i];
        }
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<prefixXor.length;i++){
            map.put(prefixXor[i],i);
        }
        NodeChild root=new NodeChild();
        //build Trie for prefixXor array
        createTrie(root,prefixXor);
        //find max
        int max=Integer.MIN_VALUE;
        for(int i=0;i<prefixXor.length;i++){
            NodeChild curr=root;
            int val=prefixXor[i];
            int ans=0;
            for(int j=31;j>=0;j--){
                if(checkSetBit(val,j)){
                    if(curr.children[0]!=null){
                        ans=ans+(1<<j);
                        curr=curr.children[0];
                    }
                    else{
                        curr=curr.children[1];
                    }
                }
                else{
                    if(curr.children[1]!=null){
                        ans=ans+(1<<j);
                        curr=curr.children[1];
                    }
                    else{
                        curr=curr.children[0];
                    }
                }
            }
            if(ans>max){
                max=Math.max(max,ans);
                int index=map.get(ans^val);
                ansI=Math.min(i,index);
                ansJ=Math.max(i,index);
            }

        }
        for(int i=0;i<prefixXor.length;i++){

            if(prefixXor[i]>=max){
                max=Math.max(max,prefixXor[i]);
                ansI=0;
                ansJ=i;
            }
        }
        int fans[]=new int[2];
        fans[0]=ansI+1;
        fans[1]=ansJ+1;
        return fans;

    }
    public void createTrie(NodeChild root,int arr[]){
        for(int i=0;i<arr.length;i++){
            NodeChild curr=root;
            for(int j=31;j>=0;j--){
                if(checkSetBit(arr[i],j)){
                    if(curr.children[1]==null){
                        curr.children[1]=new NodeChild();
                    }
                    curr=curr.children[1];
                }
                else{
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
