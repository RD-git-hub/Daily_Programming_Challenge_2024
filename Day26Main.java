import java.util.*;

public class Day26Main {
    public static boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(i, -1, visited, adj)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(int v, int parent, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
        visited[v] = true;
        for (int neighbor : adj.get(v)) {
            if (!visited[neighbor]) {
                if (dfs(neighbor, v, visited, adj)) {
                    return true;
                }
            } else if (neighbor != parent) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int V = 5;
        int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {3, 4}, {4, 0}};
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        System.out.println(isCyclic(V, adj));
    }
}
