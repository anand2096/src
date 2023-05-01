package DSA.leetCodeDaily;

import java.util.ArrayList;
import java.util.List;

public class RestoreTheArray {
    int ans=0;
    List<List<Integer>> temp=new ArrayList<>();
    public static void main(String[] args) {
        String s="1234567890";
        int k=90;
        System.out.println(new RestoreTheArray().numberOfArrays(s,k));

    }
    public int numberOfArrays(String s, int k) {
        int n=s.length();
        rec(0,s,new ArrayList<Integer>(),k);
        System.out.println(temp);
        return ans;
    }

    private void rec(int index, String s, ArrayList<Integer> integers, int k) {
        if(index>=s.length()){

            temp.add(new ArrayList<>(integers));
            System.out.println(temp);
            boolean flag=true;
            for(int j=0;j<integers.size();j++){
                if(integers.get(j)<k && integers.get(j)>=1){
                    continue;
                }
                else{
                    flag=false;
                }
            }
            if(flag)
            ans++;
            return;
        }

            //return;
        for(int i=index+1;i<=s.length();i++){
            int no=Integer.parseInt(s.substring(index,i));
            if(no>=1&&no<k)
            {   integers.add(no);
                rec(i,s,integers,k);
                integers.remove(integers.size()-1);
            }
            else{
                break;
            }

        }

    }


}
