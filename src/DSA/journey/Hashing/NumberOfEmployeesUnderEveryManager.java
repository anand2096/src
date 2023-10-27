package DSA.journey.Hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
//        A C
//        B C
//        C F
//        D E
//        E F
//        F F
public class NumberOfEmployeesUnderEveryManager {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        HashMap<String, List<String>> map=new HashMap<>();
        for(int i=1;i<=n;i++){
            String s="";
            System.out.println(s);
            String arr[]=s.split("");
            if(!map.containsKey(arr[1])){
                map.put(arr[1],new ArrayList<String>());
            }
            List<String> temp=map.get(arr[1]);
            temp.add(arr[0]);
            map.put(arr[1],temp);
        }
        System.out.println(map);
    }

}
