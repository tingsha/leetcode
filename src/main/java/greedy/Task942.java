package greedy;

import java.util.Arrays;

public class Task942 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Task942().diStringMatch("IDID")));
        System.out.println(Arrays.toString(new Task942().diStringMatch("III")));
        System.out.println(Arrays.toString(new Task942().diStringMatch("DDD")));
        System.out.println(Arrays.toString(new Task942().diStringMatch("DDI")));
    }

    public int[] diStringMatch(String s) {
        int[] res = new int[s.length() + 1];

        int max = s.length();
        int min = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'D'){
                res[i] = max;
                max--;
            } else{
                res[i] = min;
                min++;
            }
        }
        res[res.length-1] = min;

        return res;
    }
}
