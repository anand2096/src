package DSA.journey.BitManipulation;

import DSA.CommonFun;

import java.util.List;

public class SingleNumber2 {

    public static void main(String[] args) {
        int a[]={1, 2, 4, 3, 3, 2, 2, 3, 1, 1};
        System.out.println(new SingleNumber2().singleNumber(CommonFun.createInput(a)));

    }
    public int singleNumber(final List<Integer> list) {
        int ans=0;
        for(int i=0;i<31;i++){
            int cnt=0;
            for(int j=0;j<list.size();j++){
                if(checkSetBit(list.get(j),i)){
                    cnt++;
                }
            }
            if(cnt%3!=0){
                ans=ans+(int)Math.pow(2,i);
            }

        }
    return ans;

    }
    public boolean checkSetBit(int n,int index){

        return (((n>>index)&1)==1);
    }
}
