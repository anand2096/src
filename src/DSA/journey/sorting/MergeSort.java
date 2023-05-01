package DSA.journey.sorting;

public class MergeSort {
   static int swaps=0;
    public static void main(String[] args) {


        int ar[]={ 3,4,1,2};
        new MergeSort().mergeSort(ar,0,ar.length-1);
        for(int i=0;i<ar.length;i++){
            System.out.print(ar[i]+" ");
        }
        System.out.println("swaps :: "+swaps);
    }

    public void mergeSort(int a[],int s,int e){

        if(s==e)
        {return;}
        int m=(s+e)/2;
        mergeSort(a,s,m);
        mergeSort(a,m+1,e);
        merge(a,s,m,e);

    }
    public void merge(int a[], int s,int m,int e){
        int c[]=new int [e-s+1];
        int p1=s;
        int p2=m+1;
        int p3=0;
        while(p1<=m && p2<=e){
            if(a[p1]<a[p2]){
                c[p3]=a[p1];
                p1++;
                p3++;
            }
            else{
                c[p3]=a[p2];
                p2++;
                p3++;
               // if(c.length>2)
                swaps++;
                //swaps = swaps +(p2-p1);
            }
        }

        while(p1<=m){
            c[p3]=a[p1];
            p3++;
            p1++;
//            if(c.length>2)
//           swaps++;
        }
        while(p2<=e){
            c[p3]=a[p2];
            p2++;
            p3++;
//            if(c.length>2)
//            swaps++;
        }
    for(int i=0;i<=(e-s);i++){
        a[s+i]=c[i];
    }

    }


}
