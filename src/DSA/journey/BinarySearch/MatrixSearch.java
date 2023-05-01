package DSA.journey.BinarySearch;

public class MatrixSearch {
    public static void main(String[] args) {
//        int a[][] = {
//                {1, 4, 5, 5, 6, 14, 14, 16, 19},
//                {22, 24, 28, 33, 35, 37, 38, 40, 41},
//                {45, 50, 52, 55, 56, 56, 57, 60, 60},
//                {63, 64, 66, 68, 68, 71, 78, 78, 79},
//                {84, 89, 90, 91, 93, 94, 94, 97, 98}
//        };

        int a[][]={
                {2, 3, 4, 4, 5, 5, 6},
                {10, 11, 12, 13, 13, 14, 15},
                {16, 25, 25, 26, 28, 28, 30},
                {30, 32, 33, 39, 39, 40, 41},
                {44, 44, 47, 49, 51, 55, 57},
                {57, 60, 60, 61, 61, 62, 63},
                {64, 65, 66, 67, 68, 71, 71},
                {75, 77, 77, 77, 78, 79, 80},
                {81, 83, 84, 85, 86, 88, 88},
                {91, 92, 93, 93, 95, 95, 98},
        };



       int B =1;
        System.out.println(new MatrixSearch().searchMatrix(a,B));
    }


    public int searchMatrix(int[][] arr, int k) {
        int n=arr.length;
        int m=arr[0].length;

        //find row

        int low=0;
        int high=n-1;
        int mid=0;
        while(low<=high){
            mid=(low+high)/2;
            if(arr[mid][0]==k){
                return 1;
            }
            else if(arr[mid][0]<k){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        if(arr[mid][0]>k){
            mid=mid-1;
        }
        if(mid<0){
            return 0;
        }
        int finalRow=mid;
        low=0;
        high=m-1;
        while(low<=high){
            mid=(low+high)/2;
            if(arr[finalRow][mid]==k){
                return 1;
            }
            else if(arr[finalRow][mid]<k){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }

        return 0;

    }
}
