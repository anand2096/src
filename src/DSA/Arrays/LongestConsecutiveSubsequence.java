package DSA.Arrays;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSubsequence {
    public static void main(String[] args) {


        int arr[] = {2, 6, 1, 9, 4, 5, 3};
        System.out.println(longestConseSeq(arr));


//    int maxCnt=0;
//        List<Integer>fans=new ArrayList<>();
//
//    for(int i=0;i<arr.length;i++){
//        int cNo=arr[i];
//        int cnt=1;
//        int no=cNo+1;
//        while(no!=-1){
//            int ans=binarySearch(arr,0,arr.length-1,no);
//            if(ans!=-1){
//                cnt=cnt+1;
//                no=no+1;
//            }else{
//                no=-1;
//            }
//        }
//        fans.add(cnt);
//
//    }
//        System.out.println("Ans :: "+fans);

    }

//    public static int binarySearch(int arr[], int no, int low, int high) {
//        if (high >= low) {
//            int mid = (low + high) / 2;
//            if (no == arr[mid]) {
//                return 1;
//            } else if (no < arr[mid]) {
//                return binarySearch(arr, no, low, mid - 1);
//            } else {
//                return binarySearch(arr, no, mid, high);
//
//            }
//        }
//        return -1;
//
//
//    }
//    public static int binarySearch(int arr[], int first, int last, int key){
//        if (last>=first){
//            //chck this
//            int mid = first + (last - first)/2;
//            if (arr[mid] == key){
//                return 1;
//            }
//            if (arr[mid] > key){
//                return binarySearch(arr, first, mid-1, key);//search in left subarray
//            }else{
//                return binarySearch(arr, mid+1, last, key);//search in right subarray
//            }
//        }
//        return -1;
//


    public static int longestConseSeq(int nums[]) {
        Set<Integer> set = new HashSet();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int lStreak = 0;
        for (int i = 0; i < nums.length; i++) {
            int cNo = nums[i];
            int cStreak = 1;

            if (!set.contains(nums[i] - 1)) {

                while (set.contains(cNo + 1)) {
                    cStreak = cStreak + 1;
                    cNo += 1;
                }

            }
            lStreak = Math.max(lStreak, cStreak);

        }

        return lStreak;

    }
}


