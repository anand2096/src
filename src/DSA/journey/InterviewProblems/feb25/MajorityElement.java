package DSA.journey.InterviewProblems.feb25;

import DSA.CommonFun;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElement {
    //https://www.youtube.com/watch?v=AoX3BPWNnoE
    public static void main(String[] args) {
    int arr[]={5,5,7,7,1,7};
        System.out.println(new MajorityElement().majorityElementOptimalO1(CommonFun.createInput(arr)));
    }
    public int majorityElement(final List<Integer> list) {
        int n=list.size();
        int majorityElement=0;
        int majorityMax=Integer.MIN_VALUE;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<list.size();i++){
            map.put(list.get(i),map.getOrDefault(list.get(i),0)+1);
            if(map.get(list.get(i))>=Math.floor(n/3)){
                if(map.get(list.get(i))>majorityMax){
                    majorityMax=map.get(list.get(i));
                    majorityElement=list.get(i);
                }
            }
        }
        return majorityElement;
    }
    public int majorityElementOptimalO1(final List<Integer> list) {

        int count=0;
        int candidate=0;

        for(int num:list){
            if(count==0){
                candidate=num;
            }
            if(num==candidate){
                count++;
            }
            else{
                count=count-1;
            }


        }

        return candidate;


    }
}
