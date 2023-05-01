package DSA.journey.BitManipulation;

public class MaximumAndPair {

    public static void main(String[] args) {
        int arr[]={26,13,23,28,27,7,25};
        System.out.println(new MaximumAndPair().solve(arr));
    }
    public int solve(int[] arr) {
        int ans=0;
        for(int i=30;i>=0;i--){
            // we will try to set if we can set if this i'th bit in answer
        int count=0;
        for(int j=0;j<arr.length;j++) {
            if (checkSetBit(arr[j], i)) {
                count++;
            }
        }
            if(count>=2){
                ans=ans+(1<<i);
                for(int k=0;k<arr.length;k++){
                    if(!checkSetBit(arr[k],i)){
                        arr[k]=0;
                    }
                }
            }
        }

        return ans;
    }

    public boolean checkSetBit(int number,int index){
        return (((number>>index)&1)==1);
    }
}
