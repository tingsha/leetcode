import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task1403 {
    public static void main(String[] args) {
        System.out.println(new Task1403().minSubsequence(new int[]{4,3,10,9,8}));
        System.out.println(new Task1403().minSubsequence(new int[]{4,4,7,6,7}));
        System.out.println(new Task1403().minSubsequence(new int[]{1,2,3,4,5,6}));
        System.out.println(new Task1403().minSubsequence(new int[]{6}));
    }

    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        reverseArray(nums);
        int sum = 0;
        for (int i : nums)
            sum += i;

        List<Integer> res = new ArrayList<>();
        int listSum = 0;
        for (int i : nums){
            res.add(i);
            listSum += i;
            sum -= i;
            if (sum < listSum)
                break;
        }

        return res;
    }

    private void reverseArray(int[] nums) {
        for (int i = 0; i < nums.length/2; i++) {
            int tmp = nums[i];
            nums[i] = nums[nums.length-1-i];
            nums[nums.length-1-i] = tmp;
        }
    }
}
