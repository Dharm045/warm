package warm.graph;

import java.util.ArrayList;
import java.util.List;

public class DFSofGraph {

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> g = new ArrayList<>();
        int v = 5;
        for (int i = 0; i < v; i++) {
            g.add(i, new ArrayList<>());
        }
        addEdge(g, 0, 1);
        addEdge(g, 0, 2);
        addEdge(g, 0, 3);
        addEdge(g, 2, 4);
      //  addEdge(g, 4, 1);

        System.out.println(dfs(g, v));

    }

    static void addEdge(ArrayList<ArrayList<Integer>> g, int u, int v) {
        g.get(u).add(v);
       // g.get(v).add(u);

    }

    static boolean dfs(ArrayList<ArrayList<Integer>> g, int V) {
        boolean visited[] = new boolean[V];
        boolean cycle = false;
        for (int i = 0; i < g.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                if (dfsRec(g, i, visited, -1)) {
                    return true;
                }
            }
        }
        return cycle;
    }

    static boolean dfsRec(ArrayList<ArrayList<Integer>> g, int source, boolean visited[], int p) {
        List<Integer> adj = g.get(source);
        for (int v : adj) {
            if (!visited[v]) {
                visited[v] = true;
                if (dfsRec(g, v, visited, source))
                    return true;
            } else if (v != p) {
                return true;
            }
        }
        return false;
    }

}
