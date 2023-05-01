package DSA.SeachingAndSorting;

public class SearchingInAnArrayAdjacentDifferByAtmost_k {

    public static void main(String[] args) {
        int arr[] = {20, 40, 50, 70, 70, 60};
        int x = 70;
        int k = 20;

        System.out.println(search(arr,x,k));
    }
    static int search(int arr[],
                      int x, int k){
        int ans=-1;
        int i=0;
        while(i<arr.length){
            if(arr[i]==x)
            {
                ans=i;
                break;
            }
            else
            {
                i=i+Math.max(1,Math.abs(x-arr[i])/k);
            }



        }
        return ans;



    }
}

