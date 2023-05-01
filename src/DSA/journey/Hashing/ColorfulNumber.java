package DSA.journey.Hashing;

import java.util.*;

public class ColorfulNumber {

    public static void main(String[] args) {
        int number =234;
        System.out.println(new ColorfulNumber().colorful(number));
    }
    public int colorful(int number)
    {
        int ans=1;
        Set<Integer> set=new HashSet<>();
        List<Integer> list=new ArrayList<>();
        int temp=number;
        while(temp>0){
            list.add(temp%10);
            temp=temp/10;
        }
        Collections.reverse(list);
        int productPrefix[]=new int[list.size()];
        productPrefix[0]=list.get(0);
        for(int i=1;i<list.size();i++){
            productPrefix[i]=productPrefix[i-1]*list.get(i);
        }
        for(int i=0;i<productPrefix.length;i++){
            for(int j=i;j<productPrefix.length;j++){
                int seqProduct=1;
                if(i-1>=0) {
                     seqProduct = productPrefix[j] / productPrefix[i - 1];
                }
                else{
                    seqProduct = productPrefix[j];
                }
                if(set.contains(seqProduct)){
                    return 0;
                }
                else{
                    set.add(seqProduct);
                }
            }
        }

        return ans;

    }
}
