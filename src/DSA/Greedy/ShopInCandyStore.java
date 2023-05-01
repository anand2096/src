package DSA.Greedy;


import java.util.ArrayList;
import java.util.Arrays;

//https://practice.geeksforgeeks.org/problems/shop-in-candy-store1145/1

class ShopInCandyStore{
    static ArrayList<Integer> candyStore(int candies[], int N, int K){
        // code here
        ArrayList<Integer> ans=new ArrayList<>();

        int minPrice=0;
        int maxPrice=0;
        Arrays.sort(candies);
        int candiesCount1=0;
        int candiesCount2=0;
        for(int i=0;i<candies.length;i++){
            if(candiesCount1<N){
                minPrice=minPrice+candies[i];
                candiesCount1=candiesCount1+K+1;
            }
            else{
                break;
            }

        }

        for(int i=candies.length-1;i>=0;i--){
            if(candiesCount2<N){
                maxPrice=maxPrice+candies[i];
                candiesCount2=candiesCount2+K+1;
            }
            else{
                break;
            }

        }
        ans.add(minPrice);ans.add(maxPrice);
        return ans;
    }
}