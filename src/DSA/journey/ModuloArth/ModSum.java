package DSA.journey.ModuloArth;

public class ModSum {

    public static void main(String[] args) {
        int []a={1,2,3};
        System.out.println(new ModSum().solve(a));
    }
    public int solve(int[] a) {
        int mod=1000000009;
        int ans=0;
        int n=a.length;

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                ans=(ans+(a[i]%a[j]))%mod;
                ans=(ans+(a[j]%a[i]))%mod;
            }
        }
        return ans;
//        int max = Arrays.stream(a).max().getAsInt();
//
//        // To store the frequency of each element
//        long []cnt=new long[max + 1];
//
//        // Store the frequency of each element
//        for (int i = 0; i < n; i++)
//            cnt[a[i]]++;
//
//        // To store the required answer
//        long ans = 0;
//
//        // For all valid pairs
//        for (int i = 1; i <= max; i++)
//        {
//            for (int j = 1; j <= max; j++)
//            {
//
//                // Update the count
//                ans = (ans +( (cnt[i]) * (cnt[j] * (i % j)) )%mod  )%mod;
//                ans = ans % mod;
//            }
//        }

      //  return (int)(ans%mod);
    }



}

