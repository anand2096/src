package DSA.journey.Array1d_1march;

import DSA.CommonFun;

import java.util.ArrayList;

public class RearrangeArray {

    public static void main(String[] args) {
int arr[]={0, 2, 1, 3};
       ArrayList<Integer>inp= CommonFun.createInput(arr);
        new RearrangeArray().arrange(inp);
      //System.out.println());
    }
    public void arrange(ArrayList<Integer> list)
    {int n=list.size();


        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=list.get(i);
        }
       ArrayList<Integer> ans=rearrange1(arr,n);
        for(int i=0;i<ans.size();i++){
            list.set(i,ans.get(i));
        }

    }

    public ArrayList<Integer> rearrange1(int arr[], int n)
    {
        ArrayList<Integer>ans=new ArrayList<>();
        // First step: Increase all values by
        // (arr[arr[i]]%n)*n
        for (int i = 0; i < n; i++)
            arr[i] += (arr[arr[i]] % n) * n;

        // Second Step: Divide all values by n
        for (int i = 0; i < n; i++)
            arr[i] /= n;

        for(int i=0;i<n;i++){
            ans.add(arr[i]);
        }

        return ans;
    }
}
