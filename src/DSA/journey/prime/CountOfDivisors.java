package DSA.journey.prime;

public class CountOfDivisors {
//        for(int i=2;i<=Math.sqrt(max);i++){
//        if(spf[i]==0)
//        { spf[i]=i;}
//        for(int j=i*i;j<=max;j+=i){
//            if(prime[j]) {
//                if(spf[j]==0)
//                {spf[j]=i;}
//                prime[j] = false;
//            }
//        }
//    }
//        for(int i=2;i<spf.length;i++){
//        if(spf[i]==0){
//            spf[i]=i;
//        }
//    }
    public static void main(String[] args) {
        int arr[]={8, 9, 10};
        int ans[]=new CountOfDivisors().solve(arr);
        for(int i=0;i<ans.length;i++){
            System.out.print(ans[i]+" ");
        }

    }
    public int[] solve(int[] arr) {
        int ans[]=new int[arr.length];
        int max=Integer.MIN_VALUE;

        for(int i=0;i<arr.length;i++){
            max=Math.max(max,arr[i]);
        }


        int spf[]=new int[max+1];
        //calculating SPF

        for(int i = 1; i <= max; i++)
            spf[i] = i;
        for(int i=2;i*i<=max;i++){
            if(spf[i]!=i)
              continue;
            for(int j=i*i;j<=max;j+=i){
                    if(spf[j]==j)
                    {spf[j]=i;}

            }
        }

        for(int i=0;i<arr.length;i++){
            int a=1;
            int num=arr[i];

            while(num>1){
                int p=spf[num];
                int c=0;
                while(num%p==0){
                    num=num/p;
                    c++;
                }
                a=a*(c+1);
            }
            ans[i]=a;
        }


        return ans;
    }
}
