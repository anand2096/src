package DSA.Arrays;

public class ReverseInteger {
    public static void main(String[] args) {
        int n=123;
        System.out.println(new ReverseInteger().reverse(n));
    }

    public int reverse(int number) {

        long finalNumber=0;
        while(number!=0){
            int rem=number%10;
            finalNumber=finalNumber*10+rem;
            number=number/10;
        }


        if(number<0){
            return (int)(-1*finalNumber);
        }        if(finalNumber>Integer.MAX_VALUE || finalNumber<Integer.MIN_VALUE){
            return 0;
        }
        return (int) finalNumber;


    }

    public int reverseBrute(int number) {
        int tempNumber=Math.abs(number);
        int digits=(int)Math.log10(tempNumber)+1;
        int ans=0;
        int n=digits-1;
        if(digits==10){
            if(tempNumber%10>2){
                return 0;
            }
        }
        while(tempNumber>0){
            int rem=tempNumber%10;
           // System.out.println(Math.pow(10,n)*rem);
            ans=ans+(int)(Math.pow(10,n))*rem;
            n--;
            tempNumber=tempNumber/10;
            if(ans<0){
                return 0;
            }
        }
        if(ans<0){
            return 0;
        }

        if(number<0){
            ans=ans*-1;
        }
        return ans;


    }

}
