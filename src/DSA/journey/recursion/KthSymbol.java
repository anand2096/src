package DSA.journey.recursion;

public class KthSymbol {

    public static void main(String[] args) {
        int A = 2;
       int B = 2;
        System.out.println(new KthSymbol().solve(A,B));
    }


    public int solve(int n,int k) {
        if(n==1)return 0;
        int parent=solve(n-1,k/2+k%2);
        boolean isKOdd=k%2==1;
        if(parent==1){
            if(isKOdd)
                return 1;
            else return 0;
        }
        else{
            if(isKOdd) return 0;
            else return 1;
        }
    }
    public int solveTLE(int A, int B) {
        String s="0";
        if(B==1)return Character.getNumericValue(s.charAt(0));
        String ans=createString(A,1,s);
        return Character.getNumericValue(ans.charAt(B-1));
    }
    public String createString(int row,int current,String s){
        if(current==row)return s;

        for(int i=0;i<s.length();){
            if(s.charAt(i)=='0'){
                s=s.substring(0,i)+"01"+s.substring(i+1,s.length());
            }
            else if(s.charAt(i)=='1'){
                s=s.substring(0,i)+"10"+s.substring(i+1,s.length());
            }
            i+=2;
        }
       return createString(row,current+1,s);

    }
}
