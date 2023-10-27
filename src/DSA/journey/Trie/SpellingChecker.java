package DSA.journey.Trie;

import java.util.HashMap;
import java.util.Map;

class Node{
    Map<Character,Node> map=new HashMap<>();
    int pf=0;
    boolean isPresnt=false;

}
public class SpellingChecker {

    public static void main(String[] args) {
    String arr[]={"ab","abc","abcd","abcde","abcdef","abcdefg"};
    String query[]={"a","b","ab","abcd"};
    int ans[]=new SpellingChecker().solve(arr,query);
    for(int i=0;i<ans.length;i++){
        System.out.print(ans[i]+" ");
    }
    }
    public int[] solve(String[] words, String[] query) {
        Node root=new Node();
        for(int i=0;i<words.length;i++){
            Node curr=root;
            insert(curr,words[i]);
        }
        int ans[]=new int[query.length];
        for(int i=0;i<query.length;i++){
            if(queryWord(root,query[i])>0){
                ans[i]=1;
            }
            else{
                ans[i]=0;
            }
        }
        return ans;

    }

    public static void insert(Node root,String word){
        Node curr=root;
        for(int i=0;i<word.length();i++){
            char ch= word.charAt(i);
            if(!curr.map.containsKey(ch)){
                Node node=new Node();
                curr.map.put(ch,node);

            }
            curr=curr.map.get(ch);

            curr.pf++;
        }
        curr.isPresnt=true;
    }
    public static int queryWord(Node root,String w){
        Node curr=root;
        for(int i=0;i<w.length();i++){
            char ch=w.charAt(i);
            if(!curr.map.containsKey(ch)){
                return 0;
            }else{
            curr=curr.map.get(ch);}

        }
        if(curr.isPresnt)return 1;
        return 0;

    }
}
