package DSA.journey.BitManipulation;

public class SingleNumberIII {
    public static void main(String[] args) {

        int arr[]={1,2,3,1,2,4};
        int ans[]=new SingleNumberIII().solve(arr);
        System.out.println(ans[0]+" "+ans[1]);
    }
    public int[] solve(int[] arr) {
    int ans[]=new int[2];

    int totalXor=arr[0];
    for(int i=1;i<arr.length;i++){
        totalXor=totalXor^arr[i];
    }
    int left=0;
    int right=0;
    int pos=-1;
    for(int i=0;i<=30;i++){
        if(checkBit(totalXor,i)){
            pos=i;
            break;

        }
    }

    for(int i=0;i<arr.length;i++){

        if(checkBit(arr[i],pos)){
            left=left^arr[i];
        }
        else{
            right=right^arr[i];
        }
    }

    if(left<right){
        ans[0]=left;
        ans[1]=right;
    }
    else{
        ans[0]=right;
        ans[1]=left;
    }
    return ans;

    }

    public boolean checkBit(int number,int index){

        return (((number>>index)&1)==1);
    }
}
