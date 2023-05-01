package DSA.journey.Array1d_1march;

public class RainWaterTapped {

    public static void main(String[] args) {
        int arr[]={0,1,0,2};
        System.out.println(new RainWaterTapped().trap(arr));
    }
    public int trap(final int[] A) {
        int ans=0;
        int left[]=new int[A.length];
        int right[]=new int[A.length];
        left[0]=A[0];

        for(int i=1;i<A.length;i++){
            left[i]=Math.max(left[i-1],A[i]);
        }

        right[A.length-1]=A[A.length-1];
        for(int i=A.length-2;i>=0;i--){
            right[i]=Math.max(right[i+1],A[i]);
        }

        for(int i=1;i<A.length-1;i++){
            if(left[i]<right[i]){
                ans=ans+left[i]-A[i];
            }
            else{
                ans=ans+right[i]-A[i];
            }
            //lans=ans+Math.max(left[i],right[i])-A[i];
        }


        // 2 0 0
        return ans;

    }
}
