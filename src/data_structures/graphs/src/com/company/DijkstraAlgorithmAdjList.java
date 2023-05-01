import java.util.*;

public class DijkstraAlgorithm {

    private static int INF = Integer.MAX_VALUE;

    static class Edge {
        int dest;
        int weight;
        Edge(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    public static int[] dijkstra(List<List<Edge>> adjList, int source) {
        int n = adjList.size();
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

            for (Edge e : adjList.get(u)) {
                int v = e.dest;
                int alt = dist[u] + e.weight;
                if (!visited[v] && alt < dist[v]) {
                    dist[v] = alt;
                    pq.offer(v);
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        List<List<Edge>> adjList = new ArrayList<>();
        adjList.add(Arrays.asList(new Edge(1, 2), new Edge(3, 6))); // node 0
        adjList.add(Arrays.asList(new Edge(0, 2), new Edge(2, 3), new Edge(3, 8), new Edge(4, 5))); // node 1
        adjList.add(Arrays.asList(new Edge(1, 3), new Edge(4, 7))); // node 2
        adjList.add(Arrays.asList(new Edge(0, 6), new Edge(1, 8), new Edge(4, 9))); // node 3
        adjList.add(Arrays.asList(new Edge(1, 5), new Edge(2, 7), new Edge(3, 9))); // node 4
        int[] dist = dijkstra(adjList, 0);
        System.out.println(Arrays.toString(dist)); // Output: [0, 2, 5, 6, 7]
    }
}
