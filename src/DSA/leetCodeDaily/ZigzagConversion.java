package DSA.leetCodeDaily;

import java.util.ArrayList;
import java.util.List;

public class ZigzagConversion {
    public static void main(String[] args) {
        System.out.println(new ZigzagConversion().convert("PAYPALISHIRING", 4));

    }

    public String convert(String s, int numRows) {
        String ans="";
        String temp="";
        List<List<Character>> list = new ArrayList<>();
        for (int j = 0; j < numRows; j++) {
            list.add(new ArrayList<>());
        }

        int currIndex = 0;
        while (currIndex < s.length()) {
            int i = 0;
            while (currIndex<s.length()&&i < numRows) {
                list.get(i).add(s.charAt(currIndex));
                temp=temp+s.charAt(currIndex);
                i++;
                currIndex++;
            }

            int midColIndex = i - 2;
            while (currIndex<s.length()&& midColIndex >= 1) {
                list.get(midColIndex).add(s.charAt(currIndex));
                temp=temp+s.charAt(currIndex);
                midColIndex--;
                currIndex++;
            }


        }
        for(int a=0;a<list.size();a++){
            List<Character> iList=list.get(a);
            for(int b=0;b<iList.size();b++){
                ans=ans+iList.get(b);
            }
        }
        System.out.println(temp);
        System.out.println(ans);
        return ans;
    }
}
