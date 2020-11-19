package warm.graph;

import java.util.ArrayList;

public class DirectedGraph {
    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> g = new ArrayList<>();
        int v = 5;
        for (int i = 0; i < v; i++) {
            g.add(i, new ArrayList<>());
        }
        addEdge(g, 0, 1);
        addEdge(g, 0, 2);
        addEdge(g, 0, 3);
        // addEdge(g, 1, 2);
        addEdge(g, 2, 4);
        addEdge(g, 4, 1);

        System.out.println(dfs(g, v));

    }

    private static boolean dfs(ArrayList<ArrayList<Integer>> g, int V) {
        boolean visited[] = new boolean[V];
        boolean recCallStack[] = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfsRec(g, i, visited, recCallStack))
                    return true;
            }
        }
        return false;
    }

    private static boolean dfsRec(ArrayList<ArrayList<Integer>> g, int s, boolean visited[], boolean recCallStack[]) {
        visited[s] = true;
        recCallStack[s] = true;
        for (int u : g.get(s)) {
            if (!visited[u]) {
                if (dfsRec(g, u, visited, recCallStack))
                    return true;
            } else if (recCallStack[u]) { // cycle
                return true;
            }
        }
        recCallStack[s] = false;
        return false;
    }

    static void addEdge(ArrayList<ArrayList<Integer>> g, int u, int v) {
        g.get(u).add(v);
    }

}
