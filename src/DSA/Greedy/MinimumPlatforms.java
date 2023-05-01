package DSA.Greedy;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//class Train{
//
//    public int arrivalTime;
//    public int depTime;
//
//
//    public Train(int arrivalTime, int depTime){
//
//        this.arrivalTime=arrivalTime;
//        this.depTime=depTime;
//
//    }
//}
public class MinimumPlatforms {
    //Function to find the minimum number of platforms required at the
    //railway station such that no train waits.
//    static int findPlatform(int arr[], int dep[], int n)
//    {
//        // add your code here
//        List<Train> trainList=new ArrayList<>();
//        List<Integer> platforms=new ArrayList<>();
//        for (int i=0;i<arr.length;i++){
//            trainList.add(new Train(arr[i],dep[i]));
//    }
//        Collections.sort(trainList,(o1,o2)->o1.depTime-o2.depTime);
//        for(int i=0;i<trainList.size();i++){
//            int arrival=trainList.get(i).arrivalTime;
//            int departure=trainList.get(i).depTime;
//            boolean updated=false;
//            for(int j=0;j<platforms.size();j++){
//                if(arrival>platforms.get(j)){
//                    platforms.set(j,departure);
//                    updated=true;
//                    break;
//                }
//            }
//            if(!updated){
//                platforms.add(departure);
//            }
//        }
//        return platforms.size();
//    }
    static int findPlatform(int arr[], int dep[], int n){

        Arrays.sort(arr);
        Arrays.sort(dep);
        int platformNeeded=1;
        int result=1;

        int i=1,j=0;
        while(i<n&&j<n){


            if(arr[i]<=dep[j]){
                platformNeeded++;
                i++;
            }
            else if(arr[i]>dep[j]){

                platformNeeded--;
                j++;
            }

            if(platformNeeded>result){
                result=platformNeeded;
            }

        }
        return  result;

    }
    public static void main(String[] args) {

        int arr [] = {900, 940, 950, 1100, 1500, 1800};
        int dep [] = {910, 1200, 1120, 1130, 1900, 2000};
        System.out.println(findPlatform(arr,dep,6));
    }

}