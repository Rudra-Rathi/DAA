import java.util.*;

public class BellmanFord {
    static class Edge {
        int source, destination, weight;

        Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    int V, E;
    List<Edge> edges;

    BellmanFord(int v, int e) {
        V = v;
        E = e;
        edges = new ArrayList<>();
    }

    void addEdge(int source, int destination, int weight) {
        edges.add(new Edge(source, destination, weight));
    }

    void bellmanFord(int source) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        for (int i = 1; i < V; ++i) {
            for (Edge edge : edges) {
                if (dist[edge.source] != Integer.MAX_VALUE && dist[edge.source] + edge.weight < dist[edge.destination]) {
                    dist[edge.destination] = dist[edge.source] + edge.weight;
                }
            }
        }

        for (Edge edge : edges) {
            if (dist[edge.source] != Integer.MAX_VALUE && dist[edge.source] + edge.weight < dist[edge.destination]) {
                System.out.println("Graph contains a negative weight cycle");
                return;
            }
        }

        printDistances(dist);
    }

    void printDistances(int[] dist) {
        System.out.println("Vertex Distance from Source:");
        for (int i = 0; i < V; i++) {
            System.out.println(i + "\t\t" + (dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int V = scanner.nextInt();
        System.out.print("Enter number of edges: ");
        int E = scanner.nextInt();

        BellmanFord graph = new BellmanFord(V, E);

        System.out.println("Enter edges (source destination weight):");
        for (int i = 0; i < E; i++) {
            int source = scanner.nextInt();
            int destination = scanner.nextInt();
            int weight = scanner.nextInt();
            graph.addEdge(source, destination, weight);
        }

        System.out.print("Enter source vertex: ");
        int source = scanner.nextInt();

        graph.bellmanFord(source);
        scanner.close();
    }
}