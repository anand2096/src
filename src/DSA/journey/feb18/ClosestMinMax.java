package DSA.journey.feb18;

import DSA.CommonFun;

import java.util.ArrayList;

public class ClosestMinMax {
    public static void main(String[] args) {
        int arr[]={8,8,8,8,8};
        System.out.println(new ClosestMinMax().solve(CommonFun.createInput(arr)));
    }

    public int solve(ArrayList<Integer> list) {
        int ans=Integer.MAX_VALUE;
        int minValue=Integer.MAX_VALUE;
        int maxValue=Integer.MIN_VALUE;
        for(int i=0;i<list.size();i++){
            if(list.get(i)<minValue){
                minValue=list.get(i);
            }
            if(list.get(i)>maxValue){
                maxValue=list.get(i);
            }
        }
        if(minValue==maxValue)
            return 1;
        int minIndex=-1;
        int maxIndex=-1;
        for(int i=list.size()-1;i>=0;i--){
            if(list.get(i)==minValue){
                minIndex=i;
                if(maxIndex!=-1){
                    int temp=Math.abs(minIndex-maxIndex)+1;
                    if(temp<ans){
                        ans=temp;
                    }
                }
            }
            else if(list.get(i)==maxValue){
                maxIndex=i;
                if(minIndex!=-1){
                    int temp=Math.abs(minIndex-maxIndex)+1;
                    if(temp<ans){
                        ans=temp;
                    }
                }

            }
        }

        return ans;
    }
}
