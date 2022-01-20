package graph;

import java.util.HashMap;
import java.util.Map;

public class Task997 {

    public static void main(String[] args) {
        Task997 task997 = new Task997();
        System.out.println(task997.findJudge(1, new int[][]{}));
        System.out.println(task997.findJudge(2, new int[][]{
                {1, 2},
                {2, 1},
        }));
        System.out.println(task997.findJudge(3, new int[][]{
                {1, 3},
                {2, 3},
                {3, 1}
        }));
        System.out.println(task997.findJudge(4, new int[][]{
                {1, 3},
                {1, 4},
                {2, 3},
                {2, 4},
                {4, 3}
        }));

        System.out.println(task997.findJudge(4, new int[][]{
                {3, 2},
                {4, 1},
                {3, 1},
                {2, 1},
                {2, 3},
                {4, 3},
                {4, 2},
                {3, 4}
        }));
    }

    public int findJudge(int n, int[][] trust) {
        Map<Integer, Integer> relations = new HashMap<>();
        for (int[] ints : trust) {
            relations.put(ints[0], -999);
            if (!relations.containsKey(ints[1]))
                relations.put(ints[1], 1);
            else
                relations.put(ints[1], relations.get(ints[1]) + 1);
        }
        for (Map.Entry<Integer, Integer> pair : relations.entrySet())
            if (pair.getValue() == n - 1)
                return pair.getKey();
        return n == 1 ? 1 : -1;
    }
}
