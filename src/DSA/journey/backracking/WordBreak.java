package DSA.journey.backracking;

import java.util.HashMap;
import java.util.Map;
import java.util.*;


class Node{
    Map<Character, Node> map=new HashMap<>();
    int pf=0;
    boolean isPresnt=false;

}
public class WordBreak {
    public static void main(String[] args) {
    String s="myinterviewtrainer";

    String arr[]={"interview","my","trainer"};
        System.out.println(new WordBreak().wordBreak(s,arr));
    }
//    public int wordBreak(String s, String[] arr) {
//        Map<String,Integer> map=new HashMap<>();
//        for(String st:arr){
//            map.put(st,0);
//        }
//        rec(0,0,s,map,s.length());
//        boolean flag=false;
//        for(Map.Entry<String,Integer> m:map.entrySet()){
//            if(m.getValue()>0){
//                flag=true;
//                break;
//            }
//        }
//        if(flag)return 1;
//        return 0;
//    }
//
//    public void rec(int start,int end,String s,Map<String,Integer> map,int n){
//        if(end>=n)return;
//
//
//        String sub=s.substring(start,end+1);
//        if(map.containsKey(sub)){
//            map.put(sub,map.get(sub)+1);
//            rec(end+1,end+1,s,map,n);
//        }
//        else{
//            rec(start,end+1,s,map,n);
//        }
//    }

    public int wordBreak(String s, String[] arr) {
        Node root=new Node();
        for(int i=0;i<arr.length;i++){
            Node curr=root;
            insert(curr,arr[i]);
        }


        Set<String> set=new HashSet<>();
        for(String st:arr){
            set.add(st);
        }
        StringBuilder sb=new StringBuilder(s);
        if( rec(0,sb,set,s.length(),root))return 1;
        return 0;
    }

    public boolean rec(int ind, StringBuilder s, Set<String> set, int n,Node root){
        if(ind>=n)return true;

        StringBuilder sub=new StringBuilder();
        for(int j=ind;j<s.length();j++){
            sub.append(s.charAt(j));
//            if(set.contains(sub.toString())){
//                if(rec(j+1,s,set,n,root)){
//                    return true;
//                }
//            }
            if(queryWord(root,sub.toString())){
                if(rec(j+1,s,set,n,root)){
                    return true;
                }
            }
        }
        return false;
    }
    public  void insert(Node root, String word){
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
    public  boolean queryWord(Node root, String w){
        Node curr=root;
        for(int i=0;i<w.length();i++){
            char ch=w.charAt(i);
            if(!curr.map.containsKey(ch)){
                return false;
            }else{
                curr=curr.map.get(ch);}

        }
        if(curr.isPresnt)return true;
        return false;

    }
    
}
