package DSA.journey.Trie;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class NodeRep{
    Map<Character,NodeRep> map=new HashMap<>();
    int pf=0;
    boolean isEnd=false;
}
public class ReplaceWord {
    public static void main(String[] args) {
        List<String> dict = Arrays.asList("a", "aa", "aaa", "aaaa");
        String sentence = "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa";
        //Output: "the cat was rat by the bat"
        System.out.println( new ReplaceWord().replaceWords(dict,sentence));
    }
    public String replaceWords(List<String> dict, String sentence) {

        NodeRep root=new NodeRep();
        //inserting dict word
        for(int i=0;i<dict.size();i++){
            insert(root,dict.get(i));
        }
        List<String> words= Arrays.asList(sentence.split(" "));
        for(int i=0;i<words.size();i++){
            words.set(i,replace(root,words.get(i)));

        }
        String ans=String.join(" ",words);
        return ans;

    }

    public String replace(NodeRep root, String word){
        NodeRep curr=root;
        String temp="";
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            if(curr.map.containsKey(ch)){
                temp=temp+ch;
                curr=curr.map.get(ch);
            }
            else{
                break;
            }
        }
        if(temp.length()==0){
            return word;
        }
        else if(temp.length()==word.length()){
            return String.valueOf(temp.charAt(0));
        }
        else if(curr.isEnd){
            return temp;
        }
        else{
            return word;
        }

    }

    public void insert(NodeRep root, String word){
        NodeRep curr=root;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            if(!curr.map.containsKey(ch)){
                NodeRep node=new NodeRep();
                curr.map.put(ch,node);
            }
            curr=curr.map.get(ch);
        }
        curr.isEnd=true;
    }
}
