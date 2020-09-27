package warm.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Shorted path in weighted directed acyclic graph
 * 
 * @author dharamrajverma
 *
 */

public class ShortestPathInDAG {

    class Node {
        int weight;
        int vertex;

        public Node(int weight, int vertex) {
            this.weight = weight;
            this.vertex = vertex;
        }
    }

    public static void main(String[] args) {

        int V = 4;
        List<List<Node>> graph = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            graph.add(i, new ArrayList<Node>());
        }

        ShortestPathInDAG spDAG = new ShortestPathInDAG();
        // spDAG.addEdge(graph, 2, 0, 1);
        // spDAG.addEdge(graph, 3, 1, 2);
        // spDAG.addEdge(graph, 6, 2, 3);
        // spDAG.addEdge(graph, 1, 0, 4);
        // spDAG.addEdge(graph, 2, 4, 2);
        // spDAG.addEdge(graph, 4, 4, 5);
        // spDAG.addEdge(graph, 1, 5, 3);

        spDAG.addEdge(graph, 1, 0, 1);
        spDAG.addEdge(graph, 3, 1, 2);
        spDAG.addEdge(graph, 4, 2, 3);
        spDAG.addEdge(graph, 2, 1, 3);

        spDAG.shortestPathInDAG(graph, 1, V);
    }

    private void addEdge(List<List<Node>> graph, int w, int u, int v) {
        graph.get(u).add(new Node(w, v));
    }

    /**
     * 
     * @param graph
     * @param vertices
     */
    private void shortestPathInDAG(List<List<Node>> graph, int source, int vertices) {
        boolean visited[] = new boolean[vertices];
        int shortestPath[] = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            shortestPath[i] = Integer.MAX_VALUE;
        }
        LinkedList<Integer> Q = new LinkedList<>();
        Q.push(source);
        visited[source] = true;
        shortestPath[source] = 0;

        while (!Q.isEmpty()) {
            int s = Q.poll();
            List<Node> adj = graph.get(s);
            for (Node n : adj) {
                shortestPath[n.vertex] = Math.min((n.weight + shortestPath[s]), shortestPath[n.vertex]);
                if (visited[n.vertex] == false) {
                    Q.push(n.vertex);
                }
            }
        }
        for (int i = 0; i < vertices; i++) {
            System.out.println(i + ": " + shortestPath[i] + " ");
        }
    }

}
