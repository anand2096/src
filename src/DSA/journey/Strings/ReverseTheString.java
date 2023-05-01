package DSA.journey.Strings;

public class ReverseTheString {

    public static void main(String[] args) {

    }
    public String solve(String s) {
        String[] arr=s.split(" ");
        String ans="";
        for(int i=arr.length-1;i>=0;i--){
            if(i==0){
                ans=ans+arr[i];
            }
            else{
                ans=ans+arr[i]+" ";
            }
        }
        return ans;
    }
}
