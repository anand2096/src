package DSA.journey.BitManipulation;

public class StrangeEquality {
    public static void main(String[] args) {
        int a=5;
        System.out.println(~a);
        System.out.println(new StrangeEquality().solve(a));
    }

    public int solve(int number) {
        int greatestSmaller=0;
        int smallestGreater=0;
        int onePosition=-1;
        for(int i=30;i>=0;i--){
            if(checkSetBit(number,i)){
                onePosition=i;
                break;
            }
        }

        for(int i=onePosition-1;i>=0;i--){
            if(!checkSetBit(number,i)){
                greatestSmaller=greatestSmaller+(1<<i);
            }
        }
        smallestGreater=smallestGreater+(1<<(onePosition+1));


        return smallestGreater^greatestSmaller;

    }


    public boolean checkSetBit(int number,int index){
        return (((number>>index)&1)==1);
    }
}
