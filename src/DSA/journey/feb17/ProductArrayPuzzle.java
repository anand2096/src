package DSA.journey.feb17;

import DSA.CommonFun;

import java.util.ArrayList;

public class ProductArrayPuzzle {

    public static void main(String[] args) {
        int arr[] ={1, 2, 3, 4, 5};
        ArrayList<Integer> al = CommonFun.createInput(arr);
        System.out.println(new ProductArrayPuzzle().solve(al));

    }
    public ArrayList<Integer> solve(ArrayList<Integer> list) {

        int prefixProduct[]=new int[list.size()];
        int suffixProduct[]=new int[list.size()];
        ArrayList<Integer> ans=new ArrayList<>();
        prefixProduct[0]=1;
        suffixProduct[list.size()-1]=1;
        for(int i=1;i<list.size();i++){
            prefixProduct[i]=prefixProduct[i-1]*list.get(i-1);
        }
        for(int i=list.size()-2;i>=0;i--){
            suffixProduct[i]=suffixProduct[i+1]*list.get(i+1);
        }
        System.out.println("");
        for(int i=0;i<list.size();i++){
            ans.add(prefixProduct[i]*suffixProduct[i]);
        }
return ans;
    }
}
