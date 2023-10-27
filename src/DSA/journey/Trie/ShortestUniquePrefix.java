package DSA.journey.Trie;

public class ShortestUniquePrefix {
    public static void main(String[] args) {
        String arr[]={"zebra","dog","duck","dot"};

        String ans[]=new ShortestUniquePrefix().prefix(arr);
        for(int i=0;i<ans.length;i++){
            System.out.print(ans[i]+" ");
        }
    }
    public String[] prefix(String[] arr) {
        Node root=new Node();
        String[] ans=new String[arr.length];
        for(int i=0;i<arr.length;i++){
            Node curr=root;
            insert(curr,arr[i]);
        }
        for(int i=0;i<arr.length;i++){
            ans[i]=search(root,arr[i]);
        }
        return ans;
    }
    public void insert(Node root,String word){
        Node curr=root;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            if(!curr.map.containsKey(ch)){
                Node node=new Node();
                curr.map.put(ch,node);
            }
            curr=curr.map.get(ch);
            curr.pf++;
        }
    }
    public String search(Node root,String s){
        String ans="";
        Node curr=root;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            ans=ans+ch;
            curr=curr.map.get(ch);
            if(curr.pf<=1){
                break;
            }

        }
        return ans;

    }
}
