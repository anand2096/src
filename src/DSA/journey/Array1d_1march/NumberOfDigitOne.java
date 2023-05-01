package DSA.journey.Array1d_1march;

import java.util.HashMap;
import java.util.Map;

public class NumberOfDigitOne {

    public static void main(String[] args) {
        int a = 826602;
        long startTime = System.currentTimeMillis();
        System.out.println(new NumberOfDigitOne().solve(a));
        long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime));
    }

    ///6191986
    //Total execution time: 273
    public int solve(int a) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();

        while(a>0){
            int prevCount=0;
            int temp=a;
                while (temp > 0) {
                    int rem = temp % 10;
                    if (rem== 1) {
                        count=count+1;
                    }
                    temp = temp / 10;
                }
            a--;
        }

//        while (a > 0) {
//            boolean flag = false;
//            int temp = a;
//            int subCount = 0;
//            int key = temp;
////            if(map.get(temp)!=null){
////                count=count+map.get(temp);
////            }
//
//            while (temp > 0) {
//                //boolean flag=false;
//                int rem = temp % 10;
//                if (rem == 1) {
//                    subCount = subCount + 1;
//                }
//
//                temp = temp / 10;
//                    if(map.get(temp)!=null &&map.get(temp)>0){
//                        count=count+map.get(temp);
//                        flag=true;
//                        break;
//                    }
//            }
//            if(!flag) {
//                if (subCount > 0)
//                    map.put(key, subCount);
//                count = count + subCount;
//            }
//
//            a--;
//        }

        return count;
    }
}
