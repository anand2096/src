package DSA;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;



//1 2 3
public class Test {
    public static void main(String[] args) {
        int nums[] = {24,-46,23,-49,-32,-49,-34,-24};

        int k = 6;
        int x = 5;
        int ans[] = new
                Test().getSubarrayBeauty(nums, k, x);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }

    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        List<Integer> ans = new ArrayList<>();
        TreeSet<Integer> set = new TreeSet<>();
        int i = 0;
        int j = 0;
        int n = nums.length;
        while (j < n) {
            if (j < k - 1) {
                if(nums[j]<0)
                set.add(nums[j]);
                j++;
            } else {
                if(nums[j]<0)
                set.add(nums[j]);
                int w = 1;
                if (set.size() >= x) {
                    for (int s : set) {
                        if (w == x) {
                            if (s < 0)
                                ans.add(s);
                            else {
                                ans.add(0);
                            }
                            break;
                        } else {
                            w++;
                        }
                    }
                } else {
                  //  if(set.last()<0)
                    ans.add(0);

                }
                set.remove(nums[i]);
                i++;
                j++;

            }

        }
        int arrAns[] = new int[ans.size()];
        for (int t = 0; t < ans.size(); t++) {
            arrAns[t] = ans.get(t);
        }
        return arrAns;


    }
}
