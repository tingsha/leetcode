package greedy;

import java.util.Arrays;

public class Task561 {
    public static void main(String[] args) {
        System.out.println(new Task561().arrayPairSum(new int[]{6,2,6,5,1,2}));
    }

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length; i += 2) {
            res += Math.min(nums[i], nums[i+1]);
        }
        return res;
    }
}
