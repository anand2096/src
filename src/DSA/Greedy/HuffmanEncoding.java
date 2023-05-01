package DSA.Greedy;


import java.util.Comparator;
import java.util.PriorityQueue;

class HuffmanNode{

    int data;
    char c;
    HuffmanNode left;
    HuffmanNode right;

}
class HuffmanComparator implements Comparator<HuffmanNode>{


    @Override
    public int compare(HuffmanNode o1, HuffmanNode o2) {
        return o1.data-o2.data;
    }
}
public class HuffmanEncoding {

    public static void main(String[] args) {
        // number of characters.
        int n = 6;
        char[] charArray = { 'a', 'b', 'c', 'd', 'e', 'f' };
        int[] charfreq = { 5, 9, 12, 13, 16, 45 };
        PriorityQueue<HuffmanNode> q=new PriorityQueue<HuffmanNode>(n,new HuffmanComparator());
        for(int i=0;i<n;i++){
            HuffmanNode hn=new HuffmanNode();
            hn.c=charArray[i];
            hn.data=charfreq[i];
            hn.left=null;hn.right=null;
            q.add(hn);
        }
        HuffmanNode root=null;
        while( q.size()>1){
            //first min extract
            HuffmanNode x=q.peek();
            q.poll();
            //second min extract

            HuffmanNode y=q.peek();
            q.poll();

            // new node f which is equal
            HuffmanNode f=new HuffmanNode();
            f.data=x.data+y.data;
            f.c='-';
            //first extracted node as left child
            f.left=x;
            //second extracted node as right child
            f.right=y;
            //marking the f node as the rood node
            root=f;
            //add this noode to the priority queue
            q.add(f);

        }
        printCode(root, "");
    }

    private static void printCode(HuffmanNode root, String s) {


        if(root.left==null&&root.right==null&&Character.isLetter(root.c)){
            System.out.println(root.c +" : "+s);
            return;
        }

        printCode(root.left,s+"0");
        printCode(root.right,s+"1");
    }
}
