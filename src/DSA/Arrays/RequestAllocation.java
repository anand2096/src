package DSA.Arrays;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class RequestAllocation {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        int r=kb.nextInt();
        List<int []> inps=new ArrayList<>();
        for(int i=0;i< n;i++){
            int a[]=new int[r];
            a[0]= kb.nextInt();
            a[1]= kb.nextInt();
            inps.add(a);
        }
        Set<Integer>sets=new HashSet<>();

        for(int i=1;i<=n+1;i++){
            sets.add(i);
        }
        Set<Set<Integer>> powerSets=powerSet(sets);
        for(int i=0;i<inps.size();i++){

            int a[]=inps.get(i);

        }


    }

    public static Set<Set<Integer>> powerSet(Set<Integer> originalSet) {
        Set<Set<Integer>> sets = new HashSet<Set<Integer>>();
        if (originalSet.isEmpty()) {
            sets.add(new HashSet<Integer>());
            return sets;
        }
        List<Integer> list = new ArrayList<Integer>(originalSet);
        Integer head = list.get(0);
        Set<Integer> rest = new HashSet<Integer>(list.subList(1, list.size()));
        for (Set<Integer> set : powerSet(rest)) {
            Set<Integer> newSet = new HashSet<Integer>();
            newSet.add(head);
            newSet.addAll(set);
            sets.add(newSet);
            sets.add(set);
        }
        return sets;
    }


}
