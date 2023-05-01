import java.util.*;
class Order{
    String key;
    String value;
    public Order(String key,String value){
        this.key=key;
        this.value=value;
    }
}

class OrderComparator implements Comparator<Order>{

    @Override
    public int compare(Order o1,Order o2){
        int temp=o1.value.compareTo(o2.value);
        if(temp==0){
            int keyCompare=o1.key.compareTo(o2.key);

            if(temp<=0){
                    return -1;
                    }
                    else{
                    return 1;
                    }
                    }
                    else if(temp>1){
                    return 1;
                    }
                    else{
                    return -1;
                    }

                    }
                    }

public class Test2 {
    int min=Integer.MAX_VALUE;
    public static void main(String[] args) {

       String a[][]={{"z6d8","f"},{"c","xduw"},{"l2m","io"},{"ds","fm"},{"98vdw","ebi"}};

                String[] ans[]=new Test2().solve(a);
                for(int i=0;i<ans.length;i++){
                    System.out.print(ans[i][0]+" "+ans[i][1]);
                }

    }
    public String[][] solve(String[][] arr) {
        String [][] fAns=new String[arr.length][arr[0].length];
        List<Order> primeOrders=new ArrayList();
        List<Order> nonPrimeOrders=new ArrayList();
        List<Order> ans=new ArrayList();
        for(int i=0;i<arr.length;i++){
            String [] temp=arr[i];
            char t=temp[1].charAt(0);
            if(Character.isDigit(t)){
                nonPrimeOrders.add(new Order(temp[0],temp[1]));
            }
            else{
                primeOrders.add(new Order(temp[0],temp[1]));
            }
        }
        Collections.sort(primeOrders,new OrderComparator());
        for(int i=0;i<primeOrders.size();i++){
            ans.add(primeOrders.get(i));
        }
        for(int i=0;i<nonPrimeOrders.size();i++){
            ans.add(nonPrimeOrders.get(i));
        }
        for(int i=0;i<primeOrders.size();i++){
            String a[]=new String[2];
            a[0]=primeOrders.get(i).key;
            a[1]=primeOrders.get(i).value;
            fAns[i]=a;
        }
        for(int i=0;i<nonPrimeOrders.size();i++){
            String a[]=new String[2];
            a[0]=nonPrimeOrders.get(i).key;
            a[1]=nonPrimeOrders.get(i).value;
            fAns[i]=a;
        }
        System.out.println(ans);
        return fAns;


    }
//    public int[] solve(int[] arr, int[] brr) {
//        int n=arr.length;
//        int ans[]=new int[brr.length];
//        int prefix[]=new int[arr.length];
//        prefix[0]=arr[0];
//        for(int i=1;i<n;i++){
//            prefix[i]=prefix[i-1]+arr[i];
//        }
//        for(int i=0;i<brr.length;i++){
//            int money=brr[i];
//            if(money>=prefix[n-1]){
//                ans[i]=arr.length;
//            }
//            else{
//                int low=0;
//                int high=n-1;
//                int temp=0;
//                while(low<=high){
//                    int mid=(low+(high-low)/2);
//                    if(prefix[mid]<money){
//                   //     ans=mid;
//                        low=mid+1;
//                    }
//                    else{
//                        high=mid-1;
//                    }
//
//                }
//
//                if(prefix[low]>money){
//                    ans[i]=low;
//                }
//                else{
//                    ans[i]=low+1;
//                }
//
//            }
//        }
//        return ans;
//    }
//
//
//
//    public int solve(String s, int[] b, int k) {
//
//        int i=0;
//        int j=0;
//        int n=s.length();
//        int count=0;
//        int max=Integer.MIN_VALUE;
//        while(j<n){
//            if(count<=k){
//
//                if(b[s.charAt(j)-'a']==1){
//                    count++;
//                }
//                max=Math.max(max,j-i+1);
//                j++;
//
//            }
//            else{
//
//                while(i<n&&count>k){
//
//                    if(b[s.charAt(i)-'a']==1){
//                        count--;
//                    }
//                    i++;
//
//                }
//
//            }
//            if(count<=k)
//                max=Math.max(max,j-i+1);
//
//
//        }
//        while(i<n&&count>k){
//
//            if(b[s.charAt(i)-'a']==1){
//                count--;
//            }
//            i++;
//
//        }
//        if(count<=k)
//            max=Math.max(max,j-i+1);
//        return max;
//
//
//    }
    public void test(int arr[]){

    }


    public List<List<Integer>> findMatrix(int[] nums) {
        int highFreq=0;
        Map<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int no=nums[i];
            map.put(no,map.getOrDefault(no,0)+1);

            highFreq=Math.max(highFreq,map.get(no));
        }
        List<List<Integer>>ans =new ArrayList<>();
        for(int i=1;i<=highFreq;i++){
            ans.add(new ArrayList<>());
        }

        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            int key=entry.getKey();
            int val=entry.getValue();
            for(int i=0;i<val;i++){
                ans.get(i).add(key);
            }
        }
        return ans;

    }
    public int findTheLongestBalancedSubstring(String s) {
        int ans=Integer.MIN_VALUE;
        int i=0;
        int n=s.length();
        int j=0;
        while(j<n&&s.charAt(j)!='0'){
            j++;
        }

        while (j<n){
            int zCount=0;
            int oCount=0;
            while (j<n&& s.charAt(j)!='1'){
                zCount++;
                j++;
            }
            while (j<n&& s.charAt(j)!='0'){
                oCount++;
                j++;
            }
            if(zCount<=oCount){
                ans=Math.max(ans,zCount);
            }
            else{
                ans=Math.max(ans,oCount);
            }

        }
        return ans*2;

    }
    public int solve(int[] arr) {
        long posSum=0;
        long negSum=0;

        for(int i=0;i<arr.length;i++){

            if(arr[i]<0){
                negSum=negSum+arr[i];
            }
            else{
                posSum=posSum+arr[i];
            }
        }

        long posSq=(posSum*posSum);
        long negSq=(negSum*negSum);
        return (int)(posSq+negSq);
    }

    public void rec(int index,int sum,int []arr,int B,int C){
        if(index>=arr.length-1){

            min=Math.min(min,sum);
            return;
        }
        if(index+1<arr.length)
            rec(index+1,sum+ Math.abs(B*(arr[index+1]-arr[index])),arr,B,C);
        if(index+2<arr.length)
            rec(index+2,sum+Math.abs(C*(arr[index+2]-arr[index])),arr,B,C);



    }


}
