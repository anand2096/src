package DSA.Arrays;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class test {


    {index=1;}
    int index;

    public static void main(String[] args) {

        Map<String,Integer> map=new HashMap<>();

        String arr[]={"a@gmail.com","b@hotmail.com","c@gmail.com","d@abc.com"};
        for(int i=0;i<arr.length;i++){


            int index1=arr[i].indexOf("@");
            int index2=arr[i].indexOf(".");
            String subs=arr[i].substring(index1+1,index2);

            if(map.containsKey(subs)){

                map.put(subs,map.get(subs)+1);
            }
            else
            {
                map.put(subs,1);
            }


        }

        Map<String, Integer> hm1 = sortByValue(map);

        // print the sorted hashmap
        for (Map.Entry<String, Integer> en : hm1.entrySet()) {
            System.out.println( en.getKey() +"-"
                    + en.getValue());
        }



    }
    public static HashMap<String, Integer> sortByValue(Map<String, Integer> hm)
    {

        List<Map.Entry<String, Integer> > list =
                new LinkedList<Map.Entry<String, Integer> >(hm.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2)
            {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
}
