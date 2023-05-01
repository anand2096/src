package DSA.journey.BitManipulation;

public class NumberOf1Bits {
    public static void main(String[] args) {

        int a=6;
        System.out.println(new NumberOf1Bits().numSetBits(a));
    }

    public int numSetBits(int number) {

        int ans=0;
        for(int i=0;i<31;i++){
            if(checkSetBit(number,i)){
                ans++;
            }
        }
        return ans;

    }

    public boolean checkSetBit(int n,int index){

        return (((n>>index)&1)==1);
    }
}
