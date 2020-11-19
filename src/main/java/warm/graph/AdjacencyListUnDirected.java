package warm.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Add edge Remove edge remove vertex print graph findIndex findAdjacency
 * 
 * 
 * BFS - Traversal - Disconnected components
 * 
 * 
 * DFS - Traversal - Disconnected components - Cycle detection
 * 
 * 
 * @author dharamrajverma
 *
 */
public class AdjacencyListUnDirected {

    public static void main(String[] args) throws Exception {
        AdjacencyListUnDirected al = new AdjacencyListUnDirected();

        int v = 7;
        List<List<Integer>> graph = new ArrayList<>(v);

        for (int i = 0; i < v; i++) {
            graph.add(i, new ArrayList<>());
        }

        al.addEdge(graph, 0, 1);
        al.addEdge(graph, 1, 2);
        al.addEdge(graph, 1, 3);
        // al.addEdge(graph, 2, 3);
        al.addEdge(graph, 2, 4);
        al.addEdge(graph, 4, 5);
        al.addEdge(graph, 5, 6);

        al.print(graph);

        // al.findAdjacency(graph, 2);
        // al.removeEdge(graph, 0, 2);
        // al.print(graph);
        // al.findAdjacency(graph, 2);

        // al.BFSDisconncetd(graph, v);

        al.DFS(graph, v);
    }

    private void addEdge(List<List<Integer>> graph, int v, int u) {
        graph.get(v).add(u);
        graph.get(u).add(v);
    }

    private void removeEdge(List<List<Integer>> graph, int v, int u) throws Exception {
        int indexInV = findIndex(graph.get(v), u);
        int indexInU = findIndex(graph.get(u), v);

        graph.get(v).remove(indexInV);
        graph.get(u).remove(indexInU);

    }

    private static int findIndex(List<Integer> vertices, int value) throws Exception {
        for (int i = 0; i < vertices.size(); i++) {
            if (vertices.get(i) == value) {
                return i;
            }
        }
        throw new Exception("No edge exist " + value);
    }

    private void findAdjacency(List<List<Integer>> graph, int u) {
        List<Integer> adj = graph.get(u);
        System.out.println("adjacency of " + u);
        for (int v : adj) {
            System.out.print(v + " ");
        }
        System.out.println();
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

    private void BFSDisconncetd(List<List<Integer>> graph, int v) {
        boolean visited[] = new boolean[v];
        int connectedComponants = 0;
        for (int i = 0; i < graph.size(); i++) {
            if (!visited[i]) {
                BFS(graph, i, visited);
                connectedComponants++;
            }
        }
        System.out.println("connectedComponants " + connectedComponants);
    }

    /**
     * BFS (level order traversal)
     * 
     * source is given
     * 
     * @param graph
     * @param source
     */

    private void BFS(List<List<Integer>> graph, int source, boolean visited[]) {
        System.out.println(" ============ levelOrderTraversal ==== ");
        LinkedList<Integer> Q = new LinkedList<>();
        Q.add(source);
        visited[source] = true;
        while (!Q.isEmpty()) {
            int size = Q.size();
            while (--size >= 0) {
                int v = Q.poll();
                System.out.print(v + " ");
                List<Integer> adj = graph.get(v);
                for (int u : adj) {
                    if (visited[u] == false) {
                        Q.add(u);
                        visited[u] = true;
                    }
                }
            }
            System.out.println();
        }

    }

    /**
     * DFS traversal
     * 
     * @param graph
     * @param vertices
     */
    private void DFS(List<List<Integer>> graph, int vertices) {
        int conncetedComponants = 0;
        boolean isCycleExist = false;
        boolean visited[] = new boolean[vertices];
        for (int i = 0; i < vertices; i++) {
            if (visited[i] == false) {
                visited[i] = true;
                isCycleExist = DFSRecursive(graph, i, visited, -1);
                System.out.println(" conncetedComponants " + conncetedComponants + " " + i);
                conncetedComponants++;
            }
        }

        //note: in case of cycle exist, components count will not correct(create separate method). 
        System.out.println("conncetedComponants " + conncetedComponants);
        System.out.println("isCycleExist " + isCycleExist);
    }

    /**
     * DFS
     * 
     * @param graph
     * @param source
     * @param visited
     */
    private boolean DFSRecursive(List<List<Integer>> graph, int source, boolean visited[], int parent) {
        List<Integer> adj = graph.get(source);
        // System.out.print(source + " ");
        for (int v : adj) {
            if (!visited[v]) {
                visited[v] = true;
                if (DFSRecursive(graph, v, visited, source)) {
                    return true;
                }
            } else if (v != parent) {
                System.out.println(source + " cycle " + v);
                return true;
            }
        }
        return false;
    }

}
