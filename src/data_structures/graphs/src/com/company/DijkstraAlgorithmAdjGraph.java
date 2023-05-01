import java.util.*;

public class DijkstraAlgorithm {

    private static int INF = Integer.MAX_VALUE;

    public static int[] dijkstra(int[][] graph, int source) {
        int n = graph.length;
        int[] dist = new int[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(dist, INF);
        dist[source] = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>((u, v) -> dist[u] - dist[v]);
        pq.offer(source);

        while (!pq.isEmpty()) {
            int u = pq.poll();
            if (visited[u]) {
                continue;
            }
            visited[u] = true;

            for (int v = 0; v < n; v++) {
                if (graph[u][v] != 0 && !visited[v]) {
                    int alt = dist[u] + graph[u][v];
                    if (alt < dist[v]) {
                        dist[v] = alt;
                        pq.offer(v);
                    }
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        int[][] graph = {
            {0, 2, 0, 6, 0},
            {2, 0, 3, 8, 5},
            {0, 3, 0, 0, 7},
            {6, 8, 0, 0, 9},
            {0, 5, 7, 9, 0}
        };
        int[] dist = dijkstra(graph, 0);
        System.out.println(Arrays.toString(dist)); // Output: [0, 2, 5, 6, 7]
    }
}
