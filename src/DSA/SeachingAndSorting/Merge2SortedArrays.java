package DSA.SeachingAndSorting;

public class Merge2SortedArrays {


    public static void main(String[] args) {
        int arr1[] = {1, 3, 5, 7};
        int arr2[] = {0, 2, 6, 8, 9};

        Merge2SortedArrays.merge(arr1,arr2,arr1.length,arr2.length);
    }
    public static void merge(int arr1[], int arr2[], int m, int n) {
        // code here

        int i=0;
        int j=0;
        while(i<m&&j<n){

            if(arr1[i]<arr2[j]){

                System.out.print(arr1[i]+" ");
                i++;
            }
            else
            {
                System.out.print(arr2[j]+" ");
                j++;
            }
        }
        while(i<m)
        {
            System.out.print(arr1[i]+" ");
            i++;
        }
        while(j<n)
        {
            System.out.print(arr2[j]+" ");
            j++;
        }



    }
}
