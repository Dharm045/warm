package warm.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopologicalSort {

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> g = new ArrayList<>();
        int v = 4;
        for (int i = 0; i < v; i++) {
            g.add(i, new ArrayList<>());
        }
        // addEdge(g, 0, 1);
        // addEdge(g, 0, 2);
        // addEdge(g, 0, 3);
        // //addEdge(g, 1, 2);
        // addEdge(g, 2, 4);
        // addEdge(g, 4, 1);

        addEdge(g, 3, 0);
        addEdge(g, 1, 0);
        addEdge(g, 2, 0);

        int topo[] = topoSort(g, v);
        for (int i = 0; i < topo.length; i++) {
            System.out.print(topo[i] + " ");
        }
        System.out.println();
    }

    static int[] topoSort(ArrayList<ArrayList<Integer>> adj, int V) {
        boolean visited[] = new boolean[V];
        int topo[] = new int[V];
        int degree[] = new int[V];

        Queue<Integer> Q = new LinkedList<>();

        for (int i = 0; i < V; i++) {
            degree[i] = adj.get(i).size();
            if (degree[i] == 0) {
                Q.add(i);
            }
        }

        int index = 0;
        while (!Q.isEmpty()) {
            int v = Q.poll();
            topo[index++] = v;
            decreaseDegree(degree, adj, v, visited, Q, V);
        }
        int topoArr[] = new int[V];
        index = 0;
        for (int i = V-1; i >=0; i--) {
            topoArr[index++] = topo[i];
        }
        return topoArr;
    }

    static void decreaseDegree(int degree[], ArrayList<ArrayList<Integer>> adj, int v, boolean visited[],
            Queue<Integer> Q, int N) {
        for (int i = 0; i < adj.size(); i++) {
            for (int u : adj.get(i)) {
                if (u == v) {
                    degree[i]--;
                    if (degree[i] == 0 && !visited[i]) {
                        Q.add(i);
                    }
                }
            }
        }
    }

    static void addEdge(ArrayList<ArrayList<Integer>> g, int u, int v) {
        g.get(u).add(v);
    }

}
