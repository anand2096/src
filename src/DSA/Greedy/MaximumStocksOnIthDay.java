package DSA.Greedy;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Pair{

    int price;
    int index;
    public Pair(int price,int index){
        this.price=price;
        this.index=index;
    }
}
public class MaximumStocksOnIthDay {

    public static void main(String[] args) {
       int price[] = { 7,10,4 };
       int  k = 100;
        System.out.println(new MaximumStocksOnIthDay().buyMaximumProducts(3,k,price));
    }
    public static int buyMaximumProducts(int n, int k, int[] price) {
        // code here
        int stocksCount=0;
        int currentPrice=0;
        List<Pair> pairList=new ArrayList<>();
        for(int i=0;i<price.length;i++){
            pairList.add(new Pair(price[i],i+1));
        }
        Collections.sort(pairList,(o1,o2)->o1.price- o2.price);
        for(Pair pair:pairList){
            int temp=pair.index* pair.price;
            if(currentPrice+temp<=k){
                currentPrice=currentPrice+temp;
                stocksCount=stocksCount+pair.index;
            }
            else{

                int diff=k-currentPrice;
                int div=diff /pair.price;
                if(div!=0){
                    int priceToAdded= pair.price*div;
                    currentPrice=currentPrice+priceToAdded;
                    stocksCount=stocksCount+div;
                }

            }

        }
        return stocksCount;
    }
}
