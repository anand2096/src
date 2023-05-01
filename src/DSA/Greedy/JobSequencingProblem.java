//package DSA.Greedy;
//
//
//import java.util.*;
//
//class Job {
//    int id, profit, deadline;
//    Job(int x, int y, int z){
//        this.id = x;
//        this.deadline = y;
//        this.profit = z;
//    }
//}
//class JobComparator implements Comparator<Job>{
//
//
//    @Override
//    public int compare(Job o1, Job o2) {
//        if(o1.deadline<o2.deadline)return -1;
//        else if(o1.deadline>o2.deadline)return 1;
//        else if(o1.profit<o2.profit) return -1;
//        return 1;
//    }
//}
//public class JobSequencingProblem {
//    //Function to find the maximum profit and the number of jobs done.
//    int[] JobScheduling(Job arr[], int n)
//    {
//        // Your code here
//        JobComparator jobComparator=new JobComparator();
//        List<Job> jobs=Arrays.asList(arr);
//        Collections.sort(jobs,jobComparator);
//        System.out.println(jobs);
//
//
//
//    }
//
//    public static void main(String[] args) {
//
//    }
//}
//
