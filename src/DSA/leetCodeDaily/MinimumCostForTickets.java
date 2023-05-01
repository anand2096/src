package DSA.leetCodeDaily;

public class MinimumCostForTickets {
    public static void main(String[] args) {
        int days[]={1,4,6,7,8,20};
        int [] costs = {2,7,15};
        System.out.println(new MinimumCostForTickets().mincostTickets(days,costs));
    }
    //Tag=Recursion,DP
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days.length];
        return solve(days.length,days, costs, 0,dp);
    }

    public int solve(int n,int []days,int []cost,int index,int[] dp ){
        if(index>=n){
            return 0;
        }
        if(dp[index]!=0)
            return dp[index];
        //1day pass
        int option1=cost[0]+solve(n,days,cost,index+1,dp);

        //7days pass
        int i;
        for(i=index;i<n &&days[i]<days[index]+7;i++);

        int option2=cost[1]+solve(n,days,cost,i,dp);

        //15days pass
        int j;
        for(j=index;j<n &&days[j]<days[index]+30;j++);

        int option3=cost[2]+solve(n,days,cost,j,dp);

        return dp[index]=Math.min(option1,Math.min(option2,option3));


    }
}
