package DSA.journey.BinarySearch;

import java.util.List;

public class MedianOfTwoSortedArray {


    public static void main(String[] args) {

    }
    public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
        List<Integer> list1;
        List<Integer>list2;
        if(b.size()<a.size()){
            list1=b;
            list2=a;
        }
        else{
            list1=a;
            list2=b;
        }
        int n1=list1.size();
        int n2=list2.size();
        long low=0;
        long high=n1;
        while(low<=high) {
            long cut1 = (low + (high - low) / 2);
            long cut2 = (n1+n2+1)/2 - cut1;
            int l1=cut1==0?Integer.MIN_VALUE:list1.get((int) (cut1-1));
            int l2=cut2==0?Integer.MIN_VALUE:list2.get((int) (cut2-1));
            int r1=cut1==n1?Integer.MAX_VALUE:list1.get((int) cut1);
            int r2=cut2==n2?Integer.MAX_VALUE:list2.get((int) cut2);

            if (l1 <= r2 && l2 <= r1) {
                if((n1+n2)%2==0){
                return (Math.max(l1,l2)+Math.min(r1,r2))/2.0;
                }
                else{
                    return Math.max(l1,l2);
                }

            } else if (l1 > r2) {
                high = cut1 - 1;
            } else {
                low = cut1 + 1;
            }

        }
        return 0.0;
    }



}
