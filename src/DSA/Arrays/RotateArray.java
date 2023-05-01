package DSA.Arrays;

public class RotateArray {

    public static void main(String[] args) {
        int arr[]={1,2,3,4,5};


        int n=5;
        int i=1;
        while(i<=n){

            int last_no=arr[arr.length-1];
            int first=arr[0];
            for(int j=1;j<arr.length;j++){
                int temp=arr[j];
                arr[j]=first;
                first=temp;
            }
            arr[0]=last_no;
        i++;
        }
        for(int k=0;k<arr.length;k++)
            System.out.println(arr[k]);
    }
}
