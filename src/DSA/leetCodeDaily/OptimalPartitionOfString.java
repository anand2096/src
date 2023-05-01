package DSA.leetCodeDaily;

import java.util.HashMap;
import java.util.Map;

public class OptimalPartitionOfString {

    public static void main(String[] args) {
        String s="abacaba";
        System.out.println(new OptimalPartitionOfString().partitionStringBRUTE(s));
    }
    public int partitionString(String s) {
        int partition=1;
        int n=s.length();
        int j=0;
        int flag=0;
        while(j<n){
            int c=(s.charAt(j)-'a');
            if((flag &(1<<c)) >=1){
                partition++;
                flag=0;
            }
            flag=flag|(1<<c);
            j++;

        }


        return partition;
    }
    public int partitionStringBRUTE(String s) {
        int partition=0;
        int n=s.length();
        int j=0;
        Map<Character,Integer> map=new HashMap<>();
       // String temp="";
        while(j<n){
            if(map.containsKey(s.charAt(j))){
                partition++;
                map.clear();
                //temp="";
             //   temp=temp+String.valueOf(s.charAt(j));
                map.put(s.charAt(j),1);

            }
            else{
                map.put(s.charAt(j),1);
              //  temp=temp+String.valueOf(s.charAt(j));
            }
            j++;
        }
        if(map.size()>0){
            partition++;
        }

        return partition;
    }
}
