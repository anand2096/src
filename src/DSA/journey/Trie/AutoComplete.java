package DSA.journey.Trie;
import java.lang.*;
import java.util.*;
class NodeAuto{
    Map<Character,NodeAuto> map=new HashMap<>();
    int pf=0;
    boolean isPresnt=false;
    List<Integer> index=new ArrayList<>();

}
class Pair{
    public String st;
    public int wt;
    public Pair(String st,int wt){
        this.st=st;
        this.wt=wt;
    }
}

public class AutoComplete {

    public static void main(String[] args) {
        Scanner kb=new Scanner(System.in);
        int t=kb.nextInt();
        while(t>0){
            int n=kb.nextInt();
            int m=kb.nextInt();

            //taking words as inputs
            String s[]=new String[n];
            for(int i=0;i<n;i++){
                s[i]=kb.next();
            }
            // taking wts as input
            int wt[]=new int[n];
            for(int i=0;i<n;i++){
                wt[i]=kb.nextInt();
            }

            // taking prefix as input
            String []prefix=new String[m];
            for(int i=0;i<m;i++){
                prefix[i]=kb.next();
            }

            // creating pair of word to wt
            List<Pair> input=new ArrayList<>();
            for(int i=0;i<s.length;i++){
                input.add(new Pair(s[i],wt[i]));
            }
            Collections.sort(input,(i1,i2)->i2.wt-i1.wt);


            //building Trie
            NodeAuto root=new NodeAuto();
            for(int i=0;i<input.size();i++){
                insert(root,input.get(i).st,i);
            }

            //query a prefix
            for(int i=0;i<m;i++){
                query(prefix[i],root,input);
            }
            t--;
        }


    }

    public static void query(String pre, NodeAuto root,List<Pair>input){
        NodeAuto curr=root;
        Map<Integer,String> wtToString=new HashMap<>();
        String temp="";
        int i;
        for(i=0;i<pre.length();i++){
            char ch=pre.charAt(i);
            if(curr.map.containsKey(ch)){
                curr=curr.map.get(ch);
            }
            else{
                break;
            }
        }
        List<Integer>ind=curr.index;
        if(i!=pre.length()){
            System.out.println("-1");
        }
        else{
            for( i=0;i<ind.size();i++){
                int index=ind.get(i);
                System.out.print(input.get(index).st+" ");
            }
            System.out.println("");
        }


    }

    public static void insert(NodeAuto root, String word,int index){
        NodeAuto curr=root;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            if(!curr.map.containsKey(ch)){
                NodeAuto NodeAuto=new NodeAuto();
                curr.map.put(ch,NodeAuto);
            }
            curr=curr.map.get(ch);
            if(curr.index.size()<5){
                curr.index.add(index);
            }

            curr.pf++;
        }
        curr.isPresnt=true;

    }

}
