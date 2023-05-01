package DSA.Arrays;

public class SeprateNegativeNumbers {
    public static void main(String[] args) {
//        An array contains both positive and negative numbers in random order.
//        Rearrange the array elements so that all negative numbers appear before all positive numbers.
//
//        Examples :
//
//        Input: -12, 11, -13, -5, 6, -7, 5, -3, -6
//        Output: -12 -13 -5 -7 -3 -6 11 6 5
        int arr[] = {-12, 11, -13, -5, 6, -7, 5, -3, -6};
        int i = 0;
        int j = arr.length - 1;
        while (i < j) {


            while (arr[i] < 0) i++;
            while (arr[j] > 0) j--;
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }


//            // 0<8
//            i=1,
//             j=8;
            // -12 -6 -13 -5 6 -7 5 -3 11
            //i=2 , j= 7
            //i=4 j=7
            //-12 -6 -13 -5 -3 -7 5 6  11
          //  i = 5 j = 6
//
//
//
        }

        for (int k = 0; k < arr.length; k++)
            System.out.println(arr[k]);


    }
}
