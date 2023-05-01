package DSA.Greedy;

public class Maximumproductsubsetofanarray {


    public static void main(String[] args) {

       // int arr [] = {-1, -1, -2, 4, 3};
        int arr [] = {0,0,0,0,0,0};
        //int arr[]={-1,0};
        System.out.println(findMaxProduct(arr.length,arr));
    }


    public static int findMaxProduct(int n, int[] arr) {

        int proPos=1;
        int proNegative=1;
        int highestNegative= Integer.MIN_VALUE;
        int negativeCount=0;
        int positiveCount=0;
        boolean zero=false;


        for(int i=0;i<arr.length;i++){
            if(arr[i]>0){
                proPos*=arr[i];
                positiveCount++;
            }
            else if(arr[i]<0){
                negativeCount++;
                if(arr[i]>highestNegative)
                    highestNegative=arr[i];
                proNegative*=arr[i];

            }
            else{
                zero=true;
            }
        }

        if(negativeCount%2!=0){
            proNegative=proNegative/highestNegative;
        }

        if(positiveCount==0&& zero)
            return 0;
        return (proPos*proNegative)%(1000000007);
    }
}