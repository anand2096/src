package DSA.Arrays;

public class SearchElementInMatrix {
    public static void main(String[] args) {


       //Enter target here to test
        int target = 17;


        //assume this is m*n single dimension array.

        int arr[][] = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}

        };
        int m = arr.length;
        int n = arr[0].length;
        int low = 0;
        int high = (m * n) - 1;



        while(low<=high){

            int mid=(low+high)/2;
            int row=mid/n;
            int col=mid%n;
            if(arr[row][col]==target){
                System.out.println("True");
                break;
            }
            else if(target<arr[row][col]){

                high=mid-1;
            }
            else{

                low=mid+1;
            }


        }


    }

//    public  void divideArray(int[][] arr, int m, int n, int t) {
//
//        if(t>=arr[m/2][0]&&t<arr[m/2][arr[m/2].length-1]){
//
//        }
//        else if(t<arr[m/2][0]){
//
//            divideArray(arr,m/2,n,t);
//        }
//        else if(t>arr[m/2][arr[m/2].length-1]){
//
//            divideArray(arr,m+1,n,t);
//        }



    }

