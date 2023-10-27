package DSA.journey.slidingWindow;

public class MaximizeWinFromTwoSegments {

    public static void main(String[] args) {
        int arr[]={2616,2618,2620,2621,2626,2635,2657,2662,2662,2669,2671,2693,2702,2713,2714,2718,2730,2731,2750,2756,2772,2773,2775,2785,2795,2805,2811,2813,2816,2823,2824,2824,2826,2830,2833,2857,2885,2898,2910,2919,2928,2941,2942,2944,2965,2967,2970,2973,2974,2975,2977,3002,3007,3012,3042,3049,3078,3084,3089,3090,3094,3097,3114,3124,3125,3125,3144,3147,3148,3174,3197,3255,3262,3288,3291,3316,3320,3322,3331,3342,3378,3412,3412,3416,3420,3427,3428,3446,3452,3472,3479,3483,3488,3500,3516,3522,3531,3532,3540,3540,3544,3557,3570,3580,3592,3597,3597,3601,3615,3631,3640,3645,3673,3677,3681,3683,3685,3718,3738,3746,3758,3769,3797,3802,3815,3832,3839,3851,3864,3888,3889,3901,3902,3910,3913,3933,3940,3961,3974,3988,4003,4013,4019,4023,4026,4047,4060,4065,4072,4073,4082,4084,4109,4132,4139,4143,4145,4146,4155};
        int k=6641;
        System.out.println(new MaximizeWinFromTwoSegments().maximizeWin(arr,k));
    }

    public int maximizeWin(int[] arr, int k) {
        int fans=Integer.MIN_VALUE;
        int n=arr.length;
        for(int i=0;i<n;i++){
            int ans=0;
            int min=arr[i];
            int max=arr[n-1];
            int firstSegMax=min+k;
            int firstSegMaxIndex=BS(arr,i,n-1,firstSegMax);
            if(firstSegMaxIndex==-1){
                firstSegMaxIndex=BS2(arr,i,n-1,firstSegMax);
            }
            ans=ans+(firstSegMaxIndex-i+1);
            if(firstSegMaxIndex+1<n){
                int secondSegMin=arr[firstSegMaxIndex+1];
                int secondSegMax=secondSegMin+k;
                int secondSegMaxIndex=BS(arr,firstSegMaxIndex+1,n-1,secondSegMax);
                if(secondSegMaxIndex==-1){
                    secondSegMaxIndex=BS2(arr,firstSegMaxIndex+1,n-1,secondSegMax);
                }
                ans=ans+(secondSegMaxIndex-(firstSegMaxIndex+1)+1);
                fans=Math.max(fans,ans);
            }
        }

        return fans;


    }
    public int maximizeWin1(int[] arr, int k) {
        int ans=0;
        int min=arr[0];
        int n=arr.length;
        int max=arr[n-1];
        int firstSegMax=min+k;
        int firstSegMaxIndex=BS(arr,0,n-1,firstSegMax);
        if(firstSegMaxIndex==-1){
            firstSegMaxIndex=BS2(arr,0,n-1,firstSegMax);
        }
        ans=ans+firstSegMaxIndex+1;
        if(firstSegMaxIndex+1<n){
            int secondSegMin=arr[firstSegMaxIndex+1];
            int secondSegMax=secondSegMin+k;
            int secondSegMaxIndex=BS(arr,firstSegMaxIndex+1,n-1,secondSegMax);
            if(secondSegMaxIndex==-1){
                secondSegMaxIndex=BS2(arr,firstSegMaxIndex+1,n-1,secondSegMax);
            }
            ans=ans+(secondSegMaxIndex-(firstSegMaxIndex+1)+1);
        }
        return ans;


    }
    public int BS(int arr[],int low,int high,int k){
        int ans=-1;
        while(low<=high){
            int mid=(low+(high-low)/2);
            if(arr[mid]==k){
                ans=mid;
                high=mid-1;
            }
            else if(arr[mid]<k){
              //  ans=mid;
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return ans;
    }
    public int BS2(int arr[],int low,int high,int k){
        int ans=-1;
        while(low<=high){
            int mid=(low+(high-low)/2);
             if(arr[mid]<k){
                 ans=mid;
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return ans;
    }
}
