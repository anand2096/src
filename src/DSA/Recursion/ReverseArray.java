package DSA.Recursion;

public class ReverseArray {
    public static void main(String[] args) {
       int arr[]= {2,4,3,2,1}; //len 5
       for(int i=0;i<arr.length;i++){
           System.out.print(arr[i]+" ");
       }
        System.out.println();
       new ReverseArray().reverseArray(arr,0);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();

    }
    public void reverseArray(int []arr,int i){
        if(i>=(arr.length)/2){
        return;
        }
        int temp=arr[i];
        arr[i]=arr[arr.length-1-i];//5
        arr[arr.length-1-i]=temp;
        reverseArray(arr,i+1);




    }


}
