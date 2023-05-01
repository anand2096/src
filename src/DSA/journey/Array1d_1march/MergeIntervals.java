package DSA.journey.Array1d_1march;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


class Interval{
    int start;
    int end;
    Interval(int start,int end){
        this.start=start;
        this.end=end;
    }

}
public class MergeIntervals {
    public static void main(String[] args) {
        ArrayList<Interval> inp=new ArrayList<>();
        inp.add(new Interval(1,2));
        inp.add(new Interval(3,4));
        inp.add(new Interval(5,6));


//1 , 2
//3 , 6

        Interval extra=new Interval(4,5);
        ArrayList<Interval> list= new MergeIntervals().insert(inp,extra);
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i).start+" , "+list.get(i).end);
        }
    }
    public ArrayList<Interval> insert(ArrayList<Interval> current, Interval newInterval){
        int n=current.size();
        ArrayList<Interval> ans=new ArrayList<>();

        for(int i=0;i<n;i++){
            if(current.get(i).end<newInterval.start){
                ans.add(current.get(i));
            }
            else if(newInterval.end<current.get(i).start){
                ans.add(newInterval);
                while(i<n){
                    ans.add(current.get(i));
                    i++;
                }
                return ans;
            }
            else{
                //overlap
                newInterval.start=Math.min(newInterval.start,current.get(i).start);
                newInterval.end=Math.max(newInterval.end,current.get(i).end);
            }
        }
        ans.add(newInterval);
        return ans;

    }

    public List<Interval> merge2(List<Interval> list, Interval interval){

        List<Interval> ans=new ArrayList<>();
        for(int i=0;i<list.size();i++){

            Interval current=list.get(i);
            if(interval.start<=current.end && !(interval.end<current.start)){
                interval= new Interval(Math.min(current.start,interval.start),Math.max(current.end,interval.end));
            }
            else{
                ans.add(current);
            }

        }
        ans.add(interval);

        Collections.sort(ans,(a,b)->a.start- b.start);
        return  ans;

    }
}
