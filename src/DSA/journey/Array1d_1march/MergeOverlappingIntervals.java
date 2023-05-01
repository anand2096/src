package DSA.journey.Array1d_1march;

import java.util.ArrayList;
import java.util.Collections;

public class MergeOverlappingIntervals {

    public static void main(String[] args) {

        ArrayList<Interval> inp=new ArrayList<>();
        inp.add(new Interval(1,3));
        inp.add(new Interval(2,6));
        inp.add(new Interval(8,10));
        inp.add(new Interval(15,18));

        ArrayList<Interval> list= new MergeOverlappingIntervals().merge(inp);
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i).start+" , "+list.get(i).end);
        }

    }

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        Collections.sort(intervals,(i1,i2)->i1.start-i2.start);
        ArrayList<Interval> ans=new ArrayList<>();
        Interval current=intervals.get(0);
        for(int i=1;i<intervals.size();i++){
            Interval newInterval=intervals.get(i);
            if(current.end<newInterval.start){
                ans.add(current);
                current=newInterval;
            }
            else{
                current.start=Math.min(current.start,newInterval.start);
                current.end=Math.max(current.end,newInterval.end);
            }

        }
        ans.add(current);
        return ans;
    }
}
