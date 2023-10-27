package DSA.journey.interveiwBit.week1;

public class SearchInBiotonicArray {
    public static void main(String[] args) {
     int []   A={1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11} ;
      int  B = 12;
        System.out.println(new SearchInBiotonicArray().solve(A,B));

    }
    public int solve(int[] A, int B) {//............................................


        int ans=-1;
        int index=binarySearch(A);
        if(index==0 || index==A.length-1){
            return search(A,0,A.length-1,B);
        }
        else{
          //  reverse(A,index+1,A.length-1);
            int ans1=search(A,0,index,B);
            if(ans1!=-1)return ans1;
            int low=index+1;
            int high=A.length-1;
            int ans2=-1;
            while(low<=high){
                int mid=(low+high)/2;
                if(A[mid]==B)return mid;
                else if(A[mid]>B){
                    low=mid+1;
                }
                else{
                    high=mid-1;
                }
            }
            return ans2;
        }



    }
    public void reverse(int nums[],int start,int end){

        while(start<=end){
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }

    }
    public int search(int nums[],int low,int high,int k){
        int ans=-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid]==k)return mid;
            else if(nums[mid]>k){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
    public int binarySearch(int A[]){
        int low=0;
        int high=A.length-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(mid==0 || mid==A.length-1){
                return mid;
            }
            if(A[mid]>A[mid-1] && A[mid]>A[mid+1]){
                return mid;
            }
            else if(A[mid]>A[mid-1] && A[mid]<A[mid+1]){

                low=mid+1;

            }
            else{
                high=mid-1;
            }
        }
        return -1;
    }
}
