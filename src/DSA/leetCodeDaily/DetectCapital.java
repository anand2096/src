package DSA.leetCodeDaily;

public class DetectCapital {

    public static void main(String[] args) {
String s="Amazon";
        System.out.println(new DetectCapital().detectCapitalUse(s));
    }
    public boolean detectCapitalUse(String word) {
        int cnt=0;
        char[] arr=word.toCharArray();
        for(int i=0;i<arr.length;i++){
            if(arr[i]>=65&&arr[i]<=90){
                cnt++;
            }
        }
        if(cnt==word.length())return true;
        else if(cnt==1&&(arr[0]>=65&&arr[0]<=90))return true;
        else if(cnt==0) return  true;
        else return false;

    }
}
