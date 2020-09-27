package warm.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ShortestPathUnweighted {

    public static void main(String[] args) throws Exception {
        ShortestPathUnweighted sp = new ShortestPathUnweighted();

        int v = 7;
        List<List<Integer>> graph = new ArrayList<>(v);

        for (int i = 0; i < v; i++) {
            graph.add(i, new ArrayList<>());
        }

        sp.addEdge(graph, 0, 1);
        sp.addEdge(graph, 0, 4);
        sp.addEdge(graph, 1, 2);
        sp.addEdge(graph, 2, 3);
        sp.addEdge(graph, 4, 5);
        sp.addEdge(graph, 4, 6);
        sp.addEdge(graph, 5, 6);
        sp.print(graph);

        int distance[] = sp.shortestPath(graph, 0, v);
        System.out.println("Distance");
        for(int i = 0; i < v; i ++) {
            System.out.println(i+" "+distance[i]);
        }

    }

    private void addEdge(List<List<Integer>> graph, int v, int u) {
        graph.get(v).add(u);
        graph.get(u).add(v);
    }

    private void print(List<List<Integer>> graph) {
        for (int v = 0; v < graph.size(); v++) {
            List<Integer> edges = graph.get(v);
            System.out.print(v + ": ");
            for (int e : edges) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }

    /**
     * Shortest path from source to every other node. 
     * BFS
     * 
     * @param graph
     * @param source
     * @param vertices
     */
    private int[] shortestPath(List<List<Integer>> graph, int source, int vertices) {

        LinkedList<Integer> Q = new LinkedList<>();
        boolean visited[] = new boolean[vertices];
        int distance[] = new int[vertices];
        Q.add(source);
        visited[source] = true;
        distance[source] = 0;
        while (!Q.isEmpty()) {
            int size = Q.size();
            while (--size >= 0) {
                int u = Q.poll();
                for (int v : graph.get(u)) {
                    if (!visited[v]) {
                        Q.add(v);
                        visited[v] = true;
                        distance[v] = distance[u] + 1;
                        if(v == 0) {
                            System.out.println("WTF "+v);
                        }
                    }
                }
            }
        }
        return distance;
    }
}
