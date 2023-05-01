package DSA.journey.PrefixSum;

import java.util.Arrays;
import java.util.Stack;

class MeetingPair{
    int startTime;
    int endTime;
    MeetingPair(int startTime,int endTime){
        this.startTime=startTime;
        this.endTime=endTime;
    }
}
public class MeetingRooms2 {

    public static void main(String[] args) {
//        Given an array of meeting time intervals consisting of start and end times
//                [[s1,e1],[s2,e2],...](si< ei),
//                find the minimum number of conference rooms required.
//
       int [] [] Input= {{1, 3},{2, 4},{6, 8},{10, 14},{7, 9}};
//        Output:2
        System.out.println(new MeetingRooms2().getMeetingRooms(Input));
    }

    public int getMeetingRooms(int [][] meetings){
        Arrays.sort(meetings,(i1,i2)->i1[0]-i2[0]);

    int ans=0;
    int temp[]=meetings[0];
    Stack<MeetingPair> stack=new Stack<>();
    stack.add(new MeetingPair(temp[0],temp[1]));
    for(int i=1;i<meetings.length;i++){
        MeetingPair top=stack.peek();
        int sTime=meetings[i][0];
        int eTime=meetings[i][1];
        if(sTime>=top.endTime){
            stack.pop();
            MeetingPair meetingPair=new MeetingPair(top.startTime,Math.max(top.endTime,meetings[i][1]));
            stack.push(meetingPair);
        }
        else{
            MeetingPair meetingPair=new MeetingPair(sTime,eTime);
            stack.push(meetingPair);
        }
    }

    return stack.size();

    }

}
