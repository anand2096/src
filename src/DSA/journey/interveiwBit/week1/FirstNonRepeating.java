package DSA.journey.interveiwBit.week1;
import java.util.*;
public class FirstNonRepeating {

    public static void main(String[] args) {
       String s= "abadbcbccdc";

        System.out.println(new FirstNonRepeating().solve(s));
//        The expected return value:
//        jjjjjjjjjjjjjjjjjjjjjyyyyyyyyyyyyyyyyyyyyyyyyyyyqqqqq
//        Your function returned the following:
//        jjjjjjjjjjjjjjjjjjjjjyyyyyyyyyyyyyyyyyyyyyyyyyyyhhhhh
//        Test as custom input
    }
    public String solve(String s) {
        StringBuilder ans=new StringBuilder();

        Deque<Character> deque=new LinkedList<>();
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
            if(map.get(c)==1){
                deque.add(c);
            }
            else if(map.get(c)>1){
                if(!deque.isEmpty()){
                    deque.remove(c);
                    //map.remove(c);
                }
            }
            if(deque.isEmpty()){
                ans.append("#");
            }
            else{
                ans.append(deque.getFirst());
            }
        }
        return ans.toString();


    }
    public String solve2(String s) {
        StringBuilder ans=new StringBuilder();
        Deque<Character> que=new LinkedList<>();
        Map<Character,Integer> map=new HashMap<>();
        map.put(s.charAt(0),1);
        que.add(s.charAt(0));
        ans.append(s.charAt(0));
        for(int i=1;i<s.length();i++){
            char ch=s.charAt(i);
            if(map.containsKey(ch)){
                if(que.peek()==ch) {
                    que.remove();

                }
                while(map.get(que.peek())>1){
                    char c=que.peek();
                    que.remove();
                    map.put(c,map.get(c)-1);
                }
                que.add(ch);
                map.put(ch,map.get(ch)+1);
                if(que.isEmpty()){
                    ans.append('#');
                }
                else{
                    ans.append(que.peek());
                }
            }
            else{

                if(que.isEmpty()){
                    ans.append('#');
                }
                else{
                    ans.append(que.peek());
                }
                map.put(ch,1);
                que.add(ch);
            }
        }
        return ans.toString();
    }
}
