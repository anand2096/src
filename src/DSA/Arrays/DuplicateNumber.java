package DSA.Arrays;

class Solution {
    public int findDuplicate(int[] nums) {
        int i=0;
        int ans=0;
        int no=nums[i];
        while(true){

            if(no<0)
            {ans=i;
                break;


            }
            else{
                nums[i]=nums[i]*-1;
                i=no;
                no=nums[no];

            }

        }
        return ans;
    }}