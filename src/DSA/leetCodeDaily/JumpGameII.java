package DSA.leetCodeDaily;


//https://leetcode.com/problems/jump-game-ii/
public class JumpGameII {
    int minAns = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int[] nums = {2, 3, 0, 1, 4};
        System.out.println(new JumpGameII().jump(nums));
    }

    public int jump(int[] nums) {
        // int min=Integer.MAX_VALUE;
        minJump(0, 0, nums);
        return minAns;
    }

    private void minJump(int index, int steps, int[] nums) {

        if (index >= nums.length - 1) {
            if (steps < minAns) {
                minAns = steps;
            }
            return;
        }
        int val = nums[index];
        if (index + val == nums.length - 1) {
            minJump(index + val, steps + 1, nums);
        } else {
            for (int i = 1; i <= val; i++) {

                minJump(index + i, steps + 1, nums);
            }
        }

    }


}
