package DSA.Greedy;


import java.util.*;

//class Train{
//    public int trainNo;
//    public String arrivalTime;
//    public String depTime;
//    public int platformNumber;
//
//    public Train(int trainNo,String arrivalTime, String depTime, int platformNumber){
//        this.trainNo=trainNo;
//        this.arrivalTime=arrivalTime;
//        this.depTime=depTime;
//        this.platformNumber=platformNumber;
//    }
//}
//public class MaximumTrainsStopage {
//    public int maxStopage(List<Train> trains){
//
//        Map<Integer,List<Train>> map=new HashMap<>();
//        for(int i=0;i<trains.size();i++){
//
//            Train obj=trains.get(i);
//            int platformNumber=obj.platformNumber;
//            if(map.containsKey(platformNumber)){
//                map.get(platformNumber).add(obj);
//
//            }
//            else{
//                List<Train>temp=new ArrayList<>();
//                temp.add(obj);
//                map.put(platformNumber,temp);
//            }
//        }
//        System.out.println(map);
//
//        return -1;
//    }
//    public static void main(String[] args) {
//
//        List<Train> trains=new ArrayList<>();
//        Train t6=new Train(6,"09:00","10:05",1);
//        Train t3=new Train(3,"10:00","10:20",2);
//        Train t1=new Train(1,"10:00","10:30",1);
//        Train t2=new Train(2,"10:10","10:30",1);
//        Train t4=new Train(4,"10:30","12:30",2);
//        Train t5=new Train(5,"12:00","12:30",3);
//
//
//        trains.add(t1);
//        trains.add(t2);
//        trains.add(t3);
//        trains.add(t4);
//        trains.add(t5);
//        trains.add(t6);
//     int ans=new MaximumTrainsStopage().maxStopage(trains);
//        System.out.println(ans);
//
//    }
//}

//class CustomSort implements Comparator< ArrayList<Integer> > {
//
//    public int compare( ArrayList<Integer> list1 , ArrayList<Integer> list2 ){
//
//        if( list1.get(1) > list2.get(1) ){
//            return 1;
//        }else if( list2.get(1) > list1.get(1)){
//            return -1;
//        }
//
//        return 0;
//    }
//}



class MaximumTrainsStopage{
    int maxStop(int n, int m, ArrayList<ArrayList<Integer>> trains) {
        // Write your code here

        Integer[] platforms = new Integer[n+1];

        for( int i=1 ; i<platforms.length ; i++){
            platforms[i] = 0;
        }

        // custom sorting based on departure time
        Collections.sort( trains , (o1,o2)-> o1.get(1)-o2.get(1) );

        int stoppedTrains = 0;

        for( ArrayList<Integer> train : trains ){

            Integer arr = train.get(0);
            Integer dept = train.get(1);
            Integer platno = train.get(2);



            if( arr>= platforms[ platno ]){
                stoppedTrains+=1;
                platforms[ platno ] = dept;
            }

        }

        return stoppedTrains;
    }
}