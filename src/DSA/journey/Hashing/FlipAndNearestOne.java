package DSA.journey.Hashing;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;


// 1 2 3

public class FlipAndNearestOne {

    public static void main(String[] args) {
      String  A = "101110100";

        int [][]B = {{1, 2}, {2, 7}, {1, 7},{2,5},{1,2},{1,9},{2,7},{2,7},{2,5}};
//7 5 5 5 5
      int ans[]=new FlipAndNearestOne().solve(A,B);
      for(int i=0;i<ans.length;i++){
          System.out.print(ans[i]+" ");
      }
    }
    //7 5 5 5 5
    public int[] solve(String s, int[][] queries) {
        List<Integer> ans=new ArrayList<>();
        TreeSet<Integer> set= new TreeSet<>();
        for(int i=0;i<s.length();i++){
            int a=Integer.parseInt(String.valueOf(s.charAt(i)));
            if(a==1){
                set.add(i);
            }
        }
        //4 1 4
        //{{1, 3}, {1, 3}, {2, 4},{2,2},{1,1},{2,3},{1,5},{1,5}};
        //{{1, 2}, {2, 7}, {1, 7},{2,5},{1,2},{1,9},{2,7},{2,7},{2,5}};
        StringBuilder sb=new StringBuilder(s);
        for(int i=0;i<queries.length;i++){
            int [] q=queries[i];
            int second=q[1];
            if(q[0]==1){

                if(s.charAt(second-1)=='1'){
                    s=s.substring(0,second-1)+"0"+s.substring(second);
                   // sb.replace(second-1,second,"0");
                    if(set.contains(second-1)){
                        set.remove(second-1);
                    }
                }
                else{
                    s=s.substring(0,second-1)+"1"+s.substring(second);
                //    sb.replace(second-1,second,"1");
                    set.add(second-1);
                }
            }
            else{
                if(set.contains(second-1))
                    ans.add(second);
                else {
                  //  int temp = set.tailSet(second - 1).first();
                    Integer lower=set.lower(second-1);
                    Integer higher=set.higher(second-1);
                    if(lower==null &&higher==null){
                        ans.add(-1);
                    }
                    else if(lower==null){
                        ans.add(higher+1);
                    }
                    else if(higher==null){
                        ans.add(lower+1);
                    }
                    else {
                        if (Math.abs((second - 1) - lower) <= Math.abs(higher - (second - 1))) {
                            ans.add(lower+1);
                        } else {
                            ans.add(higher+1);
                        }
                    }

                }
            }

        }
        int arrAns[]=new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            arrAns[i]=ans.get(i);
        }
       // System.out.println(ans);
        return arrAns;
    }
}
