package graph;

import java.util.*;

public class Task1791 {
    public static void main(String[] args) {
        Task1791 task1791 = new Task1791();
        System.out.println(task1791.findCenter(new int[][]{
                {1,2},
                {2,3},
                {4,2}
        }));
    }

    public int findCenter(int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            for (int j = 0; j < 2; j++) {
                if (!graph.containsKey(edges[i][0]))
                    graph.put(edges[i][0], new ArrayList<>());
                if (!graph.containsKey(edges[i][1]))
                    graph.put(edges[i][1], new ArrayList<>());
                graph.get(edges[i][0]).add(edges[i][1]);
                graph.get(edges[i][1]).add(edges[i][0]);
            }
        }
        int res = -1;
        int max = 0;
        for (Map.Entry<Integer, List<Integer>> pair : graph.entrySet()){
            if (pair.getValue().size() > max){
                res = pair.getKey();
                max = pair.getValue().size();
            }
        }
        return res;
    }
}
