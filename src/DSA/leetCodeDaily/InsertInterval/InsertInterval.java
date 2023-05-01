package DSA.leetCodeDaily.InsertInterval;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Pair {


    int start;
    int end;

    Pair(int start, int end) {
        this.start = start;
        this.end = end;
    }
}


public class InsertInterval {

    public static void main(String[] args) {
        int[][] intervals = {{1,5}};
        int[] newInterval = {2, 7};
//        int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
//        int[] newInterval = {4,8};
        int[][] response = new InsertInterval().insert(intervals, newInterval);

    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length==0){
            if(newInterval.length==0)
                return new int[0][0];
            else {
                int response[][]=new int [1][2];
                response[0][0]=newInterval[0];
                response[0][1]=newInterval[1];
                return  response;
            }
        }
        Pair newPair = new Pair(newInterval[0], newInterval[1]);
        List<Pair> pairList = new ArrayList<>();

        boolean done=false;
        for (int i = 0; i < intervals.length; i++) {
            Pair addPair = new Pair(intervals[i][0], intervals[i][1]);
            if (newPair.start < addPair.start && !done) {
                pairList.add(newPair);
                done=true;
            }
                pairList.add(new Pair(intervals[i][0], intervals[i][1]));

        }
        if(!done){
            pairList.add(newPair);
        }
        Stack<Pair> stack=new Stack<>();
        stack.add(pairList.get(0));

        for(int i=0;i<pairList.size();i++){
            Pair peek=stack.peek();
            Pair pair=pairList.get(i);
            if(pair.start<=peek.end){
                Pair popped =stack.pop();
                Pair insertPair=new Pair(popped.start,popped.end>pair.end?popped.end:pair.end);
                stack.push(insertPair);
            }
            else{
                stack.push(pair);
            }
        }

        int [][]ans =new int[stack.size()][2];
        int i=stack.size()-1;
        while(!stack.isEmpty()){
            Pair popped=stack.pop();
            ans[i][0]=popped.start; ans[i][1]=popped.end;
            i--;
        }

        return ans;
    }
}
