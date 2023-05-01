package DSA.leetCodeDaily;

public class CountOddNumbersInAnIntervalRange {
    public static void main(String[] args) {
        int low=21; int high=22;
        System.out.println(new CountOddNumbersInAnIntervalRange().countOdds(low,high));

    }
    public int countOdds(int low, int high) {
        int cnt=0;
        int n=high-low+1;

        if(low%2!=0 &&high%2!=0){
            cnt=n-(n/2);
        }
        if((low%2==0&&high%2!=0)||(low%2!=0&&high%2==0)){
            cnt=n-(n/2);
        }
        if(low%2==0&&high%2==0){
            cnt=n-(n/2)-1;
        }
return cnt;
    }
}
