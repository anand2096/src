package DSA.journey.combinatorics;

public class ExcelColumnNumber {

    public static void main(String[] args) {
        String s="AB";
        System.out.println(new ExcelColumnNumber().titleToNumber(s));
    }
    public int titleToNumber(String s) {
        int j=0;
        int ans=0;
        for(int i=s.length()-1;i>=0;i--){

            int t=s.charAt(i)-'A'+1;
            ans=ans+t*(int)(Math.pow(26,j));
            j++;

        }

        return ans;
    }

}
