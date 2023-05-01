package DSA.journey.TwoPointers;

import DSA.journey.sorting.MaximumUnsortedSubarray;

public class MaxContinuousSeriesOf1s {

    public static void main(String[] args) {
//        int [] A = {1, 1 ,0 ,1 ,1 ,0, 0, 1 ,1 ,1 };
//        int   B = 1;
        int[] A = {1, 0, 1, 0, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0};
        int B = 4;

//        int[] A = {1, 1, 0, 0, 0, 0, 0, 1 };
//        int B = 4;
//        int[] A = {1, 1, 0};
//        int B = 2;

        int ans[] = new MaxContinuousSeriesOf1s().maxoneBestOne(A, B);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }
    public int[] maxoneBestOne(int[] nums, int k) {
        int n = nums.length;
        int i = 0;
        int j = 0;
        int max = Integer.MIN_VALUE;
        int maxI = 0;
        int maxJ = 0;
        int zCount = 0;
        while (j < n) {
            if (zCount <= k) {
                if (nums[j] == 0) {
                    zCount++;
                }
                j++;

            }
            while (zCount > k) {
                if (nums[i] == 0) {
                    zCount--;
                }
                i++;
            }
            if (j - i > max) {
                max = j - i;
                maxI = i;
                maxJ = j;
            }

        }
            //   System.out.println("max:: "+max);
            int ans[] = new int[maxJ - maxI ];
            int t = 0;
            for (int a = maxI; a < maxJ; a++) {
                ans[t++] = a;
            }
            return ans;


    }






    public int[] maxonePoor(int[] nums, int k) {
        int n = nums.length;
        if (k == 0) {
            int max = Integer.MIN_VALUE;
            int maxI = 0;
            int maxJ = 0;
            int i = 0;
            int j = 0;
            while (j < n) {

                while (j < n && nums[j] != 1) {
                    j++;
                }
                int cnt = 1;
                int x = j + 1;
                while (x < n && nums[x] == 1) {
                    x++;
                    cnt++;
                }
                if (cnt > max) {
                    max = cnt;
                    maxI = j;
                    maxJ = x - 1;
                }
                j = x;
            }
            int ans[] = new int[maxJ - maxI + 1];
            int t = 0;
            for (int a = maxI; a <= maxJ; a++) {
                ans[t++] = a;
            }
            return ans;
        }
        int i = 0;
        int j = -1;
        int max = Integer.MIN_VALUE;
        int maxI = 0;
        int maxJ = 0;
        int zCount = 0;
        while (j < n) {
            if (zCount < k) {
                j++;
                if (j<n&&nums[j] == 0) {
                    zCount++;
                }

            } else {
                if (zCount == k) {
                    int temp = j - i + 1;
                    if (temp > max) {
                        max = temp;
                        maxI = i;
                        maxJ = j;
                    }
                } else {

                    while (i<n&& zCount > k) {
                        if (nums[i] == 0) {
                            zCount--;
                        }
                        i++;
                        if (zCount == k) {
                            int temp = j - i + 1;
                            if (temp > max) {
                                max = temp;
                                maxI = i;
                                maxJ = j;
                            }
                        }
                    }
                }
                j++;
                if (j < n && nums[j] == 0) {
                    zCount++;
                }
            }

        }
        j = j - 1;
        while (i<n&&zCount <= k) {
            int temp = j - i + 1;
            if (temp > max) {
                max = temp;
                maxI = i;
                maxJ = j;
            }

            if (i<n&& nums[i] == 0) {
                zCount--;
            }
            i++;
        }

        //   System.out.println("max:: "+max);
        int ans[] = new int[maxJ - maxI + 1];
        int t = 0;
        for (int a = maxI; a <= maxJ; a++) {
            ans[t++] = a;
        }
        return ans;

    }





}
