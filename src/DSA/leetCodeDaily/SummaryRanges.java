package DSA.leetCodeDaily;

import java.util.*;

class SummaryRanges {

    private TreeMap<Integer,Integer> startToEndIntervals;
    public SummaryRanges() {

        startToEndIntervals=new TreeMap<>();
    }
    public void addNum(int value) {


        Map.Entry<Integer,Integer> closestBefore=startToEndIntervals.floorEntry(value);
        if(closestBefore!=null && value>=closestBefore.getKey()&&value<=closestBefore.getValue()){
            return;
        }
        Map.Entry<Integer,Integer> closestAfter=startToEndIntervals.ceilingEntry(value);

        int min=value;
        int max=value;
        //[closestBefore] value [closestAfter]
        if(closestBefore!=null&& closestBefore.getValue()+1==value){
            startToEndIntervals.remove(closestBefore.getKey());
            min=closestBefore.getKey();

        }
        if(closestAfter!=null&&closestAfter.getKey()-1==value){
            startToEndIntervals.remove(closestAfter.getKey());
            max=closestAfter.getValue();
        }

        startToEndIntervals.put(min,max);

    }

    public int[][] getIntervals(){
        int intervals[][]=new int[startToEndIntervals.size()][2];
        int i=0;
        for(Map.Entry<Integer,Integer> entry:startToEndIntervals.entrySet()){
            intervals[i++]=new int[]{entry.getKey(),entry.getValue()};
        }
        return  intervals;
    }
//    public int[][] getIntervals() {
//        Set<Interval> intervalSet=new HashSet<>();
//        int size=numbers.size();
//        int j=0;
//        int i=1;
//        while (i<size){
//            if(numbers.get(i)-numbers.get(i-1)!=1){
//                intervalSet.add(new Interval(numbers.get(j),numbers.get(i-1)));
//                j=i;
//            }
//            i++;
//        }
//        intervalSet.add(new Interval(numbers.get(j),numbers.get(i-1)));
//        List<Interval> list=new ArrayList<>();
//        list.addAll(intervalSet);
//        Collections.sort(list,(i1,i2)->i1.start-i2.start);
//
//        int ans[][]=new int[list.size()][2];
//        for(int t=0;t<ans.length;t++){
//
//            int temp[]=new int[2];
//            temp[0]=list.get(t).start;
//            temp[1]=list.get(t).end;
//            ans[t]=temp;
//        }
//
//        return  ans;
//    }

    public static void main(String[] args) {
        SummaryRanges summaryRanges=new SummaryRanges();
        summaryRanges.addNum(1);
        summaryRanges.addNum(3);
        summaryRanges.addNum(7);
        summaryRanges.addNum(2);
        summaryRanges.addNum(6);
        int [][] temp=summaryRanges.getIntervals();
        for(int i=0;i<temp.length;i++){
            for(int j=0;j<temp[i].length;j++){
                System.out.print(temp[i][j]+" ");
            }
            System.out.println();
        }
    }
}