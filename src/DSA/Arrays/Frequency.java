package DSA.Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Frequency {

    public static void main(String[] args) {
        int a[]={4,4,4,2,2,1,3,3,1,5};

        Map<Integer,Integer> map=new HashMap();
        for(int i=0;i<a.length;i++)
        {
            if(map.containsKey(a[i])){
                map.put(a[i],map.get(a[i])+1);
            }
            else
            {
                map.put(a[i],1);
            }
        }
        List<Integer>no=new ArrayList<>();
        List<Integer>freq=new ArrayList<>();
        for(int i=0;i<a.length;i++){
         int val= map.get(a[i]);
         if(!no.contains(a[i]))
         {  no.add(a[i]);
         freq.add(val);}
        }

        int n[]=no.stream().mapToInt(i->i).toArray();
        int f[]=freq.stream().mapToInt(i->i).toArray();

        List<Integer>finalAns=new ArrayList<>();
        for(int i=0;i<n.length;i++){

            for(int j=1;j<n.length-i;j++){

                if(f[j-1]<f[j]){

                    int temp1=n[j];
                    n[j]=n[j-1];
                    n[j-1]=temp1;
                    int temp2=f[j];
                    f[j]=f[j-1];
                    f[j-1]=temp1;
                }
                else if(f[j-1]==f[j]){

                    if(n[j]>n[j-1]){
                        int temp1=n[j-1];
                        n[j-1]=n[j];
                        n[j]=temp1;
                        int temp2=f[j-1];
                        f[j-1]=f[j];
                        f[j]=temp2;

                    }

                }
            }
        }
        for(int i=0;i<n.length;i++){


            System.out.print(n[i] +" ");
        }

    }

}
