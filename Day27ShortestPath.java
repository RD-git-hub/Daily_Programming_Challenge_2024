import java.util.*;

public class Day27ShortestPath {
    public static int findShortestPath(int V, List<List<Integer>> edges, int start, int end) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }
        for (List<Integer> edge : edges) {
            graph.get(edge.get(0)).add(edge.get(1));
            graph.get(edge.get(1)).add(edge.get(0));
        }
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[V];
        int[] distance = new int[V];
        Arrays.fill(distance, -1);
        queue.add(start);
        visited[start] = true;
        distance[start] = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    distance[neighbor] = distance[node] + 1;
                    queue.add(neighbor);
                    if (neighbor == end) {
                        return distance[neighbor];
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int V = 5;
        List<List<Integer>> edges = Arrays.asList(Arrays.asList(0, 1), Arrays.asList(0, 2), Arrays.asList(1, 3), Arrays.asList(2, 3), Arrays.asList(3, 4));
        int start = 0;
        int end = 4;
        System.out.println(findShortestPath(V, edges, start, end));
    }
}
