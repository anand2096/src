package DSA.leetCodeDaily;

public class CountWaysTwoBuildGoodStrings {

    int count=0;

    public static void main(String[] args) {
       int low = 200, high = 200, zero = 10, one = 1;
        System.out.println(new CountWaysTwoBuildGoodStrings().countGoodStrings(low,high,zero,one));
    }
    public int countGoodStrings(int low, int high, int zero, int one) {

        String z="";
        for(int i=1;i<=zero;i++){
            z=z+"0";
        }
        String o="";
        for(int i=1;i<=one;i++){
            o=o+"1";
        }

        rec(low,high,z,o,""+z);
        rec(low,high,z,o,""+o);
        return count;

    }


    public void rec(int low,int high,String z,String o,String ans){
        if(ans.length()>high)return;
        if(ans.length()>=low && ans.length()<=high){

            count++;
            if(ans.length()+z.length()<=high){
                rec(low,high,z,o,ans+z);
            }
            if(ans.length()+o.length()<=high){
                rec(low,high,z,o,ans+o);
            }
            return;

        }
        if(ans.length()+z.length()<=high)
        rec(low,high,z,o,ans+z);
        if(ans.length()+o.length()<=high)
        rec(low,high,z,o,ans+o);

    }
}
