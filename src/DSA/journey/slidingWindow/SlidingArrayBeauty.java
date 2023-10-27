package DSA.journey.slidingWindow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class SlidingArrayBeauty {

    public static void main(String[] args) {
        int nums[] = {-34,19,-25,24,5};
        int k = 4;
        int x = 2;
        int ans[] = new SlidingArrayBeauty().getSubarrayBeauty(nums, k, x);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }

    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int n = nums.length;
        int ans[] = new int[n - k + 1];
        List<Integer> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (j < k) {
            list.add(nums[j]);
            j++;
        }
        int index = 0;
        Collections.sort(list);
        if (list.get(x - 1) < 0) {
            ans[index++] = list.get(x - 1);
        } else {
            ans[index++] = 0;
        }
        list.remove(list.indexOf(nums[i]));
        i++;

        while (j < n) {
            // add at correct position
            int pos = BS(list, nums[j]);
            if(pos>list.size()){
                list.add(nums[j]);
            }
            else if(pos<0){
                list.add(0,nums[j]);
            }
            else if (list.get(pos) <= nums[j]) {
                list.add(pos + 1, nums[j]);
            } else {
                if(pos-1<0)
                {
                    list.add(0,nums[j]);
                }else {
                    list.add(pos - 1, nums[j]);
                }
            }
            if (list.get(x - 1) < 0) {
                ans[index++] = list.get(x - 1);
            } else {
                ans[index++] = 0;
            }
            list.remove(list.indexOf(nums[i]));
            i++;
            j++;

        }
        return ans;
    }

    public int BS(List<Integer> list, int target) {
        int low = 0;
        int high = list.size() - 1;
        int min = Integer.MAX_VALUE;
        int index = -1;
        int mid = 0;
        while (low <= high) {
            mid = (low + (high - low) / 2);
            int diff = Math.abs(list.get(mid) - target);
            if (diff < min) {
                min = diff;
                index = mid;
            }
            if (list.get(mid) == target) {
                return list.get(mid);
            } else if (list.get(mid) > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return index;
    }
}
