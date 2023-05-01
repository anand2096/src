package DSA.journey.prime;

public class NumberOfOpenDoors {

    public static void main(String[] args) {
        System.out.println(new NumberOfOpenDoors().solve2(9087738));
    }

//    public int solve(int num) {
//        int ans=0;
//        boolean spf[]=new boolean[num+1];
////        for(int i=1;i<spf.length;i++){
////            spf[i]=true;
////        }
//
//        for(int i=1;i<=num;i++){
//         //   spf[i]=!spf[i];
//            for(int j=i;j<=num;j+=i){
//                spf[j]=!spf[j];
//            }
//        }
//        for(int i=1;i<=num;i++){
//            if(spf[i]){
//                ans++;
//            }
//        }
//        return ans;
//    }


    public int solve2(int num) {
        int ans=0;
        int spf[]=new int[num+1];
        for(int i=2;i<=num;i++){
                spf[i]++;
            for(int j=i*2;j<=num;j+=i){
                spf[j]++;

            }
        }
        for(int i=1;i<=num;i++){
            if(spf[i]%2==0)
                ans++;
        }
        return ans;

    }

    public int solve(int num) {
        int ans=0;

        int spf[]=new int[num+1];
        //calculating SPF

        for(int i = 1; i <= num; i++)
            spf[i] = i;
        for(int i=2;i*i<=num;i++){
            if(spf[i]!=i)
                continue;
            for(int j=i*i;j<=num;j+=i){
                if(spf[j]==j)
                {spf[j]=i;}

            }
        }

        for(int i=2;i<=num;i++){
            int temp=i;
            int a=1;
            while(temp>1){
                int p=spf[temp];
                int c=0;
                while(temp%p==0){
                    temp=temp/p;
                    c++;
                }
                a=a*(c+1);
            }
           if(a%2!=0){
               ans++;
           }
        }


        return ans+1;
    }
}
