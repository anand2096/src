package DSA.Greedy;

import java.util.*;

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}

class kapsackComparator implements Comparator<Item>{

    @Override
    public int compare(Item o1, Item o2) {

        if((o2.value/o2.weight)>(o1.value/o1.weight))return -1;
        else  return 1;


    }
}

public class FractionalKnapsack {
    public static void main(String[] args) {
        Item[] arr = { new Item(60, 10),
                new Item(100, 20),
                new Item(120, 30),
                new Item(200, 40)


        };
        System.out.println(new FractionalKnapsack().fractionalKnapsack(50,arr,2));

    }
    double fractionalKnapsack(int W, Item arr[], int n)
    {
        // Your code here
        int sum=0;
        List<Item> items= Arrays.asList(arr);
        Collections.sort(items,new kapsackComparator());
        for(int i=0;i<items.size()&& W>0;i++ ){
            Item item=items.get(i);
            if(W-item.weight>=0){

                sum =sum+item.value;
                W=W-item.weight;
            }
            else {//Input: arr[] = {{60, 10}, {100, 20}, {120, 30}}, W = 50
                int fraction=W/item.weight;
                sum=sum+(fraction*item.value);
                W=W-(item.weight*fraction);
                break;

            }
        }
        return sum;

    }
}



