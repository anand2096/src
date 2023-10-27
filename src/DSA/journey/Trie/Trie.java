//package DSA.journey.Trie;
//
//import java.util.HashMap;
//import java.util.Map;
//
//class Node{
//    Map<Character,Node> map=new HashMap<>();
//    int pf=0;
//
//}
//public class Trie {
//
//    public static void main(String[] args) {
//    String arr[] = {"data","draw","drew","dark","algorithm","stack","structure","struck","drake","damp","store","string",
//            "list","linked","link"
//            ,"stamp","sound","drunk","dried","almond","dark"};
//    String query[]={"st","li","dr","da","dat","dark","du"};
//        Node root=new Node();
//        for(int i=0;i<arr.length;i++){
//            Node curr=root;
//            insert(curr,arr[i]);
//        }
//        for(int i=0;i<query.length;i++){
//            System.out.println(query(root,query[i]));
//        }
//
//    }
//    public static void insert(Node root,String word){
//        Node curr=root;
//        for(int i=0;i<word.length();i++){
//            char ch= word.charAt(i);
//            if(!curr.map.containsKey(ch)){
//                Node node=new Node();
//                curr.map.put(ch,node);
//
//            }
//            curr=curr.map.get(ch);
//            curr.pf++;
//        }
//    }
//    public static int query(Node root,String w){
//        Node curr=root;
//        for(int i=0;i<w.length();i++){
//            char ch=w.charAt(i);
//            if(!curr.map.containsKey(ch)){
//                return 0;
//            }
//            curr=curr.map.get(ch);
//
//        }
//        return curr.pf;
//    }
//
//}
