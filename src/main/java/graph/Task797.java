package graph;

import java.util.*;

public class Task797 {
    public static void main(String[] args) {
        Task797 task797 = new Task797();
        List<List<Integer>> paths = task797.allPathsSourceTarget(new int[][]{
                {4, 3, 1},
                {3, 2, 4},
                {3},
                {4},
                {}
        });
        for (List<Integer> path : paths){
            for (int node : path){
                System.out.print(node + " ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(paths, path, graph, 0);
        return paths;
    }

    public void dfs(List<List<Integer>> paths, List<Integer> path, int[][] graph, int node){
        if (node == graph.length-1){
            paths.add(new ArrayList<>(path));
            return;
        }
        for (int nextNode : graph[node]){
            path.add(nextNode);
            dfs(paths, path, graph, nextNode);
            path.remove(path.size() - 1);
        }
    }
}
