package greedy;

import java.util.HashMap;
import java.util.Map;

public class Task1217 {
    public static void main(String[] args) {
        System.out.println(new Task1217().minCostToMoveChips(new int[]{1, 2, 3}));
        System.out.println(new Task1217().minCostToMoveChips(new int[]{1}));
        System.out.println(new Task1217().minCostToMoveChips(new int[]{2, 2, 2, 3, 3}));
        System.out.println(new Task1217().minCostToMoveChips(new int[]{1,1000000000}));
        System.out.println(new Task1217().minCostToMoveChips(new int[]{2,3,3}));
        System.out.println(new Task1217().minCostToMoveChips(new int[]{3,3, 1, 2, 2}));
    }

    public int minCostToMoveChips(int[] positions) {
        int odd = 0;
        int even = 0;
        for (int i = 0; i < positions.length; i++) {
            if (positions[i] % 2 == 0)
                even++;
            else
                odd++;
        }
        return Math.min(even, odd);
    }
}
