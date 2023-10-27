package DSA.journey.Trie;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class NodeLex{
    int number;

    Map<String,NodeLex> map=new HashMap<>();
    int pf=0;
    boolean isPresent=false;
}
public class LexicographicalNumbers {
    public static void main(String[] args) {
        System.out.println(new LexicographicalNumbers().lexicalOrder(13));
    }
    public List<Integer> lexicalOrder(int n) {
        NodeLex root=new NodeLex();
        for(int i=1;i<=n;i++){
            insert(i,root);
        }

    return null;
    }

    public void insert(int no, NodeLex root){
        NodeLex curr=root;
        char ch=String.valueOf(no).charAt(0);
        for(Map.Entry<String,NodeLex> m:curr.map.entrySet()){
            String key=m.getKey();
            if(key.charAt(0)==ch){
                curr=curr.map.get(key);
                break;
            }
        }
        if(curr==root){
            NodeLex newNode=new NodeLex();
            curr.map.put(String.valueOf(no),newNode);
        }
        else{
            while(curr.map.size()>0){
                curr=curr.map.get(ch);
            }
            NodeLex newNode=new NodeLex();
            curr.map.put(String.valueOf(no),newNode);
        }


    }
}
