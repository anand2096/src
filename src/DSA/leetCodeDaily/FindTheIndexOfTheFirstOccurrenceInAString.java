package DSA.leetCodeDaily;

import java.util.HashMap;
import java.util.Map;

public class FindTheIndexOfTheFirstOccurrenceInAString {


    public static void main(String[] args) {
       String s = "mississippi";
       String a = "mississippi";
        System.out.println(new FindTheIndexOfTheFirstOccurrenceInAString().strStr(s,a));
    }

    public int strStr(String s, String a) {

        if(a.length()>s.length()){
            return -1;
        }

        int ind=-1;
        int i=0;
        int j=0;
        int k=a.length();
        int n=s.length();
       // int count=;
        Map<Character,Integer> map=new HashMap<>();

        for(int t=0;t<a.length();t++){
            map.put(a.charAt(t),1);
        }
        int count=k;
        while(j<n){

            if(j-i+1<k){
            //2-0+1<k
                if(map.containsKey(s.charAt(j))){
                    map.put(s.charAt(j),map.get(s.charAt(j))-1);
                    if(map.get(s.charAt(j))==0)
                    count=count-1;
                    else if(map.size()==1){
                        count--;
                    }
                }
                j++;
            }
            else if(j-i+1==k){
                if( map.containsKey(s.charAt(j))){
                    map.put(s.charAt(j),map.get(s.charAt(j))-1);
                    if(map.get(s.charAt(j))==0)
                        count=count-1;
                    else if(map.size()==1){
                        count--;
                    }
                }

                if(count==0){
                    return i;
                }else{

                    if(map.containsKey(s.charAt(i))){
                        map.put(s.charAt(i),map.get(s.charAt(i))+1);
                        if(map.get(s.charAt(i))==1)
                            count=count+1;
                       // count++;
                    }
                    i++;
                    j++;
                }




            }


        }



        return ind;

    }
}
