package DSA.leetCodeDaily;

public class MinimizeMaximumOfArray {

    public static void main(String[] args) {
        int arr[] = {3,7,1,6};
        System.out.println(new MinimizeMaximumOfArray().minimizeArrayValue(arr));
    }

    public int minimizeArrayValue(int[] nums) {
        int maxEle = Integer.MIN_VALUE;
        int n = nums.length;
        int maxIndex = -1;
        for (int i = 0; i < n; i++) {
            if (maxEle < nums[i]) {
                maxEle = nums[i];
                maxIndex = i;
            }
        }
        if (maxIndex == 0) {
            return maxEle;
        } else {
            int i = maxIndex;
            int maxDup = maxEle;
            while (true) {

                if (i == maxIndex) {
                    nums[i % n] = nums[i] - 1;
                    nums[(i - 1) % n] = nums[(i - 1) % n] + 1;
                    if (nums[(i - 1) % n] >= nums[i % n]) {
                        return nums[i % n];
                    }
                } else {
                    if(i-1 %n ==maxIndex) {
                        i=i+1;
                        nums[i % n] = nums[i % n] - 1;
                        nums[(i - 1) % n] = nums[(i - 1) % n] + 1;
                        if (nums[(i - 1) % n] >= nums[maxIndex % n]) {
                            return nums[maxIndex % n];
                        }
                    }
                }
                i+=2;
            }
        }

    }
}
