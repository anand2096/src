package DSA.Greedy;

public class SurviveOnIsland {
    static int minimumDays(int S, int N, int M){

        int totalUnitNeeded=S*M;
        int buyingDays=S-(S/7);
        int days=totalUnitNeeded/N;
        int mod=totalUnitNeeded%N;
        if(mod>0) days=days+1;
        if(days>buyingDays) return -1;
        return days;

    }

}
