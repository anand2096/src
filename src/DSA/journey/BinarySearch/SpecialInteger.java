package DSA.journey.BinarySearch;

public class SpecialInteger {
    public static void main(String[] args) {
       int  a []= { 1, 1000000000};
                // 0  1  2  3  4
        int b = 1000000000; //2 = 3

//        int  a []= {1,2,3,4,5};
//        // 0  1  2  3  4
//        int b = 10; //3 =2
        System.out.println(new SpecialInteger().solve(a,b));
    }
    public int solve(int[] arr, int b) {
        int ans=0;
        int n=arr.length;
        long prefix[]=new long[n];
        prefix[0]=arr[0];
        for(int i=1;i<n;i++){
            prefix[i]=arr[i]+prefix[i-1];
        }
        int low=1;
        int high=n;

        while(low<=high){
            int mid=(low+high)/2;
            int i;
            boolean flag=false;
            int j=mid-1;
            for(i=j;i<n;i++){
                if(i-mid>=0){
                    if(prefix[i]-prefix[i-mid]>b){
                        flag=true;
                        break;
                    }
                }
                else{
                    if(prefix[i]>b){
                        flag=true;
                        break;
                    }
                }
            }
            if(flag){
                high=mid-1;

            }
            else {
                ans=mid;
                low = mid + 1;
            }
//            else{
//                low=mid+1;
//            }
        }
        return ans;
    }

}
