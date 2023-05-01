package DSA.journey.Array1d_1march;

import java.util.ArrayList;

public class Flip {

    public static void main(String[] args) {
        String s = "111";
        ArrayList<Integer> ans = new Flip().flip(s);
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
    }
    public ArrayList<Integer> flip(String s) {
        ArrayList<Integer> ans=new ArrayList<>();
        int cntZero=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='0'){
                cntZero++;
            }
        }
        if(cntZero==0){
            return ans;
        }

        int count=0;
        int l=-1;
        int r=-1;
        int lTemp=0;
        int maxCount=Integer.MIN_VALUE;
        for(int i=0;i<s.length();i++){

            if(s.charAt(i)=='0'){
                count++;
            }
            else if(s.charAt(i)=='1'){
                count--;
            }
            if(count>maxCount){
                maxCount=count;
                l=lTemp;
                r=i;
            }
            if(count<0){
                count=0;
                lTemp=i+1;
            }
        }
        ans.add(l+1);
        ans.add(r+1);
        return ans;
    }
    public ArrayList<Integer> flipWRONG(String s) {

        int cnt = 0;
        //int ans[] = new int[2];
        ArrayList<Integer> ans=new ArrayList<>();
        int start = -1;
        int end = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < s.length()-1; i++) {
            if (s.charAt(i) == '0') {
                int j = i + 1;
                while (j<s.length() && s.charAt(j) == '0') {
                    j++;
                }
                int temp = j - i;
                if (temp > max) {
                    max = j - i ;
                    start = i;
                    end = j;
                }
            }
        }

        if(start==-1 && end==-1){
            return ans;
        }
        else{
            if(max==1){
                start=end;
            }
            else{
                start++;
           //     end++;
            }
            ans.add(start);
            ans.add(end);
            return ans;
        }
    }
}
