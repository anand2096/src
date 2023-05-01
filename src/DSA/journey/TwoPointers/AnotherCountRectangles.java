package DSA.journey.TwoPointers;

public class AnotherCountRectangles {

    public static void main(String[] args) {
        int arr[]={500426, 1501807, 1502276, 1502416, 1502492, 1502842, 1503188, 1503712, 1504350, 1504376, 1504857, 1505306, 1506539, 1507234, 1508410, 1509455, 1509820, 1510302, 1513911, 1514466, 1516026, 1516281, 1517053, 1518075, 1519426, 1519429, 1519526, 1520982, 1521350, 1521718};
        int k=1504376;
        System.out.println(new AnotherCountRectangles().solve(arr,k));
    }
    public int solve(int[] arr, int k) {
        long mod=(long)Math.pow(10,9)+7;

        int n=arr.length;
        int i=0;
        int j=n-1;
        long ans=0;
        while(i<=j){
            if((long)arr[i]*arr[j]>=k){
                j--;
            }
            else{

                long temp=(j-i+1)* 2L -1;
                ans=(ans+temp)%mod;
                i++;

            }

        }
        return (int) ((int)ans%mod);
    }


//    public int solve(ArrayList < Integer > A, int B) {
//        long ans = 0, mod = (long)(1000000000 + 7);
//        int l = 0, r = A.size() - 1;
//        while (l < A.size() && r >= 0) {
//            if ((long) A.get(l) * A.get(r) < B) {
//                // A[l] can form rectangles with any of A[0..r]
//                ans = (ans + r + 1) % mod;
//                l++;
//            } else r--;
//        }
//        return (int) ans;
//    }
}
