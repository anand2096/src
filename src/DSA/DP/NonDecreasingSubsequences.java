package DSA.DP;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NonDecreasingSubsequences {

    public static void main(String[] args) {

        int[] nums = {4, 6, 7, 7};
        System.out.println(new NonDecreasingSubsequences().findSubsequences(nums));
    }

    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        allSubs(nums, 0, result, new ArrayList<>());
        return new ArrayList<>(result);

    }

    public void allSubs(int[] nums, int index, Set<List<Integer>> result, List<Integer> currSeq) {
        if (index == nums.length) {
            if (currSeq.size() >= 2) {
                result.add(new ArrayList<>(currSeq));
            }
            return;
        }

        if (currSeq.isEmpty() || currSeq.get(currSeq.size() - 1) <= nums[index]) {
            currSeq.add(nums[index]);
            allSubs(nums, index + 1, result, currSeq);
            currSeq.remove(currSeq.size() - 1);
        }

        allSubs(nums, index + 1, result, currSeq);
    }
}
