package warm.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Do the DFS from each vertex For DFS from each vertex, keep track of visiting
 * vertices in a recursion stack (array). If you encounter a vertex which
 * already present in recursion stack then we have found a cycle. Use visited[]
 * for DFS to keep track of already visited vertices.
 * 
 * @author dharamrajverma
 *
 */
public class AdjacencyListDirected {

    public static void main(String[] args) throws Exception {
        AdjacencyListDirected al = new AdjacencyListDirected();

        int V = 5;
        List<List<Integer>> graph = new ArrayList<>(V);

        for (int i = 0; i < V; i++) {
            graph.add(i, new ArrayList<>());
        }

        al.addEdge(graph, 0, 1);
        al.addEdge(graph, 1, 2);
        // al.addEdge(graph, 1, 1);
        // al.addEdge(graph, 1, 4);
        // al.addEdge(graph, 2, 3);
        al.print(graph);
        // System.out.println("is cycle exist " + al.isCycle_DFS(graph, v));
        // al.topologicalSort(graph, v);
        System.out.println(al.isCycle_BFS(graph, V));

    }

    private void addEdge(List<List<Integer>> graph, int v, int u) {
        graph.get(v).add(u);
    }

    /**
     * Detect cycle in graph
     * 
     * @param graph
     * @param vertices
     * @return
     */
    private boolean isCycle_DFS(List<List<Integer>> graph, int vertices) {

        boolean visited[] = new boolean[vertices];
        boolean loopStack[] = new boolean[vertices];

        for (int i = 0; i < graph.size(); i++) {
            if (!visited[i]) {
                if (isCycle_DFSRec(graph, i, visited, loopStack)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 
     * @param graph
     * @param vertex
     * @param visited
     * @param loopStack
     * @return
     */
    private boolean isCycle_DFSRec(List<List<Integer>> graph, int vertex, boolean[] visited, boolean[] loopStack) {
        visited[vertex] = true;
        loopStack[vertex] = true;

        List<Integer> adj = graph.get(vertex);
        if (!adj.isEmpty()) {
            for (int i : adj) {
                if (visited[i] == false) {
                    if (isCycle_DFSRec(graph, i, visited, loopStack)) {
                        return true;
                    }
                } else if (loopStack[i] == true) {
                    System.out.println("detect at  " + i + " " + vertex);
                    return true;
                }
            }
        }
        loopStack[vertex] = false;
        return false;
    }

    /**
     * Print directed graph in topological sorted order.
     * 
     * @param graph
     * @param vertices
     */
    private void topologicalSort(List<List<Integer>> graph, int vertices) {
        LinkedList<Integer> Q = new LinkedList<>();
        int degree[] = new int[vertices];

        for (int i = 0; i < vertices; i++) {
            List<Integer> adj = graph.get(i);
            for (int av : adj) {
                degree[av]++;
            }
        }

        System.out.println("Degree ");
        for (int i = 0; i < vertices; i++) {
            System.out.println(i + " " + degree[i]);
            if (degree[i] == 0) {
                Q.add(i);
            }
        }

        System.out.println("Topological sort ");
        while (!Q.isEmpty()) {
            int s = Q.pop();
            System.out.print(s + " ");
            List<Integer> adj = graph.get(s);
            if (!adj.isEmpty()) {
                for (int av : adj) {
                    degree[av]--;
                    if (degree[av] == 0) {
                        Q.add(av);
                    }
                }
            }
        }
    }

    /**
     * Same as in topological sort. Only change check the any vertex is left that is
     * not visited in topological sort. In case cycle exists - No 0 in degree vertex
     * will find and loop will exist without visiting all vertices.
     * 
     * @param graph
     * @param vertices
     * @return
     */
    private boolean isCycle_BFS(List<List<Integer>> graph, int vertices) {
        LinkedList<Integer> Q = new LinkedList<>();
        int degree[] = new int[vertices];

        for (int i = 0; i < vertices; i++) {
            List<Integer> adj = graph.get(i);
            for (int av : adj) {
                degree[av]++;
            }
        }

        System.out.println("Degree ");
        for (int i = 0; i < vertices; i++) {
            System.out.println(i + " " + degree[i]);
            if (degree[i] == 0) {
                Q.add(i);
            }
        }

        System.out.println("Topological sort ");
        int visitedVertices = 0;
        while (!Q.isEmpty()) {
            int s = Q.pop();
            System.out.print(s + " ");
            List<Integer> adj = graph.get(s);
            if (!adj.isEmpty()) {
                for (int av : adj) {
                    degree[av]--;
                    if (degree[av] == 0) {
                        Q.add(av);
                    }
                }
            }
            visitedVertices++;
        }
        System.out.println();
        return visitedVertices != vertices;
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
}
