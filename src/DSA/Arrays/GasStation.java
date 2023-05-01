package DSA.Arrays;


//class Tank {
//
//    int g;
//    int c;
//    int index;
//
//    public Tank(int g, int c, int index) {
//        this.g = g;
//        this.c = c;
//        this.index = index;
//    }
//
//}

//class TankComparator implements Comparator<Tank> {
//    @Override
//    public int compare(Tank o1, Tank o2) {
//
//        if (o1.c < o2.c) return -1;
//        else if (o1.c > o2.c) return 1;
//        else if (o1.g > o2.g) return -1;
//
//        return 0;
//    }
//}

public class GasStation {

    public static void main(String[] args) {
        int[] gas = {7,1,0,11,4};
        int[] cost = {5,9,1,2,5};
//        int[] gas = {1,2,3,4,5};
//        int[] cost = {3,4,5,1,2};
//        int[] gas = {5, 8, 2, 8};
//       int[] cost = {6, 5, 6, 6};
//        int[] gas = {2,3,4};
//        int[] cost = {3,4,3};
        System.out.println(new GasStation().canCompleteCircuit(gas, cost));

    }

//    public int canCompleteCircuit(int[] gas, int[] cost) {
//        int sum = 0;
//        List<Tank> tankList = new ArrayList<>();
//        for (int i = 0; i < gas.length; i++) {
//            tankList.add(new Tank(gas[i], cost[i], i));
//        }
//        Collections.sort(tankList, new TankComparator());
//        for (int i=0;i<tankList.size()-1;i++) {
//            sum = sum + tankList.get(i).g - tankList.get(i).c;
//
//        }
//        sum=sum+tankList.get(tankList.size()-1).g;
//        if (sum < tankList.get(tankList.size()-1).c)
//            return -1;
//        else return tankList.get(0).index;
//    }


    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;
        int actual = 0;
        int startIndex = 0;
        for (int i = 0; i < gas.length; i++) {

            total = total + gas[i] - cost[i];
            actual = actual + gas[i] - cost[i];
            if (actual < 0) {
                actual = 0;
                startIndex = i + 1;
            }
        }
        if (total < 0) return -1;
        else return startIndex;
    }


}
