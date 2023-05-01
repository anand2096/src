package DSA.journey.TwoPointers;

public class ClosestPairFromSortedArrays {


    public static void main(String[] args) {
//       int [] A = { 5, 10, 20 };
//        int B []= { 1, 2, 30 };
//        int C = 13;

        int [] A = { 1 };
        int B []= { 2,4 };
        int C = 4;
//        int [] A = { 1, 3, 5, 7, 9  };
//        int B []= { 2, 4, 6, 8, 10 };
//        int C =10;
        int ans[]=new ClosestPairFromSortedArrays().solve(A,B,C);
        System.out.println(ans[0]+" "+ans[1]);

    }

    public int[] solve(int[] arr, int[] brr, int k) {
        int ans[] = new int[2];
        ans[0] = Integer.MAX_VALUE;
        ans[1] = Integer.MAX_VALUE;
        int n = arr.length;
        int m = brr.length;
        int i = 0;
        int j = m-1;
        int min = Integer.MAX_VALUE;
        while (i < n && j >=0 ) {
            if (arr[i] + brr[j] == k) {
                ans[0] = arr[i];
                ans[1] = brr[j];
                return ans;
            }
            else if (arr[i] + brr[j] < k) {
                int temp = Math.abs(arr[i] + brr[j] - k);
                if (temp <= min) {
                    if(temp==min){
                        if(i<=ans[0])
                        ans[1] = Math.min(ans[1],j);
                    }
                    else {
                        min = Math.abs(arr[i] + brr[j] - k);
                        ans[0]=i;
                        ans[1]=j;
                    }
                }
                i++;
            } else {
                int temp = Math.abs(arr[i] + brr[j] - k);
                if (temp <= min) {
                    if(temp==min ){
                        ans[0] = Math.min(ans[0],i);
                    }
                    else {
                        min = Math.abs(arr[i] + brr[j] - k);
                        ans[0]=i;
                        ans[1]=j;
                    }

                }
                j--;
            }

        }
        ans[0]=arr[ans[0]];
        ans[1]=brr[ans[1]];
        return ans;

    }
}
