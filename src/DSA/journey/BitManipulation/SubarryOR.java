package DSA.journey.BitManipulation;

public class SubarryOR {
//exprected =579094379
// retuerned = 284127111
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5};
        System.out.println(new SubarryOR().solve(arr));
    }

    public boolean checkSetBit(int number,int index){
        return (((number>>index)&1)==1);
    }

    public int solve(int[] arr) {
        int mod=1000000007;
        long ans=0;
        long n=arr.length;
        long totalSubarrayCount=(n*(n+1))/2;
        for(int i=0;i<=30;i++){
            int j=0;
            long zeroSubarrayCount=0;
            while(j<n) {
                if (!checkSetBit(arr[j], i)) {
                    long count = 0;
                    while (j<n && (!checkSetBit(arr[j], i))) {
                        count++;
                        j++;
                    }
                    zeroSubarrayCount = (zeroSubarrayCount + ((count * (count + 1)) / 2))%mod;
                }
                j++;
            }
            long setBitSubarray=totalSubarrayCount-zeroSubarrayCount;
            ans=(ans+(long)(((long)setBitSubarray)*((long)(1<<i))))%mod;

        }
        return (int)(ans%mod);
    }


  //398980269
  //638104161
    public int solve1(int[] arr) {
        int mod=1000000007;

        int []idx=new int[32];
        int n=arr.length;
        long ans=0;

        //1 2 3

        for(int i=1;i<=n;i++){
            long temp=arr[i-1];//1
            for(int j=0;j<=31;j++){
                long pw=1<<j; //1
                //01 & 01 =1 only
                if((temp&pw)!=0){
                    ans+=pw*i;//  1 * 1=1   adding its contribution
                    idx[j]=i;// store the index for next elements
                }
                else if(idx[j]!=0){
                    ans+=pw*idx[j];
                }
            }
        }
        return (int)(ans%mod);












   //     for(int i=0;i<=30;i++){

//            int ind=n;
//            for(int j=n-1;j>=0;j--){
//                boolean bit = ((arr[j]>>i)&1)==1;
//                if(bit){
//                    ind=j;
//                }
//
//
//                ans=(ans+((long)(n-ind)*(long)(1<<i)))%mod;
//             //   ans=(ans+(((long)(n-i)%mod)*((long)(1<<i)%mod)%mod)%mod);
//
//              //  ans=(ans%mod+(((n-ind)%mod)*((1<<i)%mod))%mod)%mod;
//
//            }
//        }
//
//        return (int)(ans%mod);
    }
}
