package DSA.Greedy;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class PageFaultsInLRU {
    public static void main(String[] args) {
        int c = 4;
        int[] pages = {7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2};
        System.out.println(new PageFaultsInLRU().pageFaults(pages.length,c,pages));

    }

     int pageFaults(int n, int capacity, int pages[]) {
        // code here
        int pageFaults=0;
        Deque<Integer> queue=new LinkedList<>();
        for(int i=0;i<n;i++){
            int page=pages[i];
            if(queue.contains(page)){

                queue.remove(page);
                queue.addFirst(page);
            }
            else{
                if(queue.size()!=capacity){
                    queue.addFirst(page);
                }else{
                    queue.removeLast();
                    queue.addFirst(page);
                }
                pageFaults++;
            }
        }



        return pageFaults;
    }
}
