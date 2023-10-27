import java.util.*;


public class Test2 {
    static int ans;

    public static void main(String[] args) {

        String s="beedcface";
        int k=4;
        System.out.println(new Test2().solve(s,k));
    }
    public int solve(String s, int k) {
        if(k==0)return 0;
        int i=0;
        int j=0;
        int n=s.length();
        int len=Integer.MIN_VALUE;
        Map<Character,Integer> map=new HashMap<>();
        while(j<n){

            if(map.size()<=k){

                char ch=s.charAt(j);

                map.put(ch,map.getOrDefault(ch,0)+1);

                j++;
            }     if(map.size()<=k){
                len=Math.max(len,(j-i+1));
            }
            else{
                while(map.size()>k){
                    char c=s.charAt(i);
                    map.put(c,map.get(c)-1);
                    if(map.get(c)==0){
                        map.remove(c);
                    }
                    i++;
                }

            }
        }
        return len;
    }

}
