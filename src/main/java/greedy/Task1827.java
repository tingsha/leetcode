package greedy;

public class Task1827 {
    public static void main(String[] args) {
        System.out.println(new Task1827().minOperations(new int[]{1, 5, 2, 4, 1}));
    }

    public int minOperations(int[] nums) {
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i-1]){
                res += nums[i-1] - nums[i] + 1;
                nums[i] += nums[i-1] - nums[i] + 1;
            }
        }
        return res;
    }
}
