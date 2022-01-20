package graph;

import java.util.*;

public class Task1971 {
    public static void main(String[] args) {
        Task1971 task1971 = new Task1971();
        System.out.println(task1971.validPath(6, new int[][]{
                {0, 1},
                {1, 2},
                {3, 5},
                {5, 4},
                {4, 3},
        }, 0, 5));
    }

    public boolean validPath(int n, int[][] edges, int start, int end) {
        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nodes.add(new Node(i));
        }

        for (int[] edge : edges) {
            nodes.get(edge[0]).incidentNodes.add(nodes.get(edge[1]));
            nodes.get(edge[1]).incidentNodes.add(nodes.get(edge[0]));
        }

        return hasPath(nodes, start, end);
    }

    public boolean hasPath(List<Node> nodes, int start, int end){
        Queue<Node> nodeQueue = new LinkedList<>();
        Set<Node> visited = new HashSet<>();
        nodeQueue.add(nodes.get(start));
        while (!nodeQueue.isEmpty()){
            Node currentNode = nodeQueue.poll();
            visited.add(currentNode);
            if (currentNode.nodeNumber == end)
                return true;
            for (Node node : currentNode.incidentNodes)
                if (!visited.contains(node))
                    nodeQueue.offer(node);
        }
        return false;
    }

    private static class Node{
        final int nodeNumber;
        final List<Node> incidentNodes = new ArrayList<>();

        public Node(int nodeNumber) {
            this.nodeNumber = nodeNumber;
        }
    }
}
