package DSA.journey.Hashing;

import java.util.HashMap;
import java.util.Map;

public class IntegerToRoman {

    public String intToRoman(int num) {
        String roman="";
        int  []value={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String []key={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        for(int pos=0;num>0;pos++){
            while(num>=value[pos]){
                roman=roman+key[pos];
                num=num-value[pos];
            }
        }
        return roman;
    }
    public String intToRomanBrute(int num) {

        int len = (int) (Math.log10(num) + 1);
        Map<Integer,String> map=new HashMap<>();
        map.put(1,"I");
        map.put(2,"II");
        map.put(3,"III");
        map.put(5,"V");
        map.put(6,"VI");
        map.put(7,"VII");
        map.put(8,"VIII");
        map.put(10,"X");
        map.put(50,"L");
        map.put(100,"C");
        map.put(500,"D");
        map.put(1000,"M");
        map.put(4,"IV");
        map.put(9,"IX");
        map.put(40,"XL");
        map.put(90,"XC");
        map.put(400,"CD");
        map.put(900,"CM");
        String ans="";
        while(num>0){
            int p=(int)(Math.pow(10,len-1));
            int rem=num%p;
            int div=num/p;
            if(map.containsKey(div*p))
                ans=ans+map.get(div*p);
            else{
                String t="";
                while(!map.containsKey(div*p)){
                    t=map.get(p)+t;
                    num=num-p;
                    rem=num%p;
                    div=num/p;
                }
                t=map.get(div*p)+t;

                ans=ans+t;

            }
            num=rem;
            len=(int) (Math.log10(num) + 1);

        }
        return ans;
    }
}