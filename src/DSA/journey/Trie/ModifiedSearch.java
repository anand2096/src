package DSA.journey.Trie;

public class ModifiedSearch {
    public static void main(String[] args) {
        String A []= {"data", "circle", "cricket"};
        String B[] = {"date", "circel", "crikket", "data", "circl"};
        System.out.println(new ModifiedSearch().solve(A,B));
    }
    public String solve(String[] s, String[] query) {

        Node root=new Node();
        for(int i=0;i<s.length;i++){
            insert(root,s[i]);
        }
        String ans="";
        for(int i=0;i<query.length;i++){
            int t=search(root,query[i]);
            ans=ans+t;
        }
        return ans;

    }
    public static int search(Node root,String word){
        Node curr=root;
        int i;
        for(i=0;i<word.length();i++){
            char ch=word.charAt(i);
            if(curr.map.containsKey(ch)){
                curr=curr.map.get(ch);
            }
            else{
                break;
            }
        }
        if(i==word.length())return 0;
        int n=word.length();
        i++;

        if(i==word.length())return 1;
        for(char c:curr.map.keySet()){
            Node temp=curr.map.get(c);
            if(temp.map.containsKey(word.charAt(i))){
                while(i<n) {
                    if (temp.map.containsKey(word.charAt(i))) {
                        temp = temp.map.get(word.charAt(i));
                        i++;
                    } else {
                        break;
                    }
                }
                if(i==n){
                    return 1;
                }
            }
        }

    return 0;
    }

    public static void insert(Node root,String word){
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
}
