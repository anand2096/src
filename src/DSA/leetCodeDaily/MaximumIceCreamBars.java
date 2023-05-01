package DSA.leetCodeDaily;

import java.util.Arrays;

//https://leetcode.com/problems/maximum-ice-cream-bars/
public class MaximumIceCreamBars {

    public static void main(String[] args) {
int costs []={1,3,2,4,1};
int coins=7;
        System.out.println(new MaximumIceCreamBars().maxIceCream(costs,coins));
    }

    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int temp=coins;
        int i=0;
        int cnt=0;
        while((temp>0)&&(i<costs.length)){
            if(costs[i]<=temp){
                cnt++;
                temp=temp-costs[i];
            }
            i++;

        }
        return cnt;

    }
}
