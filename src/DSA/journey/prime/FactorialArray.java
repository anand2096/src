package DSA.journey.prime;

import java.util.Arrays;

public class FactorialArray {

    public static void main(String[] args) {
    //  int arr[]={ 251, 923, 561, 230, 100, 399, 542, 198, 548, 892, 721, 781, 174, 809, 9, 232, 165, 861, 36, 837, 377, 313, 475, 269, 210, 530, 940, 570, 24, 434, 764, 275, 709, 325, 505, 161, 724, 47, 359, 625, 291, 81, 406, 465, 242, 767, 698, 408, 629, 86, 597, 358, 399, 72, 979, 962, 603, 919, 884, 627, 353, 1, 254, 414, 678, 111, 575, 755, 511, 287, 380, 802, 720, 138, 620, 314, 905, 670, 74, 886, 756, 671, 244, 508, 744, 224, 822, 347, 495, 706, 326, 201, 707, 580, 615, 386, 43, 543, 141, 554  };
    //  int arr[]={182, 873, 357, 902, 11, 977, 568, 916, 647, 643, 155, 755, 314, 399, 263, 410, 975, 85, 109, 823, 144, 435, 24, 851, 367, 639, 589, 411, 534, 82, 965, 716, 955, 674, 970, 966, 651, 539, 235, 650, 534, 390, 406, 200, 141, 669, 611, 469, 107, 720, 292, 251, 508, 316, 454, 875, 307, 44, 638, 194, 478, 956, 910, 434, 630, 233, 752, 634, 124, 987, 284, 658, 377, 690, 858, 871, 712, 821, 340, 819, 542, 984, 422, 50, 652, 876, 277, 959, 272, 268, 505, 751, 224, 768, 537, 206, 1, 289, 840, 477};
        int arr[]={2, 3, 4, 5, 6 };

        System.out.println(new FactorialArray().solve(arr));
    }
    public int solve(int[] a) {
        if(a.length==1)return 1;
        int ans=0;
        Arrays.sort(a);
        int max=a[a.length-1];
        boolean prime[]=new boolean[max+1];
        prime[0]=false;
        prime[1]=false;
        for(int i=2;i<=max;i++){
            prime[i]=true;
        }
        for(int i=2;i*i<=max;i++){
            if(prime[i]){
                for(int j=i*i;j<=max;j=j+i){
                    if(prime[j])
                    prime[j]=false;
                }
            }
        }
        int k=0;
        //3 4 5 7 10
        int currentPointer=0;

        for(int i=2;i< prime.length;i++){

            if(prime[i]){
                int cnt=0;
                int no=i;

                while(currentPointer<a.length){
                    if(a[currentPointer]<no){
                        cnt++;
                        currentPointer++;
                    }
                    else{
                        break;
                    }
                }

                ans=ans+(int)Math.pow(2,cnt)-1;
            }
        }
        if(currentPointer<a.length){
            int c=a.length-currentPointer;

            ans=ans+(int)Math.pow(2,c)-1;
            if(a.length%2==0)
                ans=ans-1;
         //   ans=ans+c;
        }

        return ans;
    }
}
