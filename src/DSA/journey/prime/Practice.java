package DSA.journey.prime;

public class Practice {
    public static void main(String[] args) {
        calculatePrintPrimeTillN(50);
    }

    public static void calculatePrintPrimeTillN(int n){
        boolean [] prime=new boolean[n+1];
        int [] spf=new int[n+1];
        for(int i=0;i<spf.length;i++){
            spf[i]=i;
        }

        prime[0]=false;
        prime[1]=false;
        for(int i=2;i<=n;i++){
            prime[i]=true;
        }

        for(int i=2;i*i<=n;i++){
            if(prime[i]){
                for(int j=i*i;j<=n;j=j+i){
                    if(prime[j]) {
                        prime[j] = false;
                        spf[j]=i;
                    }
                }
            }
        }
        for(int i=2;i<spf.length;i++){
            System.out.println(i+","+spf[i]);
        }
        System.out.println("");
        for(int i=2;i<=n;i++){
            if(prime[i]){
                System.out.print(i+" ");
            }
        }


    }
}
