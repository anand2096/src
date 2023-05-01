package DSA.journey.BitManipulation;

import DSA.CommonFun;

import java.util.List;

public class SingleNumber {

    public static void main(String[] args) {

        int a[]={1, 2, 2, 3, 1};
        System.out.println(new SingleNumber().singleNumber(CommonFun.createInput(a)));

    }

    public int singleNumber(final List<Integer> list) {
        int ans=0;
        for(int i=0;i<list.size();i++){
            ans=ans^list.get(i);
        }
        return ans;


    }
}
